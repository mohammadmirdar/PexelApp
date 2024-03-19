package ir.mirdar.pexelmovieapp.data.remote.model

import ir.mirdar.pexelmovieapp.domain.models.PhotoModel

data class Photo(
    val id: Long,
    val width: Long,
    val height: Long,
    val url: String,
    val photographer: String,
    val photographer_url: String,
    val photographer_id: Long,
    val avg_color: String,
    val alt: String,
    val liked: Boolean,
    val src: Source
)

fun Photo.toModel(): PhotoModel {
    return PhotoModel(
        id,
        width,
        height,
        url,
        photographer,
        photographer_url,
        photographer_id,
        avg_color,
        alt,
        liked,
        src.toModel(),
    )
}
