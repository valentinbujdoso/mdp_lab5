package com.example.lab5

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var blist: ArrayList<ButtonData>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_question, parent, false)
        return MyViewHolder(view)
    }

    @SuppressLint("ResourceType")
    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        holder.question.text = blist[position].question
        holder.radioGroup.id = position

        for (i in blist[position].answers) {
            val radioButton = RadioButton(holder.itemView.context)
            radioButton.text = i
            radioButton.id=123
            holder.radioGroup.addView(radioButton)
        }
    }

    override fun getItemCount(): Int {
        return blist.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var question: TextView = itemView.findViewById(R.id.question_text)
        var radioGroup: RadioGroup = itemView.findViewById(R.id.radiogroup)
    }
}