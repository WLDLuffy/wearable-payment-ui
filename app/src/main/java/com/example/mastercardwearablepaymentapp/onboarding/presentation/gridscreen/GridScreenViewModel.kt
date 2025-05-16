package com.example.mastercardwearablepaymentapp.onboarding.presentation.gridscreen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class GridScreenViewModel @Inject constructor (

): ViewModel() {
    private val _state = MutableStateFlow(GridScreenViewState())
    val state = _state.asStateFlow()


    fun updateTestField1(newVal: String) {
        _state.update{
            it.copy(
                testData1 = newVal
            )
        }
    }
}