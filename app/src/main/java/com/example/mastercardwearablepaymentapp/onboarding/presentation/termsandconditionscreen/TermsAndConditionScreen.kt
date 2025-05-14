package com.example.mastercardwearablepaymentapp.onboarding.presentation.termsandconditionscreen

import android.widget.TextView
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mastercardwearablepaymentapp.R
import com.example.mastercardwearablepaymentapp.Screen
import com.example.mastercardwearablepaymentapp.onboarding.presentation.components.TopBar
import com.example.mastercardwearablepaymentapp.ui.theme.InterFontFamily

@Composable
fun TermsAndConditionScreen(
    navController: NavController,
    function: () -> Unit,
) {
    val scrollState = rememberScrollState()
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp

    TopBar(navController, displayArrow = false)
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF141413))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(0.1f))
        Text(
            text = stringResource(R.string.terms_and_condition_header),
            fontFamily = InterFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier.padding(16.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight * 0.65f)
                .clip(RoundedCornerShape(8.dp))
                .background(colorResource(R.color.dark_grey))
                .verticalScroll(scrollState)
                .padding(24.dp)
        ) {
            HtmlTextView(R.string.terms_and_conditions)
        }
        Row(
            modifier = Modifier.fillMaxWidth().padding(top=24.dp)
        ) {
            OutlinedButton(
                onClick = {
                    navController.navigate(Screen.CoverScreen.route)
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
                    text = stringResource(R.string.disagree_button),
                    fontFamily = InterFontFamily,
                    fontSize = 12.sp
                )
            }

            Button(
                onClick = {
//                    navController.navigate(Screen.CoverScreen.route)
                    navController.navigate(Screen.ProductsScreen.route)
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
                    fontFamily = InterFontFamily,
                    fontSize = 12.sp
                )
            }
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

@Composable
fun HtmlTextView(@StringRes textResId: Int) {
    val context = LocalContext.current
    val htmlText = stringResource(id = textResId)

    AndroidView(
        factory = {
            TextView(context).apply {
                text = HtmlCompat.fromHtml(htmlText, HtmlCompat.FROM_HTML_MODE_LEGACY)
                setTextColor(Color.White.toArgb())
            }
        }
    )
}

@Preview
@Composable
fun TermsAndConditionScreenPreview() {
    val navController = rememberNavController()
    TermsAndConditionScreen(navController) {
    }
}