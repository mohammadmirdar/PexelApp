package ir.mirdar.pexelmovieapp.domain.repositories

import ir.mirdar.pexelmovieapp.domain.models.CuratedModel
import ir.mirdar.pexelmovieapp.domain.models.PhotoModel

interface LocalRepository {

    fun insertUpcomingModel(upcomingModel: CuratedModel)

    fun readResultModels(page : Int): CuratedModel?
    fun readImageDetail(photoId: Long): PhotoModel?
}