package com.example.qrcodescanner.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ModelDao {
    @Insert
    suspend fun insert(model:Model)
    @Query("delete from Model_table ")
    suspend fun clear()
    @Query("SELECT * from Model_table ORDER BY modelId")
    fun getAllModels(): LiveData<List<Model>>


}