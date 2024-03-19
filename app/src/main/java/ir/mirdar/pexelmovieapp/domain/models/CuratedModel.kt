package ir.mirdar.pexelmovieapp.domain.models

import io.realm.kotlin.ext.toRealmList
import io.realm.kotlin.types.RealmList
import ir.mirdar.pexelmovieapp.data.local.model.RealmCurated
import ir.mirdar.pexelmovieapp.data.local.model.RealmPhoto

data class CuratedModel(
    val page: Int,
    val photos: List<PhotoModel>,
)

fun List<PhotoModel>.toEntity(): RealmList<RealmPhoto> {
    return this.map { it.toEntity() }.toRealmList()
}
fun CuratedModel.toEntity(): RealmCurated {
    return RealmCurated().also {
        it.page = page
        it.photos = photos.toEntity()
    }
}