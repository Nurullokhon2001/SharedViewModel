package com.encom.myfirstprojectwithmvvm

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import br.com.sapereaude.maskedEditText.MaskedEditText

class PhoneFragment : Fragment(),View.OnClickListener {

    lateinit var maskedEditText: MaskedEditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_phone, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener(this)
        maskedEditText = view.findViewById(R.id.maskedEditText)
    }

    override fun onResume() {
        super.onResume()
        val sharedViewModel: MainActivityViewModel = ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)
        sharedViewModel.setTitle("Telefone Number")
    }
    override fun onClick(v: View?) {
        val rawText = maskedEditText.rawText
        val text = maskedEditText.text.toString()
        if (rawText.length==9){
            val verifyFragment = VerifyFragment.newInstance(text)
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container,verifyFragment).addToBackStack(VerifyFragment::class.java.simpleName).commit()
        }else
            Toast.makeText(requireContext(),"Неверный формат!",Toast.LENGTH_SHORT).show()
    }
}