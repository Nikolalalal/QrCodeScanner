package com.example.qrcodescanner.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "Model_table")
data class Model(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "modelId")
    var modelId: Long = 0L,
    @ColumnInfo(name = "name")
    val name:String?=null,
    @ColumnInfo(name = "description")
    val description:String?=null,
    @ColumnInfo(name = "url")
    val url:String?=null
): Parcelable