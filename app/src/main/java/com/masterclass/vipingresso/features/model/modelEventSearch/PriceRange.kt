package com.masterclass.vipingresso.features.model.modelEventSearch

data class PriceRange(
    val currency: String,
    val max: Double,
    val min: Double,
    val type: String
)