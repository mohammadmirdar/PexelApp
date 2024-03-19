package ir.mirdar.pexelmovieapp.domain

import ir.mirdar.pexelmovieapp.data.common.Result
import ir.mirdar.pexelmovieapp.domain.models.CuratedModel
import ir.mirdar.pexelmovieapp.domain.repositories.LocalRepository
import ir.mirdar.pexelmovieapp.domain.repositories.RemoteRepository
import ir.mirdar.pexelmovieapp.presentation.common.Utils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetUpcomingList @Inject constructor(private val remoteRepository: RemoteRepository, private val localRepository: LocalRepository) {

    suspend operator fun invoke(page: Int) = withContext(Dispatchers.IO) {
        flow<Result<CuratedModel>> {
            remoteRepository.getUpcomingList(page).collect { response ->
                when (response) {
                    is Result.Success -> {
                        Utils.END_OF_PAGE = response.data.photos.isEmpty()
                        Utils.IS_LOADING = false
                        localRepository.insertUpcomingModel(response.data)
                        val localResult = localRepository.readResultModels(page)
                        localResult?.let {
                            emit(Result.Success(it))
                        }
                    }

                    is Result.Error -> {
                        val localResult = localRepository.readResultModels(page)
                        Utils.IS_LOADING = false
                        localResult?.let {
                            emit(Result.Success(it))
                        }
                    }

                    is Result.Loading -> {
                        Utils.IS_LOADING = true
                    }
                }
            }
        }
    }
}