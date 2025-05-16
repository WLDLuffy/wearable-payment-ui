package com.example.mastercardwearablepaymentapp.onboarding.presentation.testscreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun TestScreen(
    navController: NavController,
    viewModel: TestScreenViewModel = hiltViewModel(),
) {
    val state = viewModel.state.collectAsStateWithLifecycle()

    // test the grids
    Column(
        modifier = Modifier
            .fillMaxSize()
            .border(
                BorderStroke(
                    width = 5.dp,
                    color = Color.Green
                )
            ).background(
                color = Color.White,
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .border(
                    BorderStroke(
                        width = 6.dp,
                        color = Color.Red
                    )
                )
                .weight(1f)

        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(
                        BorderStroke(
                            width = 2.dp,
                            color = Color.Black
                        )
                    ),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    modifier = Modifier
                        .weight(1f),
                    textAlign = TextAlign.Center,
                    text = "this is red test 1",
                    color = Color.Red
                )
                Text(
                    modifier = Modifier.weight(1f),
                    text = "this is red test 2",
                    textAlign = TextAlign.Center,
                    color = Color.Red
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(
                        BorderStroke(
                            width = 2.dp,
                            color = Color.Yellow
                        )
                    ),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    modifier = Modifier
                        .weight(1f),
                    textAlign = TextAlign.Center,
                    text = "this is yellow test 1",
                    color = Color.Yellow
                )
                Text(
                    modifier = Modifier.weight(1f),
                    text = "this is yellow test 2",
                    textAlign = TextAlign.Center,
                    color = Color.Yellow
                )
            }
        }

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    BorderStroke(
                        width = 5.dp,
                        color = Color.Blue,
                    )
                )
                .weight(1f)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "this is blue test 1",
                color = Color.Blue,
                textAlign = TextAlign.Center,
            )
        }

        Text(
            text = "this is green test 1",
            color = Color.Green,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Text(
            text = "This is green test 2",
            color = Color.Green
        )

        Text(
            text = "This is green test 3",
            color = Color.Green
        )
        Text(
            text = "This is green test 4",
            color = Color.Green
        )


    }
    Box(
        modifier = Modifier
            .height(LocalConfiguration.current.screenHeightDp.dp / 2)
            .width(LocalConfiguration.current.screenWidthDp.dp)
            .clip(RoundedCornerShape(18.dp))
            .border(
                BorderStroke(
                    width = 4.dp,
                    color = Color.Gray
                )
            )
            .zIndex(1f)
            .background(
                color = Color.Black.copy(alpha = 0.4f)
            ),
    ) {
        Text(
            text = "this is text in a box",
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}


@Preview
@Composable
fun TestScreenPreview(
) {
    val navController = rememberNavController()
    TestScreen(navController)
}