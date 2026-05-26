package com.example.bdsqlite

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class RespostaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resposta)
        val btnVerDados = findViewById<Button>(R.id.btnVerDados)

        btnVerDados.setOnClickListener {

            val intent = Intent(this, ListaActivity::class.java)

            startActivity(intent)
        }
        val edtNome = findViewById<EditText>(R.id.edtNomeResposta)
        val edtEndereco = findViewById<EditText>(R.id.edtEnderecoResposta)
        val edtBairro = findViewById<EditText>(R.id.edtBairroResposta)
        val edtCep = findViewById<EditText>(R.id.edtCepResposta)

        val btnSalvar = findViewById<Button>(R.id.btnSalvar)

        val nome = intent.getStringExtra("nome")
        val endereco = intent.getStringExtra("endereco")
        val bairro = intent.getStringExtra("bairro")
        val cep = intent.getStringExtra("cep")

        edtNome.setText(nome)
        edtEndereco.setText(endereco)
        edtBairro.setText(bairro)
        edtCep.setText(cep)

        val db = BancoHelper(this)

        btnSalvar.setOnClickListener {

            db.addPessoa(
                edtNome.text.toString(),
                edtEndereco.text.toString(),
                edtBairro.text.toString(),
                edtCep.text.toString()
            )

            Toast.makeText(this, "Dados salvos!", Toast.LENGTH_SHORT).show()

            finish()
        }
    }
}