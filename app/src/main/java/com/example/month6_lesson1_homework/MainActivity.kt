package com.example.month6_lesson1_homework

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.month6_lesson1_homework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == Activity.RESULT_OK){binding.editText.setText(it.data?.getStringExtra(KEY))}}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }
    private fun init(){
        binding.btnEnterMain.setOnClickListener {
            if(binding.editText.text.isNotEmpty()) {
                register.launch(Intent(this, MainActivity2::class.java).apply { putExtra(KEY,binding.editText.text.toString())})
            }else{
                Toast.makeText(this,getString(R.string.error),Toast.LENGTH_SHORT).show()
            }
        }
    }
    companion object {
        const val KEY = "key"
    }
}