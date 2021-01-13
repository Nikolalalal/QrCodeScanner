package com.example.qrcodescanner.data

import android.app.Application
import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.qrcodescanner.data.ModelDatabase.Companion.getInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.lang.ref.WeakReference

class ModelViewModel (application: Application): AndroidViewModel(application) {
    val allModels: LiveData<List<Model>>
    //  val allId:LiveData<List<Note>>
    private val repository: ModelRepository
    val tempImageUri: MutableLiveData<String> by lazy {
        MutableLiveData<String>()

    }

    init {
        val modelDao = getInstance(application).modelDao
        repository = ModelRepository(modelDao)
        allModels = repository.allModels
        // allId=repository.AllID
        tempImageUri.value = ""
    }

    fun insert(model: Model) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(model)

            Log.i("???","Saved${model.url}")
        }
    }
    fun clear() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.clear()
        }
    }



}
