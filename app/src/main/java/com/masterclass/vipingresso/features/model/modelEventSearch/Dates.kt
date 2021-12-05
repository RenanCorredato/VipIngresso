package com.masterclass.vipingresso.features.model.modelEventSearch

data class Dates(
    val spanMultipleDays: Boolean,
    val start: Start,
    val status: Status,
    val timezone: String
)