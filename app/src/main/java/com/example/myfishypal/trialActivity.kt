package com.example.myfishypal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.database.FirebaseDatabase

class trialActivity : AppCompatActivity() {
    lateinit var tank_name: EditText
    lateinit var tank_size: EditText
    lateinit var tank_lights: EditText
    lateinit var tank_filter: EditText
    lateinit var tank_substrate: EditText
    lateinit var submit: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trial)
    }



     fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //super.onViewCreated(view, savedInstanceState)
        //getting user input

       tank_name = view.findViewById<EditText>(R.id.input_tank_name)
       tank_size = view.findViewById<EditText>(R.id.input_tank_size)
       tank_lights = view.findViewById<EditText>(R.id.input_lights)
        tank_filter = view.findViewById<EditText>(R.id.input_tank_filter)
         tank_substrate = view.findViewById<EditText>(R.id.input_tank_substrate)
        submit = view.findViewById<Button>(R.id.submit_aquarium)



       submit.setOnClickListener {

           // savetofire()
          //  Toast.makeText(this, "Aquarium was added successfully", Toast.LENGTH_LONG).show()
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun savetofire() {
        val ref = FirebaseDatabase.getInstance().getReference("aquariums")
        val prodid = ref.push().key
        val aquariumvar = aquarium(prodid.toString(), tank_name.text.toString(), tank_size.text.toString(),tank_lights.text.toString(),tank_filter.text.toString(), tank_substrate.text.toString())
        ref.child(prodid.toString()).setValue(aquariumvar).addOnCompleteListener {
           Toast.makeText(this, "Aquarium was added successfully", Toast.LENGTH_LONG).show()
        }
    }
}