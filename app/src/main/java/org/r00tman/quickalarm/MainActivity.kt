package org.r00tman.quickalarm

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.view.View
import android.widget.LinearLayout
import android.widget.TimePicker
//import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var picker: TimePicker
//    private var hour: Int = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
//    private var minute: Int = Calendar.getInstance().get(Calendar.MINUTE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        picker = TimePicker(this)

//        picker.setOnTimeChangedListener { _, hourOfDay, minute ->
//            this.hour = hourOfDay
//            this.minute = minute
//        }

        val layout = findViewById<LinearLayout>(R.id.layout)
        layout.addView(picker, 0)
    }

    fun setAlarm(view: View) {
        val i = Intent(AlarmClock.ACTION_SET_ALARM)

//        i.putExtra(AlarmClock.EXTRA_HOUR, hour)
//        i.putExtra(AlarmClock.EXTRA_MINUTES, minute)

        i.putExtra(AlarmClock.EXTRA_HOUR, picker.currentHour)
        i.putExtra(AlarmClock.EXTRA_MINUTES, picker.currentMinute)
        i.putExtra(AlarmClock.EXTRA_SKIP_UI, true)
        startActivity(i)
        this.finish()
    }
}
