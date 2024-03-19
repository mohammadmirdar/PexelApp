package ir.mirdar.pexelmovieapp.presentation.discovery

import ir.mirdar.pexelmovieapp.data.common.CallErrors
import ir.mirdar.pexelmovieapp.domain.models.PhotoModel
import ir.mirdar.pexelmovieapp.presentation.common.ViewState


sealed class HomeState : ViewState {
    data object Loading : HomeState()
    data class ResultAllUpcomingList(val data : List<PhotoModel>): HomeState()
    data class Exception(val callErrors: CallErrors) : HomeState()
}