package com.example.qrcodescanner.data

import androidx.lifecycle.LiveData


class ModelRepository(private val modelDao: ModelDao){
    val allModels: LiveData<List<Model>> = modelDao.getAllModels()
    //    val AllID: LiveData<List<Note>> = noteDatabaseDao.getID()
    suspend fun insert(model: Model){
        modelDao.insert(model)
    }

    suspend fun clear(){
        modelDao.clear()
    }
//    suspend fun update(note: Note){
//        noteDatabaseDao.update(note)
//    }

}