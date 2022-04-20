package com.example.myfunfoodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.myfunfoodapp.ui.home.HomeFragment


import com.google.firebase.auth.FirebaseAuth
import android.content.Intent as Intent

class SignIn : AppCompatActivity() {

    private val password = "FirebaseEmailPassword"
    val mAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val tvforgot = findViewById<View>(R.id.tvforgot) as TextView
        val tvSignUp = findViewById<View>(R.id.tvSignUp) as TextView

        tvSignUp.setOnClickListener(View.OnClickListener {

            tvSignUp.setOnClickListener{
                var intent = Intent(this, SignUp::class.java)
                startActivity(intent)
                finish()
            }

        })
        val btnConnect = findViewById<View>(R.id.btnConnect) as Button
        val tbEmail = findViewById<View>(R.id.tbEmail) as com.google.android.material.textfield.TextInputEditText
        val tbPassword = findViewById<View>(R.id.tbPwd) as com.google.android.material.textfield.TextInputEditText
        //tbEmail.setText("mendjinmichelle@gmail.com")
        //tbPassword.setText("michelle")
        tvforgot.setOnClickListener(View.OnClickListener {

            tvforgot.setOnClickListener{
                var intent = Intent(this, ForgotPassword::class.java)
                startActivity(intent)
                finish()
            }

        })

        btnConnect.setOnClickListener {
            if(tbEmail.text.toString().trim().isNotEmpty() && tbPassword.text.toString().trim().isNotEmpty()){
                signInUser(tbEmail.text.toString().trim(), tbPassword.text.toString().trim())
                val intent= Intent(this@SignIn, Menu::class.java)
                    val text = tbEmail.text.toString()
                intent.putExtra("currentUser", text)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Input required", Toast.LENGTH_LONG).show()
            }
        }
        val currentuser = mAuth.currentUser
        if(currentuser !=null){
            var intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }
        }

    private fun signInUser(email:String, password:String){


        val user= mAuth.currentUser
        val tbEmail = findViewById<View>(R.id.tbEmail) as TextView
        tbEmail.text = user?.email

        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){task ->
                if(task.isSuccessful){
                    var intent = Intent(this, Menu::class.java)
                    startActivity(intent)

                } else {

                    Toast.makeText(this, "Error !"+task.exception, Toast.LENGTH_LONG).show()

                }
            }
    }


}
