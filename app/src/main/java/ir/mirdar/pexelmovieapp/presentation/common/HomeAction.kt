package ir.mirdar.pexelmovieapp.presentation.common


sealed class HomeAction : ViewAction {
    data class LoadList(val page: Int) : HomeAction()
}