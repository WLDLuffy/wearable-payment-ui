package com.example.mastercardwearablepaymentapp.onboarding.presentation.termsandconditionscreen

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import com.example.mastercardwearablepaymentapp.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class TermsAndConditionViewModel @Inject constructor(

): ViewModel() {
    private val _state = MutableStateFlow(TermsAndConditionViewState(
        termsAndConditionContentRes = R.string.terms_and_conditions
    ))
    val state = _state.asStateFlow()
}