package com.example.problem2

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        findViewById<TextView>(R.id.name).text = intent.getStringExtra("name")
        findViewById<TextView>(R.id.description).text = intent.getStringExtra("description")
        findViewById<TextView>(R.id.cost).text = intent.getStringExtra("cost")
        findViewById<ImageView>(R.id.image).setImageResource(intent.getIntExtra("image", R.drawable.amazon))

        findViewById<Button>(R.id.button).setOnClickListener {
            this.finish()
        }
    }
}