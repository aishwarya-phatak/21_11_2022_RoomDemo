package com.example.roomdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var db : AppDatabase
    lateinit var customerDAO: CustomerDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = Room.databaseBuilder(this,
        AppDatabase::class.java,
        "android1_db").build()

        CoroutineScope(Dispatchers.IO).launch {
            customerDAO = db.getCustomerDao()

            customerDAO.addCustomer(Customer(10,"Krishna","9090909090"))
            customerDAO.addCustomer(Customer(11,"Aniket","1010101011"))
            customerDAO.addCustomer(Customer(12,"Vaibhav","8989898989"))

            var customers = customerDAO.getAllCustomers()
            Log.e("tag","---Get All Customers ---")
            for(eachCustomer in customers){
                Log.e("tag","${eachCustomer.toString()}")
            }
            Log.e("tag","---Update---")
            customerDAO.updateCustomer(Customer(10,"Raviraj","909797632"))
            customers = customerDAO.getAllCustomers()
            Log.e("tag","---Get All Customers ---")
            for(eachCustomer in customers){
                Log.e("tag","${eachCustomer.toString()}")
            }
            Log.e("tag","---delete---")
            customerDAO.deleteCustomer(Customer(11,"Aniket","1010101011"))
            customers = customerDAO.getAllCustomers()
            Log.e("tag","---Get All Customers ---")
            for(eachCustomer in customers){
                Log.e("tag","${eachCustomer.toString()}")
            }
            db.close()
        }
    }
}