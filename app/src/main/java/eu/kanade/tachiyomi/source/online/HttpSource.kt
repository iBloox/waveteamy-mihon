package eu.kanade.tachiyomi.source.online

import eu.kanade.tachiyomi.source.Source
import okhttp3.Request
import okhttp3.Response

abstract class HttpSource : Source {
    abstract val baseUrl: String
    abstract val supportsLatest: Boolean
    
    protected fun GET(url: String): Request = Request.Builder().url(url).build()
    
    abstract fun popularMangaRequest(page: Int): Request
    abstract fun latestUpdatesRequest(page: Int): Request
    abstract fun searchMangaRequest(query: String, page: Int): Request
    
    abstract fun popularMangaParse(response: Response): Any
    abstract fun latestUpdatesParse(response: Response): Any
    abstract fun searchMangaParse(response: Response): Any
    abstract fun mangaDetailsParse(response: Response): Any
    abstract fun chapterListParse(response: Response): Any
    abstract fun pageListParse(response: Response): Any
}
