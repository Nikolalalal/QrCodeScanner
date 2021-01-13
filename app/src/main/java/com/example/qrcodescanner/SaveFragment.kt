package com.example.qrcodescanner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.qrcodescanner.data.Model
import com.example.qrcodescanner.data.ModelViewModel


class SaveFragment : Fragment() {
    private lateinit var modelViewModel: ModelViewModel
    lateinit var model:Model
    override fun onCreateView(
        inflater: LayoutInflater, fragment: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

    val view=inflater.inflate(R.layout.fragment_save, fragment, false)
        val recyclerView:RecyclerView = view.findViewById(R.id.recyclerView)

        val adapter = Adapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        modelViewModel = ViewModelProvider(this).get(ModelViewModel::class.java)
        modelViewModel.allModels.observe(viewLifecycleOwner, Observer { note ->
            adapter?.setdata(note)
        })
val deleteb:TextView=view.findViewById(R.id.delete_textView2)
        deleteb.setOnClickListener {
modelViewModel.clear()
        }

        return view
    }

}