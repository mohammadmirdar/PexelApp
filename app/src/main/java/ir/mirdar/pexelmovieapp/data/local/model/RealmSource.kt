package ir.mirdar.pexelmovieapp.data.local.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import ir.mirdar.pexelmovieapp.domain.models.SourceModel
import org.mongodb.kbson.ObjectId

open class RealmSource : RealmObject {
    @PrimaryKey
    var id: ObjectId = ObjectId()
    var original: String? = null
    var large2x: String? = null
    var medium: String? = null
    var small: String? = null
    var portrait: String? = null
    var landscape: String? = null
    var tiny: String? = null
}

fun RealmSource.toModel(): SourceModel = SourceModel(
    original ?: "",
    large2x ?: "",
    medium ?: "",
    small ?: "",
    portrait ?: "",
    landscape ?: "",
    tiny ?: "",
)