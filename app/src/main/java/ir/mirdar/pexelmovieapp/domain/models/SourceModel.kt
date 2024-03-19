package ir.mirdar.pexelmovieapp.domain.models

import ir.mirdar.pexelmovieapp.data.local.model.RealmSource

data class SourceModel(
    val original : String,
    val large2x : String,
    val medium : String,
    val small : String,
    val portrait : String,
    val landscape : String,
    val tiny : String
)

fun SourceModel.toEntity(): RealmSource {
    return RealmSource().also {
        it.original = original
        it.large2x = large2x
        it.medium = medium
        it.small = small
        it.portrait = portrait
        it.landscape = landscape
        it.tiny = tiny
    }
}
