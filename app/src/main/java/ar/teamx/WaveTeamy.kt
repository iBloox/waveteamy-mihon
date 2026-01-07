package ar.teamx

import eu.kanade.tachiyomi.source.online.HttpSource
import okhttp3.Response

class WaveTeamy : HttpSource() {
    override val id: Long = 1234567890L
    override val name = "WaveTeamy"
    override val baseUrl = "https://waveteamy.com"
    override val lang = "ar"
    override val supportsLatest = true

    override fun popularMangaRequest(page: Int) = GET("$baseUrl/page/$page")
    override fun latestUpdatesRequest(page: Int) = GET("$baseUrl/latest/page/$page")
    override fun searchMangaRequest(query: String, page: Int) = GET("$baseUrl/search?q=$query&page=$page")

    override fun popularMangaParse(response: Response) = TODO()
    override fun latestUpdatesParse(response: Response) = TODO()
    override fun searchMangaParse(response: Response) = TODO()
    override fun mangaDetailsParse(response: Response) = TODO()
    override fun chapterListParse(response: Response) = TODO()
    override fun pageListParse(response: Response) = TODO()
}
