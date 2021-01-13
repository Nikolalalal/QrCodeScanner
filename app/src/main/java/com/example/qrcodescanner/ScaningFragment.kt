package com.example.qrcodescanner

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.CodeScannerView
import com.budiyev.android.codescanner.DecodeCallback
import com.example.qrcodescanner.data.Model
import com.example.qrcodescanner.data.ModelViewModel


class ScaningFragment : Fragment() {
    private lateinit var codeScanner: CodeScanner
    lateinit var modelViewModel: ModelViewModel
    override fun onCreateView(
        inflater: LayoutInflater, fragment: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scaning, fragment, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        PermissionsProvider.checkPermissionCamera(this)
        modelViewModel = ViewModelProvider(this).get(ModelViewModel::class.java)
        val scannerView = view.findViewById<CodeScannerView>(R.id.scanner_view)
        val activity = requireActivity()
       codeScanner = CodeScanner(activity, scannerView)
        codeScanner.decodeCallback = DecodeCallback {
            activity.runOnUiThread {
                Toast.makeText(activity, it.text, Toast.LENGTH_LONG).show()
                val url=it.text
                val model = Model(url = url)
                modelViewModel.insert(model)
//                val bundle:Bundle? = Bundle()
//                bundle!!.putString("url",url)
//                findNavController().navigate(R.id.action_scaningFragment_to_saveFragment,bundle)
               val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            }
        }
        scannerView.setOnClickListener {
            codeScanner.startPreview()
        }
    }

    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }
    companion object {
        //image pick code
        private val IMAGE_PICK_CODE = 1000;
        const val TAKE_PHOTO_WITH_CAMERA = 992

        private val PERMISSION_CODE = 1001;
    }
}