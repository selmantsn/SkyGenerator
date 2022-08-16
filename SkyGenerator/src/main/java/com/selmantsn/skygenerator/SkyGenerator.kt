package com.selmantsn.skygenerator

import android.app.Dialog
import android.content.Context
import android.text.method.ScrollingMovementMethod
import android.view.Window
import android.webkit.WebView
import android.widget.Button
import android.widget.TextView
import com.selmantsn.skygenerator.data.StarProperties

class SkyGenerator : SkyInterface {
    private val smallColorType = arrayOf("Red", "Blue", "Green")
    private val bigColorType = arrayOf("Yellow", "Purple", "Gray")
    private val brightnessType = arrayOf("Bright", "Not so much")
    private val imageUrl =
        "https://img.etimg.com/thumb/msid-72948091,width-650,imgsize-95069,,resizemode-4,quality-100/star_istock.jpg"

    private var dialog: Dialog? = null
    private var starList = arrayListOf<StarProperties>()

    private fun createStarModule(context: Context): Dialog {
        return Dialog(context, android.R.style.Theme_NoTitleBar_Fullscreen).apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setContentView(R.layout.layout_star)
            setCancelable(false)
            show()
        }
    }

    private fun showStarModule(context: Context) {
        dialog = createStarModule(context).apply {
            val webView = findViewById<WebView>(R.id.webView)
            val btnBigStar = findViewById<Button>(R.id.btnBigStar)
            val btnSmallStar = findViewById<Button>(R.id.btnSmallStar)
            val tvLog = findViewById<TextView>(R.id.tvLog)

            tvLog.movementMethod = ScrollingMovementMethod()

            webView.apply {
                settings.loadWithOverviewMode = true
                settings.useWideViewPort = true
                loadUrl(imageUrl)
            }
            var text: String
            btnBigStar.setOnClickListener {
                text = addListAndPrint("B", bigColorType.random(), brightnessType.random())
                print(text)
                tvLog.append(text)

            }
            btnSmallStar.setOnClickListener {
                text = addListAndPrint("S", smallColorType.random(), brightnessType.random())
                print(text)
                tvLog.append(text)
            }
        }
    }

    private fun addListAndPrint(size: String, color: String, brightness: String): String {
        return if (starList.size >= 10) {
            ("Sky is full\n")
        } else {
            starList.add(StarProperties(size, color, brightness))
            ("StarList: (${starList.size} items), ${starList.filter { it.brightness == "Bright" }.size} bright stars ->\n $starList\n")
        }
    }

    override fun addStarInterface(context: Context) {
        showStarModule(context)
    }

}