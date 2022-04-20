package com.example.myfunfoodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.myfunfoodapp.databinding.ActivityForgotPasswordBinding
import com.example.myfunfoodapp.databinding.ActivitySignUpBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import javax.security.auth.callback.Callback
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUp : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var data : DatabaseReference
    lateinit var mAuth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        //nouveau
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSignUp.setOnClickListener {
            val fullname = binding.tbFullname.text.toString()
            val email = binding.tbmail.text.toString()
            val password = binding.tbPwd.text.toString()
            val confirm = binding.tbconfirm.text.toString()
            data = FirebaseDatabase.getInstance().getReference("Users")
            val User = User(fullname,email,password,confirm)
            data.child(fullname).setValue(User).addOnSuccessListener {
                binding.tbFullname.text?.clear()
                binding.tbmail.text?.clear()
                binding.tbPwd.text?.clear()
                binding.tbconfirm.text?.clear()

                Toast.makeText(this, "Succesfully", Toast.LENGTH_LONG).show()


            }.addOnFailureListener{
                Toast.makeText(this, "Failled", Toast.LENGTH_LONG).show()
            }
            }
       mAuth = FirebaseAuth.getInstance()
        val tvsignin = findViewById<View>(R.id.tvsignin) as TextView
        tvsignin.setOnClickListener {
            var intent = Intent(this, SignIn::class.java)
            startActivity(intent)
            finish()
            //merci
        }
        val btnSignUp = findViewById<View>(R.id.btnSignUp) as Button
        val tbFullname = findViewById<View>(R.id.tbFullname) as TextInputEditText
        val tbmail = findViewById<View>(R.id.tbmail) as TextInputEditText
        val tbPwd = findViewById<View>(R.id.tbPwd) as TextInputEditText
        val tbconfirm= findViewById<View>(R.id.tbconfirm) as TextInputEditText
        btnSignUp.setOnClickListener {
            if (tbFullname.text.toString().trim().isNotEmpty() || tbmail.text.toString().trim()
                    .isNotEmpty() ||
                tbPwd.text.toString().trim().isNotEmpty() || tbconfirm.text.toString()
                    .trim().isNotEmpty()
            ) {
                createdUser(
                    tbFullname.text.toString().trim(),
                    tbmail.text.toString().trim(),
                    tbPwd.text.toString().trim(),
                    tbconfirm.text.toString().trim()
                )
                var intent = Intent(this, Menu::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "input required", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun createdUser(Name: String, Email: String, Password: String, ConfirmPassword: String){
        val addOnCompleteListener = mAuth.createUserWithEmailAndPassword(Email, Password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.e("Text message", "Succesfull")
                    var intent = Intent(this, Menu::class.java)
                    startActivity(intent)
                    val currentUser = mAuth.currentUser

                } else {
                    Log.e("Text message", "failed" + task.exception)

                }
            }

        fun onStart() {
            super.onStart()
            val user = mAuth.currentUser

            if(user !=null){
                var intent = Intent(this, Menu::class.java)
                startActivity(intent)
            }
        }

    }
}

