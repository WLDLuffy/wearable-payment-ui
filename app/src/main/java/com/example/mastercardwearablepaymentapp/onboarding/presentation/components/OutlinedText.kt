package com.example.mastercardwearablepaymentapp.onboarding.presentation.components

import android.graphics.Typeface
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.dp

@Composable
fun OutlinedText(modifier: Modifier, text: String, height: Int, fontSize: Float, strokeSize: Float) {
    Canvas(modifier = modifier
        .fillMaxWidth()
        .height(height.dp)) {
        drawIntoCanvas { canvas ->
            val paint = android.graphics.Paint().apply {
                color = android.graphics.Color.WHITE
                style = android.graphics.Paint.Style.STROKE  // Stroke only
                strokeWidth = strokeSize
                textSize = fontSize
                typeface = Typeface.create(Typeface.DEFAULT_BOLD, Typeface.BOLD)
                isAntiAlias = true
            }
            canvas.nativeCanvas.drawText(text, 0f, 70f, paint)
        }
    }
}