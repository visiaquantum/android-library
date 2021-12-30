package com.visiaquantum.platform

import android.content.Context
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.view.MotionEvent
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.visiaquantum.R
import com.visiaquantum.extensions.hideKeyboard
import com.visiaquantum.shared.exception.Failure
import com.visiaquantum.shared.util.AnimationList
import dagger.android.support.DaggerAppCompatActivity
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity() {

    companion object{
        const val IMAGES_FOLDER_NAME = "IMAGES"
    }

    abstract fun getContentId(): Int

    abstract fun showProgress()

    abstract fun hideProgress()

    abstract fun handleFailure(failure: Failure)

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val animationList = AnimationList(
        R.anim.fragment_translate_in_from_right, R.anim.fragment_translate_out_from_right,
        R.anim.fragment_translate_in_from_left, R.anim.fragment_translate_out_from_left
    )

    fun loadFragment(fragment: BaseFragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.setCustomAnimations(
            animationList.resAnimationForwardIn,
            animationList.resAnimationForwardOut,
            animationList.resAnimationBackIn,
            animationList.resAnimationBackOut
            )
        fragmentTransaction.replace(getContentId(), fragment, fragment::class.simpleName)
        fragmentTransaction.addToBackStack(fragment::class.simpleName)
        fragmentTransaction.commit()
    }

    fun loadFragmentNoAnim(fragment: BaseFragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(getContentId(), fragment, fragment::class.simpleName)
        fragmentTransaction.addToBackStack(fragment::class.simpleName)
        fragmentTransaction.commit()
    }

    fun loadAndClearStackFragment(fragment: BaseFragment) {
        supportFragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.setCustomAnimations(
            animationList.resAnimationForwardIn,
            animationList.resAnimationForwardOut,
            animationList.resAnimationBackIn,
            animationList.resAnimationBackOut
        )
        fragmentTransaction.replace(getContentId(), fragment, fragment::class.simpleName)
        fragmentTransaction.commit()
    }

    fun loadAndClearStackFragmentNoAnim(fragment: BaseFragment) {
        supportFragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(getContentId(), fragment, fragment::class.simpleName)
        fragmentTransaction.commit()
    }

    fun loadTransparentFragment(fragment: BaseFragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(getContentId(), fragment, fragment::class.simpleName)
        fragmentTransaction.addToBackStack(fragment::class.simpleName)
        fragmentTransaction.commit()
    }

    fun removeFragment(fragment: BaseFragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.remove(fragment)
        fragmentTransaction.commit()
        supportFragmentManager.popBackStack()
    }

    /**
     * if the main view receives a touch event and the soft keyboard is showing
     * the user probably would be happy if we dismiss it
     */
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (currentFocus != null) {
            hideKeyboard()
        }
        return super.dispatchTouchEvent(ev)
    }

    @Suppress("DEPRECATION")
    fun saveImageInAppMemory(context: Context, name: String, dataImage: Uri?) {
        try {
            var bitmapImage: Bitmap? = null
            if (Build.VERSION.SDK_INT >= 29) {
                try {
                    val source = context.contentResolver?.let { it1 ->
                        dataImage?.let { it2 ->
                            ImageDecoder.createSource(
                                it1,
                                it2
                            )
                        }
                    }
                    bitmapImage = source?.let { it1 -> ImageDecoder.decodeBitmap(it1) }
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            } else {
                try {
                    bitmapImage = MediaStore.Images.Media.getBitmap(
                        applicationContext.contentResolver,
                        dataImage
                    )
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
            val destination = File(getImageLocation(context), name)
            val bytes = ByteArrayOutputStream()
            bitmapImage!!.compress(Bitmap.CompressFormat.JPEG, 40, bytes)
            val fo = FileOutputStream(destination)
            fo.write(bytes.toByteArray())
            fo.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun getImageLocation(context: Context): String? {
        Environment.isExternalStorageRemovable()
        if (isExternalStorageWritable()) {
            val file = File(
                context.getExternalFilesDir(Environment.DIRECTORY_PICTURES),
                IMAGES_FOLDER_NAME
            )
            return file.absolutePath
        }
        return null
    }

    private fun isExternalStorageWritable(): Boolean {
        val state = Environment.getExternalStorageState()
        return Environment.MEDIA_MOUNTED == state
    }


}