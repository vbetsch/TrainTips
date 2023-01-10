package com.example.traintips

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.traintips.databinding.ActivityMyStationBinding

class MyStationActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMyStationBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}