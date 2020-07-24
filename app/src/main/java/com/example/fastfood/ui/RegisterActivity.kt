package com.example.fastfood.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fastfood.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity : AppCompatActivity() {

    private val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        supportActionBar?.hide()

        btnCreateAccount.setOnClickListener {
            if (etRegisterLogin.text.isNotEmpty() && etRegisterPassword.text.isNotEmpty()){
                loading.visibility = View.VISIBLE
                mAuth.createUserWithEmailAndPassword(etRegisterLogin.text.toString(), etRegisterPassword.text.toString())
                    .addOnCompleteListener {
                        if (it.isSuccessful){
                            val user = mAuth.currentUser
                            loading.visibility = View.GONE
                            updateUI(user)
                        }else{
                            Toast.makeText(this, it.exception?.localizedMessage, Toast.LENGTH_LONG).show()
                            Log.d("wasnotdone", it.exception?.localizedMessage)
                            loading.visibility = View.GONE
                        }
                    }
            }else{
                Toast.makeText(this, "Вводите данные!", Toast.LENGTH_SHORT).show()
            }
        }
        ivCloseRegister.setOnClickListener {
            finish()
        }

    }
    private fun updateUI(user: FirebaseUser?){
        if (user!=null){
           val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
            finish()
        }

    }



}

//class User(val uid : String, val username:String)