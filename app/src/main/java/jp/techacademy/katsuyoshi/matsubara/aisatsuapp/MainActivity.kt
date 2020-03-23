package jp.techacademy.katsuyoshi.matsubara.aisatsuapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.app.TimePickerDialog
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        showTimePickerDialog()
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                Log.d("UI_PARTS", "$hour:$minute")
                showAisatsu(hour)
            },
            0, 0, true
        )
        timePickerDialog.show()
    }

    private fun showAisatsu(h: Int) {
        when (h) {
            in 2..9 -> textView.text = "おはよう"
            in 10..17 -> textView.text = "こんにちは"
            else -> textView.text = "こんばんは"
        }
    }
}
