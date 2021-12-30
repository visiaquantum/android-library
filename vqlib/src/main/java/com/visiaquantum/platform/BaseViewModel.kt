package com.visiaquantum.platform

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.visiaquantum.shared.exception.Failure

/**
 * Base ViewModel class with default Failure handling.
 * @see ViewModel
 * @see Failure
 */
abstract class BaseViewModel : ViewModel() {

    var isBusy: MutableLiveData<Boolean> = MutableLiveData()
    var failure: MutableLiveData<Failure> = MutableLiveData()

    fun handleFailure(failure: Failure) {
        this.isBusy.value = false
        this.failure.value = failure
    }
}