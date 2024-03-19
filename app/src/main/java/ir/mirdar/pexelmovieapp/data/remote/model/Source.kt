package ir.mirdar.pexelmovieapp.data.remote.model

import ir.mirdar.pexelmovieapp.domain.models.SourceModel

data class Source(
    val original: String,
    val large2x: String,
    val medium: String,
    val small: String,
    val portrait: String,
    val landscape: String,
    val tiny: String
)

fun Source.toModel(): SourceModel {
    return SourceModel(
        original,
        large2x,
        medium,
        small,
        portrait,
        landscape,
        tiny
    )
}
