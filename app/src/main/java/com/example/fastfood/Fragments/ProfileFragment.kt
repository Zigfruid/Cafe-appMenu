package com.example.fastfood.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.fastfood.R
import com.example.fastfood.ui.SignInActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.profile_fragment.*

class ProfileFragment: Fragment(R.layout.profile_fragment){

    private val mAuth = FirebaseAuth.getInstance()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnQuitAccount.setOnClickListener {
            mAuth.signOut()
            val intent = Intent(requireContext(), SignInActivity::class.java)
            startActivity(intent)

        }

    }

//        private fun getCurrentUser(){
//        val uid = FirebaseAuth.getInstance().uid ?: " "
//        val ref = FirebaseDatabase.getInstance().getReference("/users/$uid")
//        val user = User(uid, etRegisterSurname.text.toString())
//        ref.setValue(user)
//    }

}