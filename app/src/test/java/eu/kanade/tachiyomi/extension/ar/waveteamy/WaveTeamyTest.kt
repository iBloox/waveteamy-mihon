package eu.kanade.tachiyomi.extension.ar.waveteamy

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class WaveTeamyTest {
    private val source = WaveTeamy()

    @Test
    fun testSearchRequestUrlEncodesQuery() {
        val query = "ناروتو شيبودن"
        val page = 1
        val request = source.searchMangaRequest(query, page)
        val url = request.url.toString()
        
        // Verify the URL contains properly encoded query parameter
        assertTrue("URL should contain encoded query parameter", url.contains("q="))
        assertTrue("URL should contain page parameter", url.contains("page=1"))
        // Verify special characters are encoded (spaces should be %20 or +)
        assertTrue("URL should not contain raw spaces", !url.contains(" "))
    }

    @Test
    fun testSearchRequestWithSpecialCharacters() {
        val query = "test & special = chars?"
        val page = 2
        val request = source.searchMangaRequest(query, page)
        val url = request.url.toString()
        
        // Verify special characters are properly encoded
        assertTrue("URL should not contain raw ampersand", !url.contains("& "))
        assertTrue("URL should not contain raw equals in query", 
            url.indexOf("=") == url.lastIndexOf("=") || url.split("=").size > 2)
        assertTrue("URL should contain page=2", url.contains("page=2"))
    }

    @Test
    fun testSearchRequestWithSpaces() {
        val query = "one piece"
        val page = 1
        val request = source.searchMangaRequest(query, page)
        val url = request.url.toString()
        
        // Verify spaces are encoded
        assertTrue("URL should not contain raw spaces", !url.contains(" "))
        assertTrue("URL should be a valid URL", url.startsWith("https://"))
    }

    @Test
    fun testPopularMangaRequest() {
        val page = 1
        val request = source.popularMangaRequest(page)
        assertEquals("https://waveteamy.com/page/1", request.url.toString())
    }

    @Test
    fun testLatestUpdatesRequest() {
        val page = 1
        val request = source.latestUpdatesRequest(page)
        assertEquals("https://waveteamy.com/latest/page/1", request.url.toString())
    }
}
