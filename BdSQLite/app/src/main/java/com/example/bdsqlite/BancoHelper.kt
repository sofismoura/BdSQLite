package com.example.bdsqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BancoHelper(context: Context) :
    SQLiteOpenHelper(context, "banco.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {

        val sql = """
            CREATE TABLE pessoa (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nome TEXT,
                endereco TEXT,
                bairro TEXT,
                cep TEXT
            )
        """.trimIndent()

        db.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        db.execSQL("DROP TABLE IF EXISTS pessoa")
        onCreate(db)
    }

    fun addPessoa(
        nome: String,
        endereco: String,
        bairro: String,
        cep: String
    ) {

        val db = writableDatabase

        val values = ContentValues()

        values.put("nome", nome)
        values.put("endereco", endereco)
        values.put("bairro", bairro)
        values.put("cep", cep)

        db.insert("pessoa", null, values)

        db.close()
    }
}