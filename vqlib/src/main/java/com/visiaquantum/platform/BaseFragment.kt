package com.visiaquantum.platform

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.visiaquantum.shared.exception.Failure
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment : DaggerFragment() {



    abstract fun initObserver()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initObserver()
    }

    fun loadAndClearFragment(fragment: BaseFragment) {
        with(requireActivity() as BaseActivity) {
            loadAndClearStackFragment(fragment)
        }
    }

    fun loadFragment(fragment: BaseFragment) {
        with(requireActivity() as BaseActivity) {
            loadFragment(fragment)
        }
    }

    fun loadAndClearFragmentNoAnim(fragment: BaseFragment) {
        with(requireActivity() as BaseActivity) {
            loadAndClearStackFragmentNoAnim(fragment)
        }
    }

    fun loadFragmentNoAnim(fragment: BaseFragment) {
        with(requireActivity() as BaseActivity) {
            loadFragmentNoAnim(fragment)
        }
    }

    fun removeFragment(fragment: BaseFragment) {
        with(requireActivity() as BaseActivity) {
            removeFragment(fragment)
        }
    }

    fun loadTransparentFragment(fragment: BaseFragment) {
        with(requireActivity() as BaseActivity) {
            loadTransparentFragment(fragment)
        }
    }

    fun fragmentManager() = requireActivity().supportFragmentManager

    fun handleFailure(failure: Failure?) {
        failure?.let {
            with(requireActivity() as BaseActivity) {
                handleFailure(it)
            }
        }
    }

    fun getPackageName() = requireActivity().packageName

    fun showProgress() {
        with(requireActivity() as BaseActivity) {
            showProgress()
        }
    }

    fun hideProgress() {
        with(requireActivity() as BaseActivity) {
            hideProgress()
        }
    }

}