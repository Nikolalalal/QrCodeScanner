package com.example.qrcodescanner

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.qrcodescanner.data.Model
import com.example.qrcodescanner.data.ModelViewModel


class WebFragment : Fragment() {
    private lateinit var modelViewModel: ModelViewModel
    private val args by navArgs<WebFragmentArgs>()
    lateinit var imageView: ImageView
    lateinit var imageUri:String
    lateinit var model: Model


    override fun onCreateView(
        inflater: LayoutInflater, fragment: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    val view=inflater.inflate(R.layout.fragment_web, fragment, false)
        modelViewModel = ViewModelProvider(this).get(ModelViewModel::class.java)
        val webView:WebView = view.findViewById(R.id.webViewqr)
        webView.settings.javaScriptEnabled = true;
        webView.webViewClient = WebViewClient()
        var url = arguments?.getString("url")
        Log.i("priem!Path", "${url}")
        Log.i("priem!Uri", "${args.currentmodel.url!!}")
        var saveUrl=arguments?.getString("imageUri")
        Log.i("priem!Uri", "${saveUrl}")
        if(url!=null){
            webView.loadUrl(url!!)

            Log.i("priem!Uri!", "imgUri !=null ${saveUrl}")
        }else if (args.currentmodel.url!=null){
            webView.loadUrl(args.currentmodel.url!!)
        }
   return view
    }


}