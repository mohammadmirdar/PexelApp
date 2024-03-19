package ir.mirdar.pexelmovieapp.data.remote

import ir.mirdar.pexelmovieapp.data.common.CallErrors
import ir.mirdar.pexelmovieapp.data.common.Result
import ir.mirdar.pexelmovieapp.data.common.applyCommonSideEffects
import ir.mirdar.pexelmovieapp.data.remote.model.toModel
import ir.mirdar.pexelmovieapp.domain.models.CuratedModel
import ir.mirdar.pexelmovieapp.domain.repositories.RemoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor (private val apiService: ApiService) :
    RemoteRepository {
    override fun getUpcomingList(page: Int): Flow<Result<CuratedModel>> = flow {
        apiService.getUpcomingList(page).run {
            if (this.isSuccessful) {
                if (this.body() == null) {
                    emit(Result.Error(CallErrors.ErrorEmptyData))
                } else {
                    emit(Result.Success(this.body()!!.toModel()))
                }
            } else {
                emit(Result.Error(CallErrors.ErrorServer))
            }
        }
    }.applyCommonSideEffects()
}