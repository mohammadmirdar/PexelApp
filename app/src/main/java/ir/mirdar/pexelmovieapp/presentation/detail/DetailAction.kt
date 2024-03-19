package ir.mirdar.pexelmovieapp.presentation.detail

import ir.mirdar.pexelmovieapp.presentation.common.ViewAction

sealed class DetailAction : ViewAction {

    data class LoadImage(val photoId : Long) : DetailAction()
}