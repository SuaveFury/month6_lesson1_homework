package com.example.month6_lesson1_homework

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.month6_lesson1_homework.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var result: ActivityResultLauncher<Intent>
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        intentText()
        check()
        registerActivity()
    }
    private fun intentText() {
        binding.editTextSecond.setText(intent.getStringExtra(EXTRA_MESSAGE))
    }
    private fun registerActivity() {
        result = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {binding.editTextSecond.setText(it.data?.getStringExtra(EXTRA_MESSAGE))}
        }
    }
    private fun intentAndData() {
        val intent = Intent(applicationContext, MainActivity::class.java)
        intent.putExtra(EXTRA_MESSAGE, binding.editTextSecond.text.toString())
        result.launch(intent)
    }
    private fun check() {
        binding.btnEnterSecond.setOnClickListener {
            if (binding.editTextSecond.text.isEmpty()){
                Toast.makeText(this,"Error, edit text is empty!", Toast.LENGTH_SHORT).show()
            } else intentAndData()}
    }
}