package org.sopt.doSopkathon.data.dataclass

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes

@SuppressLint("SupportAnnotationUsage")
data class List_DataClass(
    @DrawableRes
    val title: String,
    val content: String,
    val date: String,
)