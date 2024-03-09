package com.example.lab5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import com.example.lab5.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val id = binding.radiogroup.checkedRadioButtonId
            if (id != -1) {
                val radio = findViewById<RadioButton>(id)

                val intent = Intent(this, SurveyActivity::class.java)
                intent.putExtra("type", radio.text)
                startActivity(intent)
            } else {
                Toast.makeText(applicationContext, "You have to choose which survey would like to fill",Toast.LENGTH_SHORT).show()
            }
        }

    }
}