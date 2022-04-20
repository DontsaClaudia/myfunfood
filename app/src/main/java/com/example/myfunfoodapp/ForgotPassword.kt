package com.example.myfunfoodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class ForgotPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        val forgotmail = findViewById<View>(R.id.forgotmail) as TextInputEditText
        val tvreset = findViewById<View>(R.id.tvreset) as Button
        tvreset.setOnClickListener{
            val email:String = forgotmail.text.toString().trim() { it <= ' '
            }
            if(email.isEmpty()){
                Toast.makeText(this,"please enter email", Toast.LENGTH_SHORT).show()
            }else{
                FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                    .addOnCompleteListener() { task ->
                        if(task.isSuccessful){
                            Toast.makeText(this, "Email send succesfuly to reset your password", Toast.LENGTH_SHORT).show()
                            finish()
                        }else{
                            Toast.makeText(this, task.exception!!.message.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
    }
}