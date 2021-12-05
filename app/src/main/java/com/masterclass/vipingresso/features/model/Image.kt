package com.masterclass.vipingresso.features.model

data class Image(
    val fallback: Boolean,
    val height: Int,
    val ratio: String,
    val url: String,
    val width: Int
)