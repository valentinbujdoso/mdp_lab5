package com.example.lab5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab5.databinding.ActivitySurveyBinding

private lateinit var binding: ActivitySurveyBinding

class SurveyActivity : AppCompatActivity() {
    val questions = ArrayList<ButtonData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySurveyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intt = intent // Similar to  Intent intent = getIntent()
        val type = intt.getStringExtra("type")

        if(type.equals("Food Preferences")) {
            binding.header.text = "Food Preferences"
            questions.add(ButtonData("What is your favorite cuisine?", arrayOf("Chinese", "French", "Italian", "Indian", "Japanese", "Thai", "Turkish")))
            questions.add(ButtonData("How often do you eat out?", arrayOf("Yes", "No")))
            questions.add(ButtonData("Do you prefer spicy food?", arrayOf("Yes", "No")))
            questions.add(ButtonData("Do you prefer vegetarian food?", arrayOf("Yes", "No")))
            questions.add(ButtonData("Do you like seafood?", arrayOf("Yes", "No")))
        } else {
            binding.header.text = "Dietary Habits"
            questions.add(ButtonData("Are you vegetarian?", arrayOf("Yes", "No")))
            questions.add(ButtonData("Do you prefer organic food?", arrayOf("Yes", "No")))
            questions.add(ButtonData("Do you consume dairy products?", arrayOf("Yes", "No")))
            questions.add(ButtonData("Do you eat fast food?", arrayOf("Yes", "No")))
            questions.add(ButtonData("Do you have any food allergies?", arrayOf("Yes", "No")))
        }

        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        val adapter = MyAdapter(questions)
        binding.recyclerview.adapter = adapter
    }

    fun onSubmit(view: View){
        val result = ArrayList<String>()
        val size = this.questions.size
        for (i in 0..<size) {
            val id = binding.recyclerview.findViewById<RadioGroup>(i).checkedRadioButtonId
            if (id == -1) {
                var tst = Toast.makeText(applicationContext,"You have to choose one answer for all of the questions!", Toast.LENGTH_LONG);
                tst.show()
                return
            } else {
                val radio = findViewById<RadioButton>(id)
                result.add(questions.get(i).question + " " + radio.text)
            }
        }

        val arrayAdapter: ArrayAdapter<*>
        var mListView = findViewById<ListView>(R.id.resultlist)

        arrayAdapter = ArrayAdapter(view.context,
            android.R.layout.simple_list_item_1, result)
        mListView.adapter = arrayAdapter
    }
}