package com.example.myfishypal
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class viewaquariumadapter (val mCtr : Context, val layoutResId: Int, val aquariumlist: List<aquarium>):ArrayAdapter<aquarium>(mCtr,layoutResId,aquariumlist){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflator: LayoutInflater = LayoutInflater.from(mCtr);
        val view: View = layoutInflator.inflate(layoutResId, null);
        val textViewName = view.findViewById<TextView>(R.id.productnamelist);
        val aquarium = aquariumlist[position]
        textViewName.text = aquarium.tankname + "," + aquarium.tanksize+","+aquarium.tanklights+","+aquarium.tankfilter+","+aquarium.tanksubstrate;
        return view;
    }
}