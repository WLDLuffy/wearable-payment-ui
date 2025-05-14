package com.example.mastercardwearablepaymentapp.onboarding.domain.model

// Define the structs/ DTO required in your feature

// i.e Product
data class Product (
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    val rating: Rating
)

data class Rating(
    val rage: Double,
    val count: Int
)