package com.example.mastercardwearablepaymentapp

sealed class Screen(val route: String) {
    object CoverScreen:Screen("cover_screen")
    object IntroScreen:Screen("intro_screen")
    object TermsAndConditionScreen:Screen("tnc_screen")
}