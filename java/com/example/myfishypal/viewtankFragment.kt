package com.example.myfishypal

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.database.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */

class viewtankFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_aquarium, container, false)
    }


    lateinit var submit: Button
    lateinit var ref: DatabaseReference
    lateinit var tanklist: MutableList<aquarium>
    lateinit var listView: ListView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //getting user input
        tanklist = mutableListOf()
         ref = FirebaseDatabase.getInstance().getReference("aquariums")
        submit = view.findViewById<Button>(R.id.submit_tank)
        listView = view.findViewById(R.id.AQUARIUM_VIEW)

        submit.setOnClickListener {
            findNavController().navigate(R.id.action_viewtankFragment_to_FirstFragment)
        }

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot!!.exists()) {
                    for (t in snapshot.children) {
                        val tank = t.getValue(aquarium::class.java)
                        tanklist.add(tank!!)
                    }
                    val cont : Context
                    cont = requireActivity().getApplicationContext();
                    val adapter = viewaquariumadapter(cont, R.layout.fragment_aqauriums, tanklist)
                    listView.adapter = adapter

                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        });
    }



}