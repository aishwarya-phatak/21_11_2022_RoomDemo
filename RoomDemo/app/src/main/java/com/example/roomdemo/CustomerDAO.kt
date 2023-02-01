package com.example.roomdemo

import androidx.room.*

@Dao
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
