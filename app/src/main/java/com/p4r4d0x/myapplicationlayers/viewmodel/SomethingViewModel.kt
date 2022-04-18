package com.p4r4d0x.myapplicationlayers.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.p4r4d0x.domain.GetSomethingUseCase

class SomethingViewModel(private val useCase: GetSomethingUseCase) : ViewModel() {

    private val _somethingBoolean = MutableLiveData<Boolean>()
    val somethingBoolean: LiveData<Boolean>
        get() = _somethingBoolean

    fun getSomething() {
        useCase.invoke {
            _somethingBoolean.value = it
        }
    }
}