package com.example.elozino_task_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import com.example.elozino_task_5.util.ValidatorUtil
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    lateinit var nameText: String
    lateinit var phoneNumberValue: String
    lateinit var emailText: String
    lateinit var sexText: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = resources.getStringArray(R.array.sex_array)
        val adapter = ArrayAdapter(this, R.layout.sex_list, items)
        val sexDropDown = findViewById<AutoCompleteTextView>(R.id.sex_drop_down)
        sexDropDown.setAdapter(adapter)

        //get references to Name edittext field
        val name = findViewById<TextInputEditText>(R.id.et_name)

        //get references to Email edittext field
        val email = findViewById<TextInputEditText>(R.id.et_email)

        //get references to Phone edittext field
        val phone = findViewById<TextInputEditText>(R.id.et_phone)

        //get reference to Register button and set on-click listener
        val register = findViewById<Button>(R.id.button_register)

        register.setOnClickListener {

            nameText = name.text.toString()
            phoneNumberValue = phone.text.toString()
            emailText = email.text.toString()
            sexText = sexDropDown.text.toString()

            if(!ValidatorUtil.isNameValid(nameText)) {
                Toast.makeText(this, "Please input a valid name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!ValidatorUtil.isPhoneNumberValid(phoneNumberValue)) {
                Toast.makeText(this, "Input correct phone number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!ValidatorUtil.isEmailValid(emailText)) {
                Toast.makeText(this, "Please input a valid email address", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!ValidatorUtil.isSexEntryValid(sexText)) {
                Toast.makeText(this, "Select sex", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            //confirm if all validation calls are passed
            if(nameText.isNotBlank() && phoneNumberValue.isNotBlank() && emailText.isNotBlank() && sexText.isNotBlank()) {
                loadNextActivity(nameText, phoneNumberValue, emailText, sexText)
            }
        }
    }

    private fun loadNextActivity(name: String, phone: String, email: String, sex: String) {
        val intent = Intent(this@MainActivity, InformationActivity::class.java)
        intent.putExtra("name", name)
        intent.putExtra("phone", phone)
        intent.putExtra("email", email)
        intent.putExtra("sex", sex)

        //launch the activity showing the user's information
        startActivity(intent)
    }
}