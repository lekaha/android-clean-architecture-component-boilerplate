package com.playone.mobile.common

import com.playone.mobile.common.exception.InvalidPropertyValueException
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class NotValidVar<T : Any>(private val invalidVal: T) : ReadWriteProperty<Any?, T> {

    private var value: T = invalidVal

    override fun getValue(thisRef: Any?, property: KProperty<*>): T =
        if (value != invalidVal)
            value
        else {
            InvalidPropertyValueException("Property ${property.name} is setting invalid value")
                .printStackTrace()
            invalidVal
        }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        
        this.value = value
    }
}