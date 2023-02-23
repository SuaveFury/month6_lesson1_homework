package com.example.month6_lesson1_homework

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.month6_lesson1_homework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var result: ActivityResultLauncher<Intent>
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intentText()
        check()
        registerActivity()
    }
    private fun intentText() {
        binding.editText.setText(intent.getStringExtra(EXTRA_MESSAGE))
    }
    private fun registerActivity() {
        result = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                binding.editText.setText(it.data?.getStringExtra(EXTRA_MESSAGE))
            }
        }
    }
    private fun intentAndData() {
        val intent = Intent(applicationContext, MainActivity2::class.java)
        intent.putExtra(EXTRA_MESSAGE, binding.editText.text.toString())
        result.launch(intent)
    }
    private fun check() {
        binding.btnEnterMain.setOnClickListener {
            if (binding.editText.text.isEmpty()) {
                Toast.makeText(this,"Error, edit text is empty!", Toast.LENGTH_SHORT).show()
            } else {intentAndData()}
        }
    }
}