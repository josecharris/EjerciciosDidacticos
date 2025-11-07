package com.edu.uptc.ejerciciosdidacticos

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.edu.uptc.ejerciciosdidacticos.databinding.ActivityHomeBinding
import com.edu.uptc.ejerciciosdidacticos.showuser.ui.ShowUserActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityHomeBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(this.binding.root)
        this.binding.idCardShowUsers.setOnClickListener {
            val intent = Intent(this, ShowUserActivity::class.java)
            startActivity(intent)
        }
    }
}