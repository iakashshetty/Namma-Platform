package com.mindmatrix.nammaplatform.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val NammaTypography = Typography().let {
    it.copy(
        headlineLarge = it.headlineLarge.copy(fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold, fontSize = 30.sp),
        titleLarge = it.titleLarge.copy(fontWeight = FontWeight.SemiBold, fontSize = 22.sp),
        bodyLarge = it.bodyLarge.copy(fontSize = 17.sp),
        labelLarge = it.labelLarge.copy(fontWeight = FontWeight.SemiBold, fontSize = 15.sp)
    )
}
