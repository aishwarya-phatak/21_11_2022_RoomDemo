package com.example.roomdemo

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface CustomerDAO {
    @Query("select * from customers")
    fun getAllCustomers() : List<Customer>

    @Insert
    fun addCustomer(customer: Customer)

    @Update
    fun updateCustomer(customer: Customer)

    @Delete
    fun deleteCustomer(customer: Customer)
}
