package com.example.myfishypal
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class viewproductadapter (val mCtr : Context, val layoutResId: Int, val productlist: List<products>):ArrayAdapter<products>(mCtr,layoutResId,productlist){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflator: LayoutInflater = LayoutInflater.from(mCtr);
        val view: View = layoutInflator.inflate(layoutResId, null);
        val textViewName = view.findViewById<TextView>(R.id.productnamelist);
        val fish = productlist[position]
        textViewName.text = fish.productname + "," + fish.cost+","+fish.expiary+","+fish.location+","+fish.size;
        return view;
    }

}
