package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var adapter: RVNotes
    lateinit var rvMain: RecyclerView
    lateinit var noteInput: EditText
    lateinit var addNote: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noteInput = findViewById(R.id.etNoteInput)
        addNote = findViewById(R.id.btnAddNote)

        addNote.setOnClickListener {
            val noteText = noteInput.text.toString()
            if(noteText.isNotEmpty()){
                val notesDBHelper = NotesDBHelper(applicationContext)
                val result = notesDBHelper.saveNote(noteText)
                noteInput.text.clear()
                if(result != -1L){
                    Toast.makeText(this, "Note has added", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this, "Note has not added, try again", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this, "Please, Type a note", Toast.LENGTH_LONG).show()
            }
        }
    }
}