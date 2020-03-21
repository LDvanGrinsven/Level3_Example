package com.example.level3_example

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.content_add.*

const val EXTRA_REMINDER = "EXTRA_REMINDER"

class ReminderAddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initViews()
    }
    private fun initViews() {
        fab.setOnClickListener { onSaveClick() }
    }

    private fun onSaveClick() {
        if (etAddReminder.text.toString().isNotBlank()) {
            val reminder = Reminder(etAddReminder.text.toString())
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_REMINDER, reminder)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        } else {
            Toast.makeText(this,"The reminder cannot be empty"
                , Toast.LENGTH_SHORT).show()
        }
    }

}
