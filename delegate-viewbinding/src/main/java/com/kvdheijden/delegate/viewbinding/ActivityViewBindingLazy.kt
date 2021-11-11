package com.kvdheijden.delegate.viewbinding

import android.app.Activity
import androidx.viewbinding.ViewBinding

/**
 *
 */
public inline fun <reified VB : ViewBinding> Activity.viewBindings(): Lazy<VB> =
    ViewBindingLazy(layoutInflater, VB::class.java)
