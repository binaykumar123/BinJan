package com.example.binjan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.binjan.fragments.LoginFragment
import com.example.binjan.fragments.SignupFragment
import com.example.binjan.interfaces.LoginActivityListener

class LoginActivity : AppCompatActivity(), LoginActivityListener {
    private val LOGIN_FRAGMENT = "login_frag"
    private val SIGNUP_FRAGMENT = "signup_frag"
    private var fm: FragmentManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showFragment(LOGIN_FRAGMENT)
    }

    override fun onAttachFragment(fragment: Fragment) {
        super.onAttachFragment(fragment)
        if (fragment is LoginFragment) {
            fragment.setOnLoginActivityListener(this)
        }
    }

    private fun showFragment(fragmentName: String) {
        fm = supportFragmentManager
        fm!!.popBackStack()
        var fragmentToShow: Fragment? = null
        when (fragmentName) {
            LOGIN_FRAGMENT -> {
                fragmentToShow = LoginFragment()
            }
            SIGNUP_FRAGMENT -> {
                fragmentToShow = SignupFragment()
            }
        }
        if (fragmentToShow != null) {
            fm!!.beginTransaction().replace(R.id.login_activity_container, fragmentToShow).commit()
        }
    }

    override fun openSignUpFragment() {
        showFragment(SIGNUP_FRAGMENT)
    }
}
