package com.kvdheijden.delegate.viewbinding

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 *
 */
public inline fun <reified VB : ViewBinding> Fragment.viewBindings(): Lazy<VB> =
    ViewBindingLazy(layoutInflater, VB::class.java)