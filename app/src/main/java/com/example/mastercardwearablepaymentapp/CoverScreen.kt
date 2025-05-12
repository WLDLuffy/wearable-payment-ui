package com.example.mastercardwearablepaymentapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mastercardwearablepaymentapp.ui.theme.InterFontFamily

@Composable
fun CoverScreen(
    navController: NavController,
    function: () -> Unit
) {

    val screenHeight = LocalConfiguration.current.screenHeightDp.dp

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.union),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
    Column(
        modifier = Modifier.fillMaxSize().padding(all = 24.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = screenHeight*0.03f)
        ) {
            Icon(
                painter = painterResource(R.drawable.mastercard),
                contentDescription = null,
                tint = Color.Unspecified,
            )
            Text(
                text = stringResource(R.string.header_text),
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.Light,
                fontSize = 20.sp,
                color = Color.White,
            )
        }

        Text(
            text = stringResource(R.string.mastercard_title),
            fontSize = 32.sp,
            fontFamily = InterFontFamily,
            color = Color.White,
            fontWeight = FontWeight.ExtraBold,
        )
        OutlinedText(
            modifier = Modifier.padding(top = 24.dp),
            text = stringResource(R.string.experience),
            height = 50,
            fontSize = 120f,
            strokeSize = 2f,
        )
        Text(
            text = stringResource(R.string.event_details),
            color = Color.White,
            fontFamily = InterFontFamily,
            fontSize = 12.sp,
            lineHeight = 36.sp
        )
        Text(
            text = stringResource(R.string.address_one),
            color = Color.White,
            fontFamily = InterFontFamily,
            fontSize = 12.sp

        )
        Spacer(modifier = Modifier.weight(1f))
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            OutlinedButton(
                onClick = {
                    navController.navigate(Screen.IntroScreen.route)
                },
                modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally),
                colors = ButtonColors(
                    containerColor = Color(0xFFCF4500),
                    contentColor = Color.White,
                    disabledContentColor = Color.Blue,
                    disabledContainerColor = Color.Blue,
                )
            ) {
                Text(
                    text = stringResource(R.string.continue_button),
                    fontFamily = InterFontFamily,
                    fontWeight = FontWeight.Bold,
                )
            }
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

@Preview(showBackground = true)
@Composable
fun CoverScreenPreview() {
    val navController = rememberNavController()
    CoverScreen(navController) {
    }
}