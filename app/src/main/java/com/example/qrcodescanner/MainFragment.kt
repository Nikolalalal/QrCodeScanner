package com.example.qrcodescanner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController


class MainFragment : Fragment() {
lateinit var mainFragment: MainFragment
    lateinit var scaningFragment: ScaningFragment
    lateinit var saveFragment: SaveFragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      val view=  inflater.inflate(R.layout.fragment_main, container, false)
        val scanText:TextView=view.findViewById(R.id.scan_textView2)
        val saveText:TextView=view.findViewById(R.id.save_textView3)
scanText.setOnClickListener {
    findNavController().navigate(R.id.action_mainFragment_to_scaningFragment)
}
        saveText.setOnClickListener {
            (activity as MainActivity).findNavController(R.id.nav_host_frag)
                .navigate(R.id.action_mainFragment_to_saveFragment)
        }

           return view
    }

    }


