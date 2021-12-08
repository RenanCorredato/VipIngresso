package com.masterclass.vipingresso.base


import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import com.masterclass.vipingresso.utils.Command

abstract class BaseFrament:Fragment()
{
    abstract var command:MutableLiveData<Command>
}