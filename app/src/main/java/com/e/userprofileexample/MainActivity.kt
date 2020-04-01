package com.e.userprofileexample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.e.userprofileexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val userData = UserData("Barry Allen")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.userData = userData
        binding.statusButton.setOnClickListener {
            updateStatus(it)
        }
    }

    private fun updateStatus(view: View) {
        binding.apply {
            userData?.status = statusEditText.text.toString()
            invalidateAll()
            statusEditText.visibility = View.GONE
            statusButton.visibility = View.GONE
            statusTextView.visibility = View.VISIBLE
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
