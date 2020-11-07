package com.farid.collaps

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.WindowManager
import android.widget.RelativeLayout
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.farid.collaps.drawLine.DrawView
import kotlinx.android.synthetic.main.activity_core.*


class CoreActivity : AppCompatActivity() {
    var drawView1: DrawView? = null
    var drawView2: DrawView? = null
    var drawView3: DrawView? = null
    var drawView4: DrawView? = null


    var width = 0
    var height = 0
    val coreData = mutableMapOf<Int, Pair<Int, Int>>()
    val coreCheck = mutableListOf<Boolean>(false, false, false, false)

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_core)
        getScreenSize(this)
        makeRandomPosition()
        setItemOfEachPosition()
        //draw()

    }


    private fun getScreenSize(context: Context) {
        val wm =
            context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val metrics = DisplayMetrics()
        display.getMetrics(metrics)
        width = metrics.widthPixels
        height = metrics.heightPixels
        println("{$width,  $height}")

    }

    fun makeRandomPosition() {
        for (i in 0..4) {
            val one = (0..width - 50).random()
            val two = (0..width - 50).random()
            var pair = Pair(one, two)
            coreData.put(i, pair)
        }

        //   println("the name is ${coreData.get(0)!!.first}")


    }

    fun setItemOfEachPosition() {


        iv1.x = coreData.get(0)!!.first.toFloat()
        iv1.y = coreData.get(0)!!.second.toFloat()
        iv2.x = coreData.get(1)!!.first.toFloat()
        iv2.y = coreData.get(1)!!.second.toFloat()

        iv3.x = coreData.get(2)!!.first.toFloat()
        iv3.y = coreData.get(2)!!.second.toFloat()

        iv4.x = coreData.get(3)!!.first.toFloat()
        iv4.y = coreData.get(3)!!.second.toFloat()

        iv5.x = coreData.get(4)!!.first.toFloat()
        iv5.y = coreData.get(4)!!.second.toFloat()
        draw()
    }

    fun draw() {
        drawView1 = DrawView(this, iv1, iv2, null, null, null, null, null, null)

        iv1.setOnClickListener {
            drawView1!!.setBackgroundColor(Color.BLACK)
            rl1.addView(drawView1)
            coreCheck[0] = true
        }
        iv2.setOnClickListener {
            if (coreCheck[0]) {
                drawView2 = DrawView(this, iv1, iv2, iv2, iv3, null, null, null, null)
                drawView2!!.setBackgroundColor(Color.BLACK)
                rl1.addView(drawView2)
                coreCheck[1] = true
            }

        }
        iv3.setOnClickListener {
            if (coreCheck[0] && coreCheck[1]) {


                drawView3 = DrawView(this, iv1, iv2, iv2, iv3, iv3, iv4, null, null)
                drawView3!!.setBackgroundColor(Color.BLACK)
                rl1.addView(drawView3)
                coreCheck[2] = true

            }
        }
        iv4.setOnClickListener {
            if (coreCheck[0] && coreCheck[1] && coreCheck[2]) {


                drawView4 = DrawView(this, iv1, iv2, iv2, iv3, iv3, iv4, iv4, iv5)
                drawView4!!.setBackgroundColor(Color.BLACK)
                rl1.addView(drawView4)
            }
        }

    }


}