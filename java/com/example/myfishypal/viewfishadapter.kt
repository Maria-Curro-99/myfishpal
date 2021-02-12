package com.example.myfishypal
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class viewfishadapter (val mCtr : Context, val layoutResId: Int, val fishlist: List<fish>):ArrayAdapter<fish>(mCtr,layoutResId,fishlist){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflator: LayoutInflater = LayoutInflater.from(mCtr);
        val view: View = layoutInflator.inflate(layoutResId, null);
        val textViewName = view.findViewById<TextView>(R.id.productnamelist);
        val fish = fishlist[position]
        textViewName.text = fish.fishname + "," + fish.fishcost+","+fish.purchasedate+","+fish.location+","+fish.amount;
        return view;
    }

}