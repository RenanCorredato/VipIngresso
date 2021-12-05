package com.masterclass.vipingresso.features.home.usecase


import com.masterclass.vipingresso.features.home.repository.HomeRepository


class HomeUseCase {
    private val homeRepository = HomeRepository()

    suspend fun getEventSearch() {
        homeRepository.getEventSearch()

    }
}