package com.mozhimen.scank.tflite.test

import android.content.Intent
import android.os.Bundle
import com.mozhimen.kotlin.elemk.android.app.cons.CActivity
import com.mozhimen.kotlin.lintk.optins.OApiInit_ByLazy
import com.mozhimen.kotlin.utilk.android.content.UtilKIntentWrapper
import com.mozhimen.kotlin.utilk.android.net.uri2bitmap
import com.mozhimen.scank.tflite.normalize.TFLiteNormalizeDetector
import com.mozhimen.scank.tflite.test.databinding.ActivityEdgeDetectionBinding
import com.mozhimen.mvvmk.bases.activity.viewbinding.BaseActivityVB

class EdgeDetectionActivity : BaseActivityVB<ActivityEdgeDetectionBinding>() {
    @OptIn(OApiInit_ByLazy::class)
    private val _tFLiteNormalizeDetector: TFLiteNormalizeDetector by lazy {
        TFLiteNormalizeDetector(this)
    }

    override fun initView(savedInstanceState: Bundle?) {
        vb.edgeBtn.setOnClickListener {
            startActivityForResult(UtilKIntentWrapper.getPickImage(), 0)
        }
    }

    @OptIn(OApiInit_ByLazy::class)
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode != 0 || resultCode != CActivity.RESULT_OK || data == null) return
        if (data.data != null) {
            var bitmap = data.data!!.uri2bitmap()
            bitmap = _tFLiteNormalizeDetector.normalize(bitmap)
            vb.edgeImg.setImageBitmap(bitmap)
        }
    }
}