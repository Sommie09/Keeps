package com.example.keeps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import io.realm.Realm
import java.lang.Exception

class AddKeeps : AppCompatActivity() {
    private lateinit var title: EditText
    private lateinit var description: EditText
    private lateinit var save: Button
    private lateinit var realm: Realm


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_keeps)

        realm = Realm.getDefaultInstance()
        title = findViewById(R.id.title_edit_text)
        description = findViewById(R.id.description_edit_text)
        save = findViewById(R.id.save_notes_button)


        save.setOnClickListener {
            addNotesToDB()
        }

    }

    private fun addNotesToDB() = try{

        //Auto Increment
        realm.beginTransaction()
        val currentIDNumber: Number? = realm.where(Keeps::class.java).max("id")
        val nextID: Int

        nextID= if(currentIDNumber == null){
            1
        }else{
            currentIDNumber.toInt() + 1
        }

        val keeps = Keeps()

        keeps.title = title.text.toString()
        keeps.description = description.text.toString()
        keeps.id = nextID

        realm.copyToRealmOrUpdate(keeps)
        realm.commitTransaction()

        Toast.makeText(this, "Notes Added Successfully", Toast.LENGTH_SHORT).show()

        startActivity(Intent(this, MainActivity::class.java))



    }catch (e: Exception){

        Toast.makeText(this, "Failed $e", Toast.LENGTH_SHORT).show()

    }
}