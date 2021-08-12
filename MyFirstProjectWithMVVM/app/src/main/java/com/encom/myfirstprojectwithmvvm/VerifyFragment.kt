package com.encom.myfirstprojectwithmvvm

import android.os.Bundle
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import br.com.sapereaude.maskedEditText.MaskedEditText

class VerifyFragment : Fragment(),View.OnClickListener{

    lateinit var formattedPhoneNumber:String
    lateinit var maskedEditText: MaskedEditText
    lateinit var button:Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_verify, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button = view.findViewById(R.id.button)
        button.setOnClickListener(this)
        maskedEditText = view.findViewById(R.id.maskedEditText)
            maskedEditText.addTextChangedListener {
                if (it.toString().length==5)button.isEnabled=true
                else button.isEnabled=false
            }
        view.findViewById<TextView>(R.id.textView).text="Банк отправил код на номер:" + formattedPhoneNumber + ". Введите код подтверждения."
    }
    override fun onResume() {
        super.onResume()
        val sharedViewModel: MainActivityViewModel = ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)
        sharedViewModel.setTitle("Verify Window")
    }
    override fun onClick(v: View?) {
        val number = maskedEditText.text.toString()
        if (number.length==5){
            
        }
    }

    companion object{

        fun newInstance(formattedPhoneNumber:String):VerifyFragment{
            val fragment:VerifyFragment = VerifyFragment()
                fragment.formattedPhoneNumber=formattedPhoneNumber
            return fragment
        }
    }

}