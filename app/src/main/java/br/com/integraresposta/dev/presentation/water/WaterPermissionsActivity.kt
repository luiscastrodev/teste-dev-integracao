package br.com.integraresposta.dev.presentation.water

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.viewModels
import br.com.integraresposta.dev.R
import br.com.integraresposta.dev.data.dto.Items
import br.com.integraresposta.dev.data.dto.WaterPemissionsResponse
import br.com.integraresposta.dev.databinding.ActivityMainBinding
import br.com.integraresposta.dev.databinding.ActivityWaterPermissionsBinding
import br.com.integraresposta.dev.presentation.login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WaterPermissionsActivity : AppCompatActivity() {

    private val viewModel: WaterPermissionViewModel by viewModels()

    private val binding by lazy {
        ActivityWaterPermissionsBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //observer
        viewModel.waterPermissionResult.observe(this) { result ->
            result.onSuccess { waterPermissions ->
                createButtons(waterPermissions)
            }.onFailure { exception ->
                Toast.makeText(applicationContext,exception.message, Toast.LENGTH_LONG).show()
            }
        }

        viewModel.isLoading.observe(this) { isLoading ->
            binding.loginProgress.visibility = if (isLoading) View.VISIBLE else View.GONE
            binding.buttonsContainer.visibility = View.VISIBLE
        }

        viewModel.getWaterPermissions()
    }

   private fun createButtons(waterPermissionsResponse: WaterPemissionsResponse) {
        val layout = binding.buttonsContainer

        val commonButton = Button(this).apply {
            text = waterPermissionsResponse.actions.common.label
            setOnClickListener {
                Toast.makeText(applicationContext, "selected: $text", Toast.LENGTH_SHORT).show()
            }
        }
        layout.addView(commonButton)
        createItemButtons(waterPermissionsResponse.actions.common.items, layout)

        val networkButton = Button(this).apply {
            text = waterPermissionsResponse.actions.network.label
            setOnClickListener {
                Toast.makeText(applicationContext, "selected: $text", Toast.LENGTH_SHORT).show()
            }
        }
        layout.addView(networkButton)
    }

    private fun createItemButtons(items: Items, layout: LinearLayout) {
        val itemButton = Button(layout.context).apply {
            text = items.open.label
            setOnClickListener {
                Toast.makeText(layout.context, "selected: $text", Toast.LENGTH_SHORT).show()
            }
        }
        layout.addView(itemButton)
    }
}