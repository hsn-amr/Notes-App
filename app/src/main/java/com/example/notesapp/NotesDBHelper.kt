package com.example.notesapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class NotesDBHelper(context: Context): SQLiteOpenHelper(context,"Notes.db", null, 1) {

    private var sqliteDatabase: SQLiteDatabase = writableDatabase

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE Note (text text)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun saveNote(noteText: String): Long{
        val cv = ContentValues()
        cv.put("text", noteText)
        val result = sqliteDatabase.insert("Note", null, cv)
        return result
    }
}