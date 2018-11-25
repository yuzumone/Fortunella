package net.fortunella.sample.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import net.fortunella.Failure
import net.fortunella.Success
import net.fortunella.sample.R
import net.fortunella.sample.databinding.ActivityMainBinding
import net.fortunella.sample.domain.TestUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val useCase by lazy { TestUseCase() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.buttonSuccess.setOnClickListener {
            useCase(true) { result ->
                when (result) {
                    is Success -> binding.textSuccess.text = result.value
                }
            }
        }
        binding.buttonFailure.setOnClickListener {
            useCase(false) { result ->
                when (result) {
                    is Failure -> {
                        runOnUiThread { binding.textFailure.text = result.reason.message }
                    }
                }
            }
        }
    }
}