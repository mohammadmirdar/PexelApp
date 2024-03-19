package ir.mirdar.pexelmovieapp.domain.repositories

import ir.mirdar.pexelmovieapp.domain.models.CuratedModel

interface LocalRepository {

    fun insertUpcomingModel(upcomingModel: CuratedModel)

    fun readResultModels(page : Int): CuratedModel?
}