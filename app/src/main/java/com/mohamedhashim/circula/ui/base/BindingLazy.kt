package com.mohamedhashim.circula.ui.base

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Created by Mohamed Hashim on 2/21/2021.
 */
inline fun <reified T : ViewDataBinding> bindings(view: View): Lazy<T> =
    lazy {
        DataBindingUtil.bind<T>(view)
            ?: throw IllegalAccessException("cannot find the matched view to layout.")
    }
