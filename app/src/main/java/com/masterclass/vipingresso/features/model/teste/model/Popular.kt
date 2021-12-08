package com.masterclass.vipingresso.features.model.teste.model

data class Popular(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)