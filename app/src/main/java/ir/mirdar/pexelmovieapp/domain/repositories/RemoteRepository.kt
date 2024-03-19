package ir.mirdar.pexelmovieapp.domain.repositories

import ir.mirdar.pexelmovieapp.data.common.Result
import ir.mirdar.pexelmovieapp.domain.models.CuratedModel
import kotlinx.coroutines.flow.Flow

interface RemoteRepository {

    fun getUpcomingList(page : Int) : Flow<Result<CuratedModel>>
}