package com.example.dbmvvmhilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.dbmvvmhilt.R
import com.example.dbmvvmhilt.db.UserEntity
import dagger.hilt.android.AndroidEntryPoint
import org.w3c.dom.Text

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var button: Button
    private lateinit var text: TextView
    private lateinit var firstName: TextView
    private lateinit var lastName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        text = findViewById(R.id.textView)
        firstName = findViewById(R.id.firstNameEditText)
        lastName = findViewById(R.id.lastNameEditText)

        button.setOnClickListener{
            val user = UserEntity(firstName = firstName.text.toString(), lastName = lastName.text.toString())
            viewModel.insertUser(user)
            firstName.text = ""
            lastName.text = ""
        }
        initVM()
    }

    private fun initVM() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.loadUsersObserver().observe(this, object: Observer<List<UserEntity>>{
            override fun onChanged(t: List<UserEntity>?) {
                text.text = ""
                t?.forEach{
                    text.append(it.firstName+ " " + it.lastName + "\n")
                }
            }
        })
    }
}