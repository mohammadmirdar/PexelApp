package ir.mirdar.pexelmovieapp.presentation.common


sealed class HomeIntent : ViewIntent {
    data class LoadUpcomingList(val page: Int) : HomeIntent()
}