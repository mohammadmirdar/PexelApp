package ir.mirdar.pexelmovieapp.domain.models

import ir.mirdar.pexelmovieapp.data.local.model.RealmPhoto

data class PhotoModel(
    val id : Long,
    val width : Long,
    val height : Long,
    val url : String,
    val photographer : String,
    val photographer_url : String,
    val photographer_id : Long,
    val avg_color : String,
    val alt : String,
    val liked : Boolean,
    val src : SourceModel
)

fun PhotoModel.toEntity(): RealmPhoto {
    return RealmPhoto().also {
        it.photoId = id
        it.width = width
        it.height = height
        it.url = url
        it.photographer = photographer
        it.photographer_url = photographer_url
        it.photographer_id = photographer_id
        it.avg_color = avg_color
        it.alt = alt
        it.liked = liked
        it.src = src.toEntity()
    }
}
