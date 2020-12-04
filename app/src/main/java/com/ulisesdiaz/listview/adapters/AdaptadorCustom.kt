package com.ulisesdiaz.listview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.ulisesdiaz.listview.R
import com.ulisesdiaz.listview.models.Fruta

class AdaptadorCustom(var context:Context, items:ArrayList<Fruta>):BaseAdapter(){

    var items:ArrayList<Fruta>? = null

    init {
        this.items = items
    }
    override fun getCount(): Int {
        return items?.count()!!
    }

    override fun getItem(position: Int): Any {
        return items?.get(position)!!
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var holder:ViewHolder? = null
        var view:View? = convertView

        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.template, null)
            holder = ViewHolder(view)
            view.tag = holder
        }else{
            holder = view.tag as? ViewHolder
        }

        val item = getItem(position) as Fruta
        holder?.nombre?.text = item.nombre
        holder?.imagenFruta?.setImageResource(item.imagen)

        if (position % 2 == 0){
            holder?.linearCelda?.setBackgroundColor(item.colorCelda)
        }

        return  view!!
    }

    private class ViewHolder(view:View){
        var nombre:TextView? = null
        var imagenFruta:ImageView? = null
        var linearCelda: LinearLayout? = null

        init {
            nombre =  view.findViewById(R.id.txtNombre)
            imagenFruta = view.findViewById(R.id.imgFruta)
            linearCelda = view.findViewById(R.id.linearCelda)
        }
    }

}