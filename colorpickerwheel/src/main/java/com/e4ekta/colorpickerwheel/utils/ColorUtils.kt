package com.e4ekta.colorpickerwheel.utils

import android.graphics.Color

internal fun setAlpha(argb: Int, alpha: Int) =
    Color.argb(alpha, Color.red(argb), Color.green(argb), Color.blue(argb))
