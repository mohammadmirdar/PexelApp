package ir.mirdar.pexelmovieapp.data.remote.model

import ir.mirdar.pexelmovieapp.domain.models.CuratedModel
import ir.mirdar.pexelmovieapp.domain.models.PhotoModel

data class Curated(
    val page: Int,
    val photos: List<Photo>,
)

fun List<Photo>.toModel(): List<PhotoModel> {
    return this.map { it.toModel() }
}
fun Curated.toModel(): CuratedModel {
    return CuratedModel(
        page,
        photos.toModel()
    )
}