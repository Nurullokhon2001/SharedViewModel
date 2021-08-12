package com.encom.myfirstprojectwithmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

  //  lateinit var viewModel: MainActivityViewModel
   lateinit var  sharedViewModel : MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        sharedViewModel.getTitle().observe(this , Observer{
            supportActionBar?.title= it
        })
        val fr = supportFragmentManager.beginTransaction()
        fr.replace(R.id.container, PhoneFragment())
        fr.commit()

    }
}