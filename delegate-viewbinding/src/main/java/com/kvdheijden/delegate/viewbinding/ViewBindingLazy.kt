package com.kvdheijden.delegate.viewbinding

import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import java.lang.reflect.Method

/**
 *
 */
class ViewBindingLazy<VB : ViewBinding>(
    private val layoutInflater: LayoutInflater,
    private val viewBindingClass: Class<VB>
) : Lazy<VB> {
    // TODO
    private var _value: VB? = null

    // TODO
    private val inflater: Method =
        viewBindingClass.getMethod("inflate", LayoutInflater::class.java)

    /**
     *
     */
    override val value: VB
        get() = _value ?: requireViewBinding(inflater.invoke(layoutInflater)).also {
            _value = it
        }

    /**
     * TODO
     *
     * @return whether this ViewBinding is initialized
     */
    override fun isInitialized(): Boolean = _value != null

    private fun requireViewBinding(t: Any?): VB {
        return viewBindingClass.cast(t)
            ?: throw IllegalStateException("Object $t can not be cast to a ViewBinding.")
    }
}
