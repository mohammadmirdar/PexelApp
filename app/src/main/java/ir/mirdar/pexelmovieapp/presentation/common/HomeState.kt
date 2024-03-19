package ir.mirdar.pexelmovieapp.presentation.common

import ir.mirdar.pexelmovieapp.data.common.CallErrors
import ir.mirdar.pexelmovieapp.domain.models.CuratedModel
import ir.mirdar.pexelmovieapp.domain.models.PhotoModel


sealed class HomeState : ViewState {
    data object Loading : HomeState()
    data class ResultAllUpcomingList(val data : List<PhotoModel>): HomeState()
    data class Exception(val callErrors: CallErrors) : HomeState()
}