package com.example.qrcodescanner.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Model::class], version = 3, exportSchema = false)
abstract class ModelDatabase : RoomDatabase() {

    abstract val modelDao: ModelDao

    companion object {

        @Volatile
        private var INSTANCE: ModelDatabase? = null

        fun getInstance(context: Context): ModelDatabase {
            synchronized(this) {
                var instance =
                    INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ModelDatabase::class.java,
                        "Model_table"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
