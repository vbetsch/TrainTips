package com.example.traintips

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.traintips.databinding.ActivityLeaveNowBinding

class LeaveNowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding by lazy { ActivityLeaveNowBinding.inflate(layoutInflater) }
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}