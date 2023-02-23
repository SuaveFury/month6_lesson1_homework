package com.example.month6_lesson1_homework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.month6_lesson1_homework.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        intentInit()
        init()
    }
    private fun intentInit(){
        val intent = intent.getStringExtra(MainActivity.KEY)
        binding.editTextSecond.setText(intent)
    }
    private fun init(){
        binding.btnEnterSecond.setOnClickListener {
            if(binding.editTextSecond.text.isNotEmpty()) {
                val text = binding.editTextSecond.text.toString()
                setResult(RESULT_OK, Intent().putExtra(MainActivity.KEY, text))
                finish()
            }else{Toast.makeText(this,getString(R.string.error),Toast.LENGTH_SHORT).show()}}}
}