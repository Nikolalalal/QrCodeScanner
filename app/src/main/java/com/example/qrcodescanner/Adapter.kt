package com.example.qrcodescanner


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.core.os.bundleOf
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.qrcodescanner.data.Model

class Adapter : RecyclerView.Adapter<Adapter.MyViewHolder>() {
    //    lateinit var note: Note
    private var modelList = emptyList<Model>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(R.layout.castomrow, parent, false)
        )

    }

    override fun getItemCount(): Int {
        return modelList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = modelList[position]

        holder.itemView.findViewById<TextView>(R.id.id_textView2).text =
            currentItem.modelId.toString()
        holder.itemView.findViewById<TextView>(R.id.url_textView3).text = currentItem.url

        holder.itemView.findViewById<ConstraintLayout>(R.id.card).setOnClickListener {

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(currentItem.url))
            startActivity(holder.itemView.context,intent, bundleOf())
        }
    }

    fun setdata(note: List<Model>) {
        this.modelList = note
        notifyDataSetChanged()
    }
}