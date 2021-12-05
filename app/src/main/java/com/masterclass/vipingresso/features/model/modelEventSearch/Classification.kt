package com.masterclass.vipingresso.features.model.modelEventSearch

data class Classification(
    val family: Boolean,
    val genre: Genre,
    val primary: Boolean,
    val segment: Segment,
    val subGenre: SubGenre,
    val subType: SubType,
    val type: Type
)