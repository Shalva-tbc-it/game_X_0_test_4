package com.example.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.game.databinding.ActivityMainBinding
import com.example.game.fragment.HomePageFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        openFrag()

    }

    private fun openFrag() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, HomePageFragment())
            .commit()
    }
}