package com.example.roomdemo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customers")
data class Customer (
    @PrimaryKey @ColumnInfo(name = "_id") var customerId : Int,
    var name : String,
    var phone : String
    )