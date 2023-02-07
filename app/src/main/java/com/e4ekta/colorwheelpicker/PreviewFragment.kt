package com.e4ekta.colorwheelpicker


import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.e4ekta.colorwheelpicker.databinding.FragmentPreviewBinding


class PreviewFragment : Fragment(R.layout.fragment_preview) {
    val previewViewModel: PreviewViewModel by lazy {
        ViewModelProvider(this)[PreviewViewModel::class.java]
    }
    lateinit var selectedSegment: AppCompatButton
    var selectedSegmentNumber = 0

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDataBinding(view)

        previewViewModel.selectedSegment.observe(viewLifecycleOwner, Observer {
            selectedSegmentNumber = it
        })

    }


    @RequiresApi(Build.VERSION_CODES.N)
    private fun setupDataBinding(view: View) {
        FragmentPreviewBinding.bind(view).let {
            it.colorIndicator.setBackgroundResource(R.drawable.color_indicator)
            it.colorWheel.colorChangeListener = { rgb: Int ->

                when (selectedSegmentNumber) {
                    1 -> {
                        val shapeDrawable = it.segmentOne.background as GradientDrawable
                        shapeDrawable.setColor(rgb)
                    }
                    2 -> {
                        val shapeDrawable = it.segmentTwo.background as GradientDrawable
                        shapeDrawable.setColor(rgb)
                    }
                    3 -> {
                        val shapeDrawable = it.segmentThree.background as GradientDrawable
                        shapeDrawable.setColor(rgb)
                    }
                }
            }
            /* TODO : setting current item color to ColorWheel, getting colorStateList that not working with colorPicker*/
            it.segmentOne.setOnClickListener { item ->
                previewViewModel.selectedSegment.postValue(1)
                val buttonColor = item.background as GradientDrawable
                Log.i("SegmentOne","="+buttonColor.color.hashCode())
               // it.colorWheel.setColor(buttonColor.color.hashCode())
            }
            it.segmentTwo.setOnClickListener { item ->
                previewViewModel.selectedSegment.postValue(2)
                val buttonColor = item.background as GradientDrawable
                //it.colorWheel.setColor(buttonColor.color.hashCode())
            }
            it.segmentThree.setOnClickListener { item ->
                previewViewModel.selectedSegment.postValue(3)
                val buttonColor = item.background as GradientDrawable
              //  it.colorWheel.setColor(buttonColor.color.hashCode())
            }

        }
    }
}
