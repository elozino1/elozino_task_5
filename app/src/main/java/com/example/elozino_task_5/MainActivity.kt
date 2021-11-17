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

    var information = hashMapOf<String, String>()

    lateinit var nameText: String
    lateinit var phoneNumberValue: String
    lateinit var emailText: String


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
            val sexText = sexDropDown.text.toString()

            if(ValidatorUtil.isNameValid(nameText)) {
                information.put("name", nameText)
            } else Toast.makeText(this, "Please input a valid name", Toast.LENGTH_SHORT).show()

            if (ValidatorUtil.isPhoneNumberValid(phoneNumberValue)) {
                information.put("phone", phoneNumberValue)
            } else Toast.makeText(this, "Input correct phone number", Toast.LENGTH_SHORT).show()

            if (ValidatorUtil.isEmailValid(emailText)) {
                information.put("email", emailText)
            }  else Toast.makeText(this, "Please input a valid email address", Toast.LENGTH_SHORT).show()

            if (ValidatorUtil.isSexEntryValid(sexText)) {
                information.put("sex", sexText)
            } else Toast.makeText(this, "Select sex", Toast.LENGTH_SHORT).show()


            if(information.containsKey("name") && information.containsKey("phone") && information.containsKey("email") && information.containsKey("sex")) {
                loadNextActivity(information)
            }
        }

    }

    private fun loadNextActivity(information: HashMap<String, String>) {
        var intent = Intent(this@MainActivity, InformationActivity::class.java)
        intent.putExtra("name", information.get("name"))
        intent.putExtra("phone", information.get("phone"))
        intent.putExtra("email", information.get("email"))
        intent.putExtra("sex", information.get("sex"))

        startActivity(intent)
    }
}