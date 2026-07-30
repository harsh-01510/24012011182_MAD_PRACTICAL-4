package com.example.a24012011182_mad_practical_4

import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    lateinit var textAlarm: TextView
    lateinit var cardSetAlarm: MaterialCardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        textAlarm = findViewById<TextView>(R.id.textView)
        cardSetAlarm = findViewById(R.id.materialCardView2)
        // cardSetAlarm.visibility = View.GONE // Removed this line to make the card visible
        findViewById<MaterialButton>(R.id.set_alarm_btn).setOnClickListener {
            showTimeDialog()
        }
        findViewById<MaterialButton>(R.id.cancel_alarm_btn).setOnClickListener {

        }
    }

    private fun showTimeDialog(){
        val cldr: Calendar= Calendar.getInstance()
        val hrs:Int = cldr.get(Calendar.HOUR_OF_DAY)
        val mns:Int = cldr.get(Calendar.MINUTE)
        val picker = TimePickerDialog(
            this, {tp,sHour,sMinute -> sendDialogDataToActivity(sHour,sMinute)},hrs,mns,false
        )
        picker.show()
    }
    private fun sendDialogDataToActivity(hour:Int, minute:Int){

    }
}