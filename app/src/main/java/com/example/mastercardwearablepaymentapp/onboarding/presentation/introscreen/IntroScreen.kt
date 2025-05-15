package com.example.mastercardwearablepaymentapp.onboarding.presentation.introscreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mastercardwearablepaymentapp.onboarding.presentation.components.Carousel
import com.example.mastercardwearablepaymentapp.R
import com.example.mastercardwearablepaymentapp.Screen
import com.example.mastercardwearablepaymentapp.onboarding.domain.model.CarouselImage
import com.example.mastercardwearablepaymentapp.onboarding.presentation.components.TopBar
import com.example.mastercardwearablepaymentapp.ui.theme.InterFontFamily
import kotlinx.coroutines.launch

@Composable
fun IntroScreen(
    navController: NavController,
    viewModel: IntroViewModel = hiltViewModel(),
    function: () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    val pagerState = rememberPagerState(initialPage = state.currentPage, pageCount = { state.images.size })
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier.fillMaxSize().background(Color(0xFF141413))
    ) {
        TopBar(navController, displayArrow = true)
        Carousel(
            navController = navController,
            imageList = state.images,
            pagerState = pagerState
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ){
            Column (
                modifier = Modifier.fillMaxSize().padding(horizontal = 24.dp)
            ) {
                Spacer(
                    modifier = Modifier.weight(1f)
                )
                Row (
                    modifier = Modifier.fillMaxWidth(),
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
                                        viewModel.onPageChange(prevPage)
                                    }
                                }
                            }
                        },
                        modifier = Modifier.fillMaxWidth(0.35f).padding(vertical = 8.dp),
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
                            if (pagerState.currentPage == state.images.size - 1) {
                                navController.navigate(Screen.TermsAndConditionScreen.route)
                            } else {
                                coroutineScope.launch {
                                    val nextPage = pagerState.currentPage + 1
                                    if (nextPage < pagerState.pageCount) {
                                        pagerState.animateScrollToPage(nextPage)
                                        viewModel.onPageChange(nextPage)
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
                            text = stringResource(R.string.next_button),
                        )
                    }
                }
                Text(
                    text = stringResource(R.string.footer_note),
                    modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
                    fontSize = 8.sp,
                    fontFamily = InterFontFamily,
                    color = colorResource(R.color.light_grey)
                )
            }
        }

    }

}

@Preview
@Composable
fun IntroScreenPreview() {
    val navController = rememberNavController()
    IntroScreen(navController) {
        navController.navigate(Screen.TermsAndConditionScreen.route)
    }
}