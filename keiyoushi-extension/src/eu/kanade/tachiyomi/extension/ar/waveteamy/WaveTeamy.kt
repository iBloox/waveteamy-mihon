package eu.kanade.tachiyomi.extension.ar.waveteamy

import eu.kanade.tachiyomi.network.GET
import eu.kanade.tachiyomi.source.model.FilterList
import eu.kanade.tachiyomi.source.model.MangasPage
import eu.kanade.tachiyomi.source.model.Page
import eu.kanade.tachiyomi.source.model.SChapter
import eu.kanade.tachiyomi.source.model.SManga
import eu.kanade.tachiyomi.source.online.ParsedHttpSource
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import java.text.SimpleDateFormat
import java.util.Locale

class WaveTeamy : ParsedHttpSource() {

    override val name = "WaveTeamy"

    override val baseUrl = "https://waveteamy.com"

    override val lang = "ar"

    override val supportsLatest = true

    override val client: OkHttpClient = network.cloudflareClient

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)

    // Popular Manga
    override fun popularMangaRequest(page: Int): Request {
        return GET("$baseUrl/manga/?page=$page&order=popular", headers)
    }

    override fun popularMangaSelector() = "div.page-item-detail"

    override fun popularMangaFromElement(element: Element): SManga {
        return SManga.create().apply {
            element.select("div.item-thumb a").first()?.let {
                setUrlWithoutDomain(it.attr("href"))
                thumbnail_url = it.select("img").attr("abs:data-src")
                    .ifEmpty { it.select("img").attr("abs:src") }
            }
            title = element.select("h3.h5 a").text()
        }
    }

    override fun popularMangaNextPageSelector() = "div.nav-previous a, a.next"

    // Latest Updates
    override fun latestUpdatesRequest(page: Int): Request {
        return GET("$baseUrl/manga/?page=$page&order=latest", headers)
    }

    override fun latestUpdatesSelector() = popularMangaSelector()

    override fun latestUpdatesFromElement(element: Element) = popularMangaFromElement(element)

    override fun latestUpdatesNextPageSelector() = popularMangaNextPageSelector()

    // Search
    override fun searchMangaRequest(page: Int, query: String, filters: FilterList): Request {
        val url = "$baseUrl/".toHttpUrl().newBuilder()
            .addPathSegment("")
            .addQueryParameter("s", query)
            .addQueryParameter("post_type", "wp-manga")
            .addQueryParameter("page", page.toString())
            .build()
        return GET(url, headers)
    }

    override fun searchMangaSelector() = popularMangaSelector()

    override fun searchMangaFromElement(element: Element) = popularMangaFromElement(element)

    override fun searchMangaNextPageSelector() = popularMangaNextPageSelector()

    // Manga Details
    override fun mangaDetailsParse(document: Document): SManga {
        return SManga.create().apply {
            document.select("div.summary_content").let { info ->
                title = document.select("div.post-title h1").text()
                author = info.select("div.author-content a").text()
                artist = author
                
                val statusText = info.select("div.summary-content:contains(الحالة)").text()
                status = when {
                    statusText.contains("مستمرة", ignoreCase = true) -> SManga.ONGOING
                    statusText.contains("مكتملة", ignoreCase = true) -> SManga.COMPLETED
                    else -> SManga.UNKNOWN
                }
                
                genre = info.select("div.genres-content a").joinToString { it.text() }
                description = document.select("div.summary__content p").text()
                thumbnail_url = document.select("div.summary_image img").attr("abs:data-src")
                    .ifEmpty { document.select("div.summary_image img").attr("abs:src") }
            }
        }
    }

    // Chapters
    override fun chapterListSelector() = "li.wp-manga-chapter"

    override fun chapterFromElement(element: Element): SChapter {
        return SChapter.create().apply {
            element.select("a").first()?.let {
                setUrlWithoutDomain(it.attr("href"))
                name = it.text()
            }
            date_upload = element.select("span.chapter-release-date").text().let {
                try {
                    dateFormat.parse(it)?.time ?: 0L
                } catch (e: Exception) {
                    0L
                }
            }
        }
    }

    // Pages
    override fun pageListParse(document: Document): List<Page> {
        return document.select("div.reading-content img, div.page-break img").mapIndexed { index, element ->
            Page(
                index,
                "",
                element.attr("abs:data-src").ifEmpty { element.attr("abs:src") }
            )
        }
    }

    override fun imageUrlParse(document: Document): String = throw UnsupportedOperationException()

    override fun getFilterList() = FilterList()
}
