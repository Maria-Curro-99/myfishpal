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
class ThirdFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_add_product, container, false)
    }
    lateinit var product_name: EditText
    lateinit var product_cost: EditText
    lateinit var product_expiary: EditText
    lateinit var product_purchased: EditText
    lateinit var product_amount: EditText
    lateinit var submit: Button


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //getting user input

        product_name = view.findViewById<EditText>(R.id.input_fish_name)
        product_cost = view.findViewById<EditText>(R.id.input_fish_cost)
        product_expiary = view.findViewById<EditText>(R.id.input_purchase_date)
        product_purchased = view.findViewById<EditText>(R.id.input_fish_location)
        product_amount = view.findViewById<EditText>(R.id.input_fish_amount)
        submit = view.findViewById<Button>(R.id.submit_fish_view)



        submit.setOnClickListener {
            savetofire()
            findNavController().navigate(R.id.action_thirdFragment_to_FirstFragment)
        }
    }

    private fun savetofire() {
        val ref = FirebaseDatabase.getInstance().getReference("products")
        val prodid = ref.push().key
        val productvar = products(prodid.toString(),  product_name.text.toString(), product_cost.text.toString(),product_expiary.text.toString(),product_purchased.text.toString(), product_amount.text.toString())
        ref.child(prodid.toString()).setValue(productvar).addOnCompleteListener {
            Toast.makeText(context, "Product was added successfully", Toast.LENGTH_LONG).show()
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