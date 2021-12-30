package com.vqlib.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.visiaquantum.platform.BaseActivity
import com.visiaquantum.shared.exception.Failure

class MainActivity : BaseActivity() {
    override fun getContentId(): Int = R.id.content

    override fun showProgress() {}

    override fun hideProgress() {}

    override fun handleFailure(failure: Failure) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}