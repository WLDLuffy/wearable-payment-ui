package com.example.mastercardwearablepaymentapp.onboarding.presentation.coverscreen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CoverViewModel @Inject constructor(

):
ViewModel(){

    val _state = MutableStateFlow(CoverViewState())
    val state = _state.asStateFlow()

}