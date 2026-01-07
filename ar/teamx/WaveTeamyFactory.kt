package ar.teamx

import eu.kanade.tachiyomi.source.Source
import eu.kanade.tachiyomi.source.SourceFactory

class WaveTeamyFactory : SourceFactory {
    override fun createSources(): List<Source> = listOf(
        WaveTeamy()
    )
}
