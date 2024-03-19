package ir.mirdar.pexelmovieapp.presentation.detail

import ir.mirdar.pexelmovieapp.presentation.common.ViewIntent

sealed class DetailIntent : ViewIntent {

    data class LoadImageDetail(val photoId : Long) : DetailIntent()
}