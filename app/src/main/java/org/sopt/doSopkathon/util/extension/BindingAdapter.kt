package org.sopt.doSopkathon.util.extension

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?) {
    view.load(url)
}