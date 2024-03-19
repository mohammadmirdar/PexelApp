package ir.mirdar.pexelmovieapp.data.local

import io.realm.kotlin.Realm
import ir.mirdar.pexelmovieapp.data.local.model.RealmCurated
import ir.mirdar.pexelmovieapp.data.local.model.toModel
import ir.mirdar.pexelmovieapp.domain.models.CuratedModel
import ir.mirdar.pexelmovieapp.domain.models.toEntity
import ir.mirdar.pexelmovieapp.domain.repositories.LocalRepository
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    private val realm: Realm
) : LocalRepository {
    override fun insertUpcomingModel(curatedModel: CuratedModel) {
        realm.writeBlocking {
            copyToRealm(curatedModel.toEntity())
        }
    }

    override fun readResultModels(page: Int) : CuratedModel? {
        val realmUpcomingModel = realm.query(RealmCurated::class, "page == $page").first().find()
        return realmUpcomingModel?.toModel()
    }
}