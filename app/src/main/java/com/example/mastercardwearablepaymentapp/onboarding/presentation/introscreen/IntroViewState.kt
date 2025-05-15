package com.example.mastercardwearablepaymentapp.onboarding.presentation.introscreen

import com.example.mastercardwearablepaymentapp.onboarding.domain.model.CarouselImage

data class IntroViewState (
    val images: List<CarouselImage> = emptyList(),
    val currentPage: Int = 0
)