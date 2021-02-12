package com.example.myfishypal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.database.FirebaseDatabase

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ThirdFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FourthFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add__fish, container, false)
    }
    lateinit var fish_name: EditText
    lateinit var fish_cost: EditText
    lateinit var fish_purchase_date: EditText
    lateinit var fish_purchased: EditText
    lateinit var fish_amount: EditText
    lateinit var submit: Button


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //getting user input

        fish_name = view.findViewById<EditText>(R.id.input_fish_name)
        fish_cost = view.findViewById<EditText>(R.id.input_fish_cost)
        fish_purchase_date = view.findViewById<EditText>(R.id.input_purchase_date)
        fish_purchased = view.findViewById<EditText>(R.id.input_fish_location)
        fish_amount = view.findViewById<EditText>(R.id.input_fish_amount)
        submit = view.findViewById<Button>(R.id.submit_fish_view)



        submit.setOnClickListener {
            savetofire()
            findNavController().navigate(R.id.action_fourthFragment_to_FirstFragment)
        }
    }

    private fun savetofire() {
        val ref = FirebaseDatabase.getInstance().getReference("fish")
        val prodid = ref.push().key
        val productvar = fish(prodid.toString(),  fish_name.text.toString(), fish_cost.text.toString(),fish_purchase_date.text.toString(),fish_purchased.text.toString(), fish_amount.text.toString())
        ref.child(prodid.toString()).setValue(productvar).addOnCompleteListener {
            Toast.makeText(context, "Fish was added successfully", Toast.LENGTH_LONG).show()
        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ThirdFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                ThirdFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}