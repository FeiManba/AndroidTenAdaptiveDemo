package com.frmanba.ten.adaptive

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity


class BaseActivity : AppCompatActivity() {

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        when (newConfig.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_NO -> {
                // 关闭
            }
            Configuration.UI_MODE_NIGHT_YES -> {
                //开启
            }
            else -> {
                //其他
            }
        }
    }

}