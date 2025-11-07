package com.edu.uptc.ejerciciosdidacticos.showuser.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.edu.uptc.ejerciciosdidacticos.R
import com.edu.uptc.ejerciciosdidacticos.UserAdapter
import com.edu.uptc.ejerciciosdidacticos.databinding.ActivityShowUserBinding
import com.edu.uptc.ejerciciosdidacticos.login.data.UserDatabaseHelper

class ShowUserActivity : AppCompatActivity() {

    /* Creación del binding */
    private lateinit var binding: ActivityShowUserBinding
    /* Creación del utilitario de BD */
    private lateinit var bd: UserDatabaseHelper
    /* Creación del adaptador */
    private lateinit var adapter: UserAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        this.binding = ActivityShowUserBinding.inflate(layoutInflater)
        this.bd = UserDatabaseHelper(this)
        this.adapter = UserAdapter(this.bd.getUsers(), this)
        setContentView(binding.root)

        binding.idRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.idRecyclerView.adapter = this.adapter
    }

    override fun onResume() {
        super.onResume()
        adapter.refreshData(bd.getUsers())
    }
}