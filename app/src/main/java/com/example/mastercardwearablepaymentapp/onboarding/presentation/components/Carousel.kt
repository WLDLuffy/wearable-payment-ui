package com.example.mastercardwearablepaymentapp.onboarding.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mastercardwearablepaymentapp.R
import com.example.mastercardwearablepaymentapp.Screen
import com.example.mastercardwearablepaymentapp.onboarding.domain.model.CarouselImage
import com.example.mastercardwearablepaymentapp.ui.theme.InterFontFamily

@Composable
fun Carousel(navController: NavController, pagerState: PagerState, imageList: List<CarouselImage>) {

    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        val screenHeight = LocalConfiguration.current.screenHeightDp.dp
        Box (
            modifier = Modifier.fillMaxWidth().height(screenHeight * 0.6f)
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize()
            ) {
                pageIndex ->
                Image(
                    painter = painterResource(id = imageList[pageIndex].imageRes),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp)
        ) {
            imageList.forEachIndexed { index, _ ->
                val isSelected = pagerState.currentPage == index
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(if (isSelected) Color(0xFFFF6A00) else Color.Gray)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = stringResource(imageList[pagerState.currentPage].titleRes),
            fontFamily = InterFontFamily,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 24.dp),
            fontSize = 24.sp
        )
        Text(
            text = stringResource(imageList[pagerState.currentPage].descriptionRes),
            fontFamily = InterFontFamily,
            fontWeight = FontWeight.Light,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
            fontSize = 12.sp
        )
        Text(
            text = "skip",
            fontFamily = InterFontFamily,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 4.dp)
                .clickable {
                    navController.navigate(Screen.TermsAndConditionScreen.route)
                },
            fontSize = 12.sp,
            style = TextStyle(
                textDecoration = TextDecoration.Underline
            )
            )


    }
}

@Preview
@Composable
fun CarouselPreview() {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { 3 })
    val navController = rememberNavController()
    var imageList = listOf(
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
    Carousel(navController, pagerState, imageList)
}