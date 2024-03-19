package ir.mirdar.pexelmovieapp.data.local.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import ir.mirdar.pexelmovieapp.domain.models.PhotoModel
import org.mongodb.kbson.ObjectId

open class RealmPhoto : RealmObject {
    @PrimaryKey
    var id: ObjectId = ObjectId()
    var photoId: Long? = null
    var width: Long? = null
    var height: Long? = null
    var url: String? = null
    var photographer: String? = null
    var photographer_url: String? = null
    var photographer_id: Long? = null
    var avg_color: String? = null
    var alt: String? = null
    var liked: Boolean? = null
    var src: RealmSource? = null
}

fun RealmPhoto.toModel(): PhotoModel {
    return PhotoModel(
        photoId ?: 0,
        width ?: 0,
        height ?: 0,
        url ?: "",
        photographer ?: "",
        photographer_url ?: "",
        photographer_id ?: 0,
        avg_color ?: "",
        alt ?: "",
        liked ?: false,
        src?.toModel()!!,
    )
}