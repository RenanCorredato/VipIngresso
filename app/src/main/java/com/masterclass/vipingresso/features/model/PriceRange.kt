package com.masterclass.vipingresso.features.model

data class PriceRange(
    val currency: String,
    val max: Double,
    val min: Double,
    val type: String
)