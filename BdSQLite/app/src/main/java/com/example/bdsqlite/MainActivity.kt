package com.example.bdsqlite

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnVerDados = findViewById<Button>(R.id.btnVerDados)

        btnVerDados.setOnClickListener {

            val intent = Intent(this, ListaActivity::class.java)

            startActivity(intent)
        }

        val edtNome = findViewById<EditText>(R.id.edtNome)
        val edtEndereco = findViewById<EditText>(R.id.edtEndereco)
        val edtBairro = findViewById<EditText>(R.id.edtBairro)
        val edtCep = findViewById<EditText>(R.id.edtCep)

        val btnCadastrar = findViewById<Button>(R.id.btnCadastrar)

        btnCadastrar.setOnClickListener {

            val intent = Intent(this, RespostaActivity::class.java)

            intent.putExtra("nome", edtNome.text.toString())
            intent.putExtra("endereco", edtEndereco.text.toString())
            intent.putExtra("bairro", edtBairro.text.toString())
            intent.putExtra("cep", edtCep.text.toString())

            startActivity(intent)
        }
    }
}