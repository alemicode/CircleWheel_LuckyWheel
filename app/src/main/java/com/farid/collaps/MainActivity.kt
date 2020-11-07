package com.farid.collaps

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.provider.MediaStore
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import github.hellocsl.cursorwheel.CursorWheelLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.channels.ticker
import java.util.*


class MainActivity : AppCompatActivity() {


    private var mTimer1: Timer? = null
    private var mTt1: TimerTask? = null
    private val mTimerHandler: Handler = Handler()
    val tickerChannel = ticker(delayMillis = 60_000, initialDelayMillis = 0)
    var itemChoser: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var menuItemData1 = MenuItemData(R.drawable.mic, "microphone")
        var menuItemData2 = MenuItemData(R.drawable.capture, "camera")
        var menuItemData3 = MenuItemData(R.drawable.filming, "rec")
        var menuItemData4 =
            MenuItemData(R.drawable.playy, "fragment")
        val list = listOf(menuItemData1, menuItemData2, menuItemData3, menuItemData4)
        var adapter = SimpleTextAdapter(this, list)
        wheel.setAdapter(adapter)
        wheel.setOnMenuSelectedListener(object : MenuItem.OnMenuItemClickListener,
            CursorWheelLayout.OnMenuSelectedListener {
            override fun onItemSelected(parent: CursorWheelLayout?, view: View?, pos: Int) {
                when (list.get(pos).imageDescription) {
                    "microphone" -> {

                        itemChoser = 0
                    }
                    "camera" -> {
                        itemChoser = 1
                    }
                    "rec" -> {
                        itemChoser = 2

                    }
                    "fragment" -> {
                        itemChoser = 3
                    }

                }

            }

            override fun onMenuItemClick(p0: MenuItem?): Boolean {

                return true
            }

        })

        tv_open.setOnClickListener {

            when (list.get(itemChoser).imageDescription) {
                "microphone" -> {

                    var recordIntent = Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
                    startActivityForResult(recordIntent, RESULT_OK); }
                "camera" -> {
                    val intent = Intent("android.media.action.IMAGE_CAPTURE")
                    startActivity(intent)
                }
                "rec" -> {
                    val intent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
                    startActivityForResult(intent, 101)
                }
                "fragment" -> {

                    startActivity(Intent(this, CoreActivity::class.java))
                }

            }


        }
    }


}