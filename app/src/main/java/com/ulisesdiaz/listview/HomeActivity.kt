package com.ulisesdiaz.listview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val btnListaSimple = findViewById<Button>(R.id.btnListasimpe)
        val btnListaCustomizada = findViewById<Button>(R.id.btnListaCustomizada)

        btnListaSimple.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra("IDLISTA","lista-simple")
            startActivity(intent)
        }

        btnListaCustomizada.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra("IDLISTA","lista-customizada")
            startActivity(intent)
        }
    }
}