package com.ulisesdiaz.listview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.ulisesdiaz.listview.adapters.AdaptadorCustom
import com.ulisesdiaz.listview.models.Fruta

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lista = findViewById<ListView>(R.id.lista)

        val valor = intent.getStringExtra("IDLISTA")

        if (valor == "lista-simple"){
            // En este fragmento se setea un arreglo a una lista simple de Android
            var frutas:ArrayList<String> = ArrayList()
            frutas.add("Manzana")
            frutas.add("Durazno")
            frutas.add("Platano")
            frutas.add("Sandia")

            val adaptador = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, frutas)

            lista.adapter = adaptador

            lista.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
                Toast.makeText(this, frutas.get(position), Toast.LENGTH_LONG).show()
            }

        }else if(valor =="lista-customizada"){
            // Lista personalizada
            var frutas:ArrayList<Fruta> = ArrayList()
            frutas.add(Fruta("Manzana", R.drawable.manzana, Color.GRAY))
            frutas.add(Fruta("Durazno", R.drawable.durazno, Color.GRAY))
            frutas.add(Fruta("Platano", R.drawable.platano, Color.GRAY))
            frutas.add(Fruta("Sandia", R.drawable.sandia, Color.GRAY))

            val adaptador = AdaptadorCustom(this, frutas)
            lista.adapter = adaptador

            lista.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
                Toast.makeText(this, frutas.get(position).nombre, Toast.LENGTH_LONG).show()
            }
        }
    }
}