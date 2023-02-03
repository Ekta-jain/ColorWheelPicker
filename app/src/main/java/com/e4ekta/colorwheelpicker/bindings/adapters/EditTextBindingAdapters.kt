package com.github.antonpopoff.colorwheelapp.binding.adapters

import android.widget.EditText
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener


@BindingAdapter("intText")
fun EditText.bindIntText(value: Int) {
    if (value != this.receiveIntText()) this.setText(value.toString())
}

@InverseBindingAdapter(attribute = "intText")
fun EditText.receiveIntText() = this.text.toString().toIntOrNull() ?: 0

/*@BindingAdapter("intTextAttrChanged")
fun EditText.bindIntTextListener(listener: InverseBindingListener) {
    this.afterTextChanged { listener.onChange() }
}*/
