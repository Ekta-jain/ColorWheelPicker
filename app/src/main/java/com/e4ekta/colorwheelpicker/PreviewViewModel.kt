package com.e4ekta.colorwheelpicker

import androidx.annotation.IntegerRes
import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.e4ekta.colorwheelpicker.utils.setColorAlpha


class PreviewViewModel : ViewModel() {

    val indicatorColor = MutableLiveData<Int>()
    val selectedSegment = MutableLiveData<Int>()

    fun onColorChanged(valueGradient: Int, alphaGradientColor: Int) {
        indicatorColor.postValue(setColorAlpha(valueGradient, alphaGradientColor))
    }
}
