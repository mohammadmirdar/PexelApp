package ir.mirdar.pexelmovieapp.presentation.discovery

import ir.mirdar.pexelmovieapp.presentation.common.ViewAction


sealed class HomeAction : ViewAction {
    data class LoadList(val page: Int) : HomeAction()
}