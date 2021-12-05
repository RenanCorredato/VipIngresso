package com.masterclass.vipingresso.features.model.modelAttractionSearch

import com.google.gson.annotations.SerializedName

data class UpcomingEvents(
    val _total: Int,
    @SerializedName("mfx-be")
    val mfxBe: Int,
    @SerializedName("mfx-cz")
    val mfxCz: Int,
    @SerializedName("mfx-de")
    val mfxDe: Int,
    @SerializedName("mfx-nl")
    val mfxNl: Int,
    @SerializedName("mfx-no")
    val mfxNo: Int,
    @SerializedName("mfx-pl")
    val mfxPl: Int,
    @SerializedName("mfx-se")
    val mfxSe: Int,
    val ticketmaster: Int,
    val ticketweb: Int,
    val tmr: Int
)