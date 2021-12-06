package com.masterclass.vipingresso.extensions

fun String?.getDateBR(): String {
    val dateList = this?.split("-")
    return if (dateList?.size == 3){
        "${dateList[2]}/${dateList[1]}/${dateList[0]}"
    } else {
        "Sem data"
    }
}

