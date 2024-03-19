package ir.mirdar.pexelmovieapp.presentation.common

import ir.mirdar.pexelmovieapp.data.common.Result
import ir.mirdar.pexelmovieapp.domain.models.CuratedModel

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