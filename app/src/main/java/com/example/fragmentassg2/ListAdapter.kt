package com.example.fragmentassg2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentassg2.data.User
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter:RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList= emptyList<User>()

    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=userList[position]
        holder.itemView.tvID.text=currentItem.id.toString()
        holder.itemView.tvFirst.text=currentItem.firstName
        holder.itemView.tvLast.text=currentItem.secondName
        holder.itemView.tvNum.text=currentItem.phone.toString()
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(user:List<User>){
        this.userList=user
        notifyDataSetChanged()
    }
}