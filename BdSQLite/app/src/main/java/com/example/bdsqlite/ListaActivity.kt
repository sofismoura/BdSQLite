package com.example.bdsqlite

import android.database.Cursor
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ListaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        val txtDados = findViewById<TextView>(R.id.txtDados)

        val banco = BancoHelper(this)

        val db = banco.readableDatabase

        val cursor: Cursor =
            db.rawQuery("SELECT * FROM pessoa", null)

        val resultado = StringBuilder()

        while (cursor.moveToNext()) {

            val nome =
                cursor.getString(
                    cursor.getColumnIndexOrThrow("nome")
                )

            val endereco =
                cursor.getString(
                    cursor.getColumnIndexOrThrow("endereco")
                )

            val bairro =
                cursor.getString(
                    cursor.getColumnIndexOrThrow("bairro")
                )

            val cep =
                cursor.getString(
                    cursor.getColumnIndexOrThrow("cep")
                )

            resultado.append(
                "Nome: $nome\n" +
                        "Endereço: $endereco\n" +
                        "Bairro: $bairro\n" +
                        "CEP: $cep\n\n"
            )
        }

        txtDados.text = resultado.toString()

        cursor.close()
        db.close()
    }
}