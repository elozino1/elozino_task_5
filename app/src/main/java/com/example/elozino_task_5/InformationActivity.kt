package com.example.elozino_task_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class InformationActivity : AppCompatActivity() {
    lateinit var nameText: TextView
    lateinit var phoneText: TextView
    lateinit var emailText: TextView
    lateinit var sexText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)

        val intent = intent

        nameText = findViewById(R.id.name_content)
        phoneText = findViewById(R.id.phone_content)
        emailText = findViewById(R.id.email_content)
        sexText = findViewById(R.id.sex_content)

        nameText.text = intent.getStringExtra("name")
        phoneText.text = intent.getStringExtra("phone")
        emailText.text = intent.getStringExtra("email")
        sexText.text = intent.getStringExtra("sex")

    }
}