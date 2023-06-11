package com.example.scrolllist.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Cat(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
