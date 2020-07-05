package com.example.binjan.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import com.example.binjan.R
import com.example.binjan.interfaces.LoginActivityListener

class LoginFragment : Fragment(), View.OnClickListener {
    lateinit var textSignUp:TextView
    private var fm: FragmentManager?=null
    private lateinit var loginActivityListener: LoginActivityListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_login, container, false)
        textSignUp=view.findViewById(R.id.txt_sign_up)
        textSignUp.setOnClickListener(this)
        return view
    }
    fun setOnLoginActivityListener(callback: LoginActivityListener){
        loginActivityListener=callback
    }

    override fun onClick(v: View?) {
        if(v!!.id == R.id.txt_sign_up){
            loginActivityListener.openSignUpFragment()
        }
    }
    fun loadSignUpFragment(){

    }

}
