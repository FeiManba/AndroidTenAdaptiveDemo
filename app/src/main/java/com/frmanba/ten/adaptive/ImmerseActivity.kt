package com.frmanba.ten.adaptive

import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_immerse_ui.*

class ImmerseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_immerse_ui)
        val params: FrameLayout.LayoutParams = tool_bar.layoutParams as FrameLayout.LayoutParams
        params.setMargins(0, getStatusBarHeight(this), 0, 0)
        tool_bar.layoutParams = params
        setSupportActionBar(tool_bar)

    }

    /**
     * 获取状态栏高度
     * @param context
     * @return
     */
    fun getStatusBarHeight(context: Context): Int {
        val resources: Resources = context.resources
        val resourceId: Int = resources.getIdentifier("status_bar_height", "dimen", "android")
        return resources.getDimensionPixelSize(resourceId)
    }
}