package com.example.problem2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var blist: ArrayList<Product>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private var onClickListener: OnClickListener ?= null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        holder.productName.text = blist[position].productName
        holder.productDescription.text = blist[position].productDescription
        holder.cost.text = "$ ${blist[position].cost}"
        holder.logo.setImageResource(blist[position].logo)
        holder.image.setImageResource(blist[position].image)

        holder.button.setOnClickListener {
            onClickListener!!.onClickAdd(blist[position])
        }

        holder.itemView.setOnClickListener {
            onClickListener!!.onClickShow(blist[position])
        }
    }

    override fun getItemCount(): Int {
        return blist.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productName: TextView = itemView.findViewById(R.id.name)
        val productDescription: TextView = itemView.findViewById(R.id.description)
        val cost: TextView = itemView.findViewById(R.id.cost)
        val button: Button = itemView.findViewById(R.id.button)
        val logo: ImageView = itemView.findViewById(R.id.logo)
        val image: ImageView = itemView.findViewById(R.id.image)
    }

    interface OnClickListener{
        fun onClickAdd(product: Product)
        fun onClickShow(product: Product)
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }
}