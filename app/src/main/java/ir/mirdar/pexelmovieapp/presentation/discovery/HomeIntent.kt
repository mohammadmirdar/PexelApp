package ir.mirdar.pexelmovieapp.presentation.discovery

import ir.mirdar.pexelmovieapp.presentation.common.ViewIntent


sealed class HomeIntent : ViewIntent {
    data class LoadUpcomingList(val page: Int) : HomeIntent()
}