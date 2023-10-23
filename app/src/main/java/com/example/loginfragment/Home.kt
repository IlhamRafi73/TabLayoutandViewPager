package com.example.loginfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginfragment.Login.Companion.EXTRA_NAME
import com.example.loginfragment.Register.Companion.EXTRA_NAME2
import com.example.loginfragment.databinding.ActivityHomeBinding

private lateinit var binding: ActivityHomeBinding

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(EXTRA_NAME)
        val username2 = intent.getStringExtra(EXTRA_NAME2)

        with(binding){
            unamePlace2.text = username2
            unamePlace.text = username
        }
    }
}
