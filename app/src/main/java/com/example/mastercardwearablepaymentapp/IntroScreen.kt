package com.example.mastercardwearablepaymentapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mastercardwearablepaymentapp.ui.theme.InterFontFamily
import kotlinx.coroutines.launch

@Composable
fun IntroScreen(
    navController: NavController,
    function: () -> Unit
) {
    var imageList = listOf(
        CarouselImage(R.drawable.carousel1, stringResource(R.string.carousel_one_title), stringResource(R.string.carousel_one_description)),
        CarouselImage(R.drawable.carousel2, stringResource(R.string.carousel_two_title), stringResource(R.string.carousel_two_description)),
        CarouselImage(R.drawable.carousel3, stringResource(R.string.carousel_three_title), stringResource(R.string.carousel_three_description)),
    )
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { imageList.size })
    val coroutineScope = rememberCoroutineScope()
    Box(
        modifier = Modifier.fillMaxSize().background(Color(0xFF141413))
    ) {
        TopBar(navController, displayArrow = true)
        Carousel(
            navController = navController,
            imageList = imageList,
            pagerState = pagerState
        )

        Row (
            modifier = Modifier.fillMaxWidth().align(Alignment.BottomEnd).padding(24.dp),
        ) {

            OutlinedButton(
                onClick = {
                    if (pagerState.currentPage == 0) {
                        navController.navigate(Screen.CoverScreen.route)
                    } else {
                        coroutineScope.launch {
                            val prevPage = pagerState.currentPage - 1
                            if (prevPage > -1) {
                                pagerState.animateScrollToPage(prevPage)
                            }
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth(0.35f).padding(8.dp),
                colors = ButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color(0xFFCF4500),
                    disabledContentColor = Color.Blue,
                    disabledContainerColor = Color.Blue,
                ),
                border = BorderStroke(
                    color = Color(0xFFCF4500),
                    width = 1.dp
                )
            ) {
                Text(
                    text = stringResource(R.string.back_button)
                )
            }

            Button(
                onClick = {
                    if (pagerState.currentPage == imageList.size - 1) {
                        navController.navigate(Screen.TermsAndConditionScreen.route)
                    } else {
                        coroutineScope.launch {
                            val nextPage = pagerState.currentPage + 1
                            if (nextPage < pagerState.pageCount) {
                                pagerState.animateScrollToPage(nextPage)
                            }
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                colors = ButtonColors(
                    containerColor = Color(0xFFCF4500),
                    contentColor = Color.White,
                    disabledContentColor = Color.Blue,
                    disabledContainerColor = Color.Blue,
                )
            ) {
                Text(
                    text = stringResource(R.string.next_button)
                )
            }
        }
        Column (
            modifier = Modifier.fillMaxSize().padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = stringResource(R.string.footer_note),
                modifier = Modifier.fillMaxWidth().padding(4.dp),
                fontSize = 8.sp,
                fontFamily = InterFontFamily,
                color = colorResource(R.color.light_grey)
            )
        }
    }
}

data class CarouselImage(val image: Int, val imageTitle: String, val imageDescription: String)

@Preview
@Composable
fun IntroScreenPreview() {
    val navController = rememberNavController()
    IntroScreen(navController) {
        navController.navigate(Screen.TermsAndConditionScreen.route)
    }
}