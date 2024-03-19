package ir.mirdar.pexelmovieapp.presentation.common

import ir.mirdar.pexelmovieapp.data.common.Result
import ir.mirdar.pexelmovieapp.domain.models.CuratedModel
import ir.mirdar.pexelmovieapp.domain.models.PhotoModel
import ir.mirdar.pexelmovieapp.presentation.detail.DetailState
import ir.mirdar.pexelmovieapp.presentation.discovery.HomeState

/**
 * Created by Rim Gazzah on 8/31/20.
 **/

fun Result<CuratedModel>.reduce(): HomeState {
    return when (this) {
        is Result.Success -> HomeState.ResultAllUpcomingList(data.photos)
        is Result.Error -> HomeState.Exception(exception)
        is Result.Loading -> HomeState.Loading
    }
}

fun Result<PhotoModel?>.reduce() : DetailState {
    return when (this) {
        is Result.Error -> DetailState.Exception(exception)
        is Result.Loading -> DetailState.Loading
        is Result.Success -> DetailState.ResultImageDetail(data)
    }
}