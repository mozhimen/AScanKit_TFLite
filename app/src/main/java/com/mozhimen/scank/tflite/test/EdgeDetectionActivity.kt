package com.mozhimen.scank.tflite.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mozhimen.basick.elemk.android.app.cons.CActivity
import com.mozhimen.basick.elemk.androidx.appcompat.bases.databinding.BaseActivityVB
import com.mozhimen.basick.lintk.optins.OApiInit_ByLazy
import com.mozhimen.basick.utilk.android.content.UtilKIntentWrapper
import com.mozhimen.basick.utilk.android.net.uri2bitmap
import com.mozhimen.scank.tflite.edge.TFLiteEdgeDetection
import com.mozhimen.scank.tflite.test.databinding.ActivityEdgeDetectionBinding

class EdgeDetectionActivity : BaseActivityVB<ActivityEdgeDetectionBinding>() {
    @OptIn(OApiInit_ByLazy::class)
    private val _tFLiteEdgeDetection: TFLiteEdgeDetection by lazy { TFLiteEdgeDetection(this) }

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
            bitmap = _tFLiteEdgeDetection.edgeDetect(bitmap)
            vb.edgeImg.setImageBitmap(bitmap)
        }
    }
}