package br.com.integraresposta.dev.presentation.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import br.com.integraresposta.dev.R
import br.com.integraresposta.dev.databinding.ActivityMainBinding
import br.com.integraresposta.dev.presentation.water.WaterPermissionsActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModels()
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            val username = binding.username.text.toString()
            val password = binding.password.text.toString()
            viewModel.login(username, password)
        }

        //observer
        viewModel.loginResult.observe(this) { result ->
            result.onSuccess { _ ->
                val intent = Intent(this@LoginActivity,WaterPermissionsActivity::class.java)
                startActivity(intent)
            }.onFailure { exception ->
                Toast.makeText(applicationContext,exception.message,Toast.LENGTH_LONG).show()
            }
        }

        viewModel.isLoading.observe(this) { isLoading ->
            binding.loginProgress.visibility = if (isLoading) View.VISIBLE else View.GONE
            binding.loginButton.isEnabled = !isLoading
        }
    }
}