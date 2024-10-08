package com.mozhimen.scank.tflite.test

import android.view.View
import com.mozhimen.kotlin.utilk.android.content.startContext
import com.mozhimen.scank.tflite.test.databinding.ActivityMainBinding
import com.mozhimen.bindk.bases.viewbinding.activity.BaseActivityVB

class MainActivity : BaseActivityVB<ActivityMainBinding>() {
    fun goEdgeDetection(view: View){
        startContext<EdgeDetectionActivity>()
    }
}