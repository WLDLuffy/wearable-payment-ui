package com.example.mastercardwearablepaymentapp.onboarding.presentation.introscreen

import androidx.lifecycle.ViewModel
import com.example.mastercardwearablepaymentapp.R
import com.example.mastercardwearablepaymentapp.onboarding.domain.model.CarouselImage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class IntroViewModel @Inject constructor (

): ViewModel() {

    private val _state = MutableStateFlow(IntroViewState(
        images = listOf(
            CarouselImage(
                R.drawable.carousel1,
                R.string.carousel_one_title,
                R.string.carousel_one_description
            ),
            CarouselImage(
                R.drawable.carousel2,
                R.string.carousel_two_title,
                R.string.carousel_two_description
            ),
            CarouselImage(
                R.drawable.carousel3,
                R.string.carousel_three_title,
                R.string.carousel_three_description
            ),
        )
    ))
    val state = _state.asStateFlow()

    fun onPageChange(index: Int) {
        _state.update{
            it.copy(currentPage = index)
        }
    }
}