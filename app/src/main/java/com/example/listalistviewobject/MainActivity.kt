package com.example.listalistviewobject

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.listalistviewobject.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val utilizadorDao by lazy {
        AppDatabase.getInstance(applicationContext).utilizadorDao()
    }
    private lateinit var adapter: ArrayAdapter<Utilizador>
    private val listaUtilizadores = ArrayList<Utilizador>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = object : ArrayAdapter<Utilizador>(
            this,
            android.R.layout.simple_list_item_1,
            listaUtilizadores
        ) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getView(position, convertView, parent)
                val utilizador = getItem(position)
                (view as TextView).text = utilizador?.username ?: ""
                return view
            }
        }

        binding.listViewUtilizadores.adapter = adapter

        binding.buttonAdd.setOnClickListener {
            val username = binding.editUsername.text.toString().trim()
            val password = binding.editPassword.text.toString().trim()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                GlobalScope.launch(Dispatchers.IO) {
                    utilizadorDao.insertUtilizador(Utilizador(username = username, password = password))
                    withContext(Dispatchers.Main) {
                        listaUtilizadores.clear()
                        listaUtilizadores.addAll(utilizadorDao.getAllUtilizadores())
                        adapter.notifyDataSetChanged()
                    }
                }
            }
        }
    }
}



