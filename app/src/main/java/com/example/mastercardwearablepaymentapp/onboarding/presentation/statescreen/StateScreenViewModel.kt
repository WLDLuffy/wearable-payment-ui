package com.example.mastercardwearablepaymentapp.onboarding.presentation.statescreen

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class StateScreenViewModel @Inject constructor(

) {
    private val _state = MutableStateFlow(StateScreenViewState())
    val state = _state.asStateFlow()



}