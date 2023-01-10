package com.example.traintips

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.traintips.databinding.ActivityBookTripBinding

class BookTripActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding by lazy { ActivityBookTripBinding.inflate(layoutInflater) }
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}