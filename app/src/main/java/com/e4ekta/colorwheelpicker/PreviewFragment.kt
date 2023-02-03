package com.e4ekta.colorwheelpicker

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.e4ekta.colorwheelpicker.databinding.FragmentPreviewBinding


class PreviewFragment : Fragment(R.layout.fragment_preview) {
    val previewViewModel : PreviewViewModel by lazy {
        ViewModelProvider(this)[PreviewViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDataBinding(view)

        previewViewModel.indicatorColor.observe(viewLifecycleOwner, Observer {
            Log.i("indicator","="+it)
          //  FragmentPreviewBinding.bind(view).colorWheel.setRgb()
        })

    }

    private fun setupDataBinding(view: View) {
        FragmentPreviewBinding.bind(view).let {
            it.colorIndicator.setBackgroundResource(R.drawable.color_indicator)
            it.viewModel = getViewModel()

            it.segmentOne.setOnClickListener { item ->
                //rgb(0, 194, 163)
                //rgb(75, 165, 79)
                //rgb(255, 97, 0)
                //00c2a3
                it.colorWheel.setHexCode(getString(R.color.segment_one))
            }
            it.segmentTwo.setOnClickListener { item->
                it.colorWheel.setHexCode(getString(R.color.segment_two))
            }

            it.segmentThree.setOnClickListener { item->
                it.colorWheel.setHexCode(getString(R.color.segment_three))
            }

        }
    }
}
