package com.example.problem2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.problem2.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var cart: ArrayList<Product> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val products = ArrayList<Product>()
        products.add(
            Product(
                "iPad",
                "iPad Pro 11-inch",
                400.0,
                R.drawable.apple,
                R.drawable.ipad
            )
        )
        products.add(
            Product(
                "MacBook M3 Pro",
                "12-core CPU\n18-core GPU",
                2500.00,
                R.drawable.apple,
                R.drawable.macbookpro
            )
        )
        products.add(
            Product(
                "Dell Inspiron",
                "13th Gen Intel® Core™ i7",
                1499.00,
                R.drawable.dell,
                R.drawable.laptop
            )
        )
        products.add(
            Product(
                "Logitech Keyboard",
                "Logitech - PRO X\nTKL LIGHTSPEED Wireless",
                199.00,
                R.drawable.logitech,
                R.drawable.keyboard
            )
        )
        products.add(
            Product(
                "MacBook M3 Max",
                "14-core CPU\n30-core GPU",
                3499.00,
                R.drawable.apple,
                R.drawable.macbook
            )
        )


        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        val adapter = MyAdapter(products)
        adapter.setOnClickListener(object : MyAdapter.OnClickListener {
            override fun onClickAdd(product: Product) {
                addToCart(product)
            }

            override fun onClickShow(product: Product) {
                showDetailed(product)
            }
        }
        )

        binding.recyclerview.adapter = adapter
    }

    fun showDetailed(product: Product) {
        val intent = Intent(this, DetailedActivity::class.java)
        intent.putExtra("name", product.productName)
        intent.putExtra("description", product.productDescription)
        intent.putExtra("cost", "$ ${product.cost}")
        intent.putExtra("image", product.image)
        startActivity(intent)
    }

    fun addToCart(product: Product) {
        cart.add(product)
        Toast.makeText(
            applicationContext,
            "Item is added successfully! ${cart.size}",
            Toast.LENGTH_SHORT
        ).show()
    }

    fun showCart(view: View) {
        Toast.makeText(
            applicationContext,
            cart.joinToString(", ") { product -> product.productName },
            Toast.LENGTH_SHORT
        ).show()
    }
}