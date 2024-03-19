package ir.mirdar.pexelmovieapp.domain

import ir.mirdar.pexelmovieapp.data.common.Result
import ir.mirdar.pexelmovieapp.domain.models.PhotoModel
import ir.mirdar.pexelmovieapp.domain.repositories.LocalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetImageDetail @Inject constructor(
    private val localRepository: LocalRepository
) {
    suspend operator fun invoke(photoId : Long) = withContext(Dispatchers.IO) {
        flow {
            emit(Result.Loading)
            val photoModel = localRepository.readImageDetail(photoId)
            emit(Result.Success(photoModel))
        }
    }
}