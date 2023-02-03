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
            //TODO: we can get indicator color like this using MVVM and show on colorWheel
            /* but Right now as we can get color on colorChangeListener  */
        })

    }

    private fun setupDataBinding(view: View) {
        FragmentPreviewBinding.bind(view).let {
            it.colorIndicator.setBackgroundResource(R.drawable.color_indicator)
            it.colorWheel.colorChangeListener = { rgb: Int ->
                it.segmentOne.setBackgroundColor(rgb)
               /**  Color wheel color showing on first segment **/
            }
            it.segmentTwo.setOnClickListener { item ->
                /* default color set up on color wheel*/
                it.colorWheel.setHexCode(getString(R.color.segment_one))
            }
            it.segmentThree.setOnClickListener { item->
                it.colorWheel.setHexCode(getString(R.color.segment_three))
            }

        }
    }
}
