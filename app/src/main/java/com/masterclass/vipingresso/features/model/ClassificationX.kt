package com.masterclass.vipingresso.features.model

data class ClassificationX(
    val family: Boolean,
    val genre: GenreX,
    val primary: Boolean,
    val segment: SegmentX,
    val subGenre: SubGenreX,
    val subType: SubTypeX,
    val type: TypeX
)