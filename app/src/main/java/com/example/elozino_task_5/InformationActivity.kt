package com.example.elozino_task_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class InformationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)

        val intent = intent

        findViewById<TextView>(R.id.name_content).text = intent.getStringExtra("name")
        findViewById<TextView>(R.id.phone_content).text = intent.getStringExtra("phone")
        findViewById<TextView>(R.id.email_content).text = intent.getStringExtra("email")
        findViewById<TextView>(R.id.sex_content).text = intent.getStringExtra("sex")
    }
}