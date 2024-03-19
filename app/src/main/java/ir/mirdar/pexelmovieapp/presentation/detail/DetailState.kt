package ir.mirdar.pexelmovieapp.presentation.detail

import ir.mirdar.pexelmovieapp.data.common.CallErrors
import ir.mirdar.pexelmovieapp.domain.models.PhotoModel
import ir.mirdar.pexelmovieapp.presentation.common.ViewState
import ir.mirdar.pexelmovieapp.presentation.discovery.HomeState

sealed class DetailState : ViewState {

    data object Loading : DetailState()
    data class ResultImageDetail(val data : PhotoModel?): DetailState()
    data class Exception(val callErrors: CallErrors) : DetailState()
}