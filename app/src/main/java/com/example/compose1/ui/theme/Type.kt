package com.example.compose1.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.compose1.R

val dinRoundFamily = FontFamily(
    Font(R.font.dinroundpro, FontWeight.Normal),
    Font(R.font.dinroundpro_black, FontWeight.Normal),
    Font(R.font.dinroundpro_light, FontWeight.Light),
    Font(R.font.dinroundpro_medium, FontWeight.Medium),
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = dinRoundFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

