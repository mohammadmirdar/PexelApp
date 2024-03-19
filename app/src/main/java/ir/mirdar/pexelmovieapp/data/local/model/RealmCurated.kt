package ir.mirdar.pexelmovieapp.data.local.model

import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import ir.mirdar.pexelmovieapp.domain.models.CuratedModel
import ir.mirdar.pexelmovieapp.domain.models.PhotoModel
import org.mongodb.kbson.ObjectId

open class RealmCurated: RealmObject {
    @PrimaryKey
    var id: ObjectId = ObjectId()
    var page: Int? = null
    var photos: RealmList<RealmPhoto> = realmListOf()
}

fun List<RealmPhoto>.toModel(): List<PhotoModel> = this.map { it.toModel() }
fun RealmCurated.toModel(): CuratedModel {
    return CuratedModel(
        page = page ?: 0,
        photos = photos.toModel()
    )
}