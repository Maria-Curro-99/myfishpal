package com.example.myfishypal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ViewFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.view_aquarium).setOnClickListener {
            findNavController().navigate(R.id.action_viewFragment_to_viewtankFragment)
        }

        view.findViewById<Button>(R.id.view_product).setOnClickListener {
           findNavController().navigate(R.id.action_viewFragment_to_viewproductFragment)
        }

        view.findViewById<Button>(R.id.add_item).setOnClickListener {
            findNavController().navigate(R.id.action_viewFragment_to_viewfishFragment)
        }

    }
}