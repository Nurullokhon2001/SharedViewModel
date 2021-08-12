package com.encom.myfirstprojectwithmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by ABDUAHAD FAIZULLOEV on 05,Август,2021
 * abduahad.fayzulloev@gmail.com
 * http://abduahad.com/
 *
 */
class MainActivityViewModel:ViewModel() {
    private val title:MutableLiveData<String> = MutableLiveData()

    fun setTitle(title : String){
        this.title.value=title
    }
    fun getTitle():LiveData<String> = title


}