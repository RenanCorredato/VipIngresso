package com.masterclass.vipingresso.features.model.modelResultAttractionSearch

import com.google.gson.annotations.SerializedName

data class UpcomingEvents(
    val _total: Int,
    @SerializedName("mfx-be")
    val mfxbe: Int,
    val ticketmaster: Int,
    val tmr: Int
)