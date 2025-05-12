package com.example.mastercardwearablepaymentapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mastercardwearablepaymentapp.ui.theme.InterFontFamily

@Composable
fun TopBar(
    navController: NavController,
    displayArrow: Boolean,
) {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black.copy(alpha = 0.6f))
            .zIndex(1f)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp).padding(top = screenHeight*0.05f, bottom = screenHeight*0.02f),
            verticalAlignment = Alignment.CenterVertically,

        ) {
            Icon(
                painter = painterResource(R.drawable.mastercard),
                contentDescription = null,
                tint = Color.Unspecified,
            )
            Text(
                text = stringResource(R.string.header_text),
                color = colorResource(id = R.color.white),
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                fontFamily = InterFontFamily,
                fontSize = 20.sp,
                fontWeight = FontWeight.Light
            )
            Spacer(modifier = Modifier.weight(1f))
            if (displayArrow) {
                Icon(
                    painter = painterResource(R.drawable.arrow_back),
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
            Button(
                onClick = {
                    navController.navigate(Screen.CoverScreen.route)
                },
                modifier = Modifier.padding(horizontal = 16.dp),
                colors = ButtonColors(
                    containerColor = Color(0xFFCF4500),
                    contentColor = Color.White,
                    disabledContentColor = Color.Blue,
                    disabledContainerColor = Color.Blue,
                )
            ) {
                Text(
                    text = stringResource(R.string.close_button),
                    fontFamily = InterFontFamily,
                    fontSize = 12.sp,
                    color = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
fun TopBarPreview() {
    val navController = rememberNavController()
    TopBar(navController, true)
}