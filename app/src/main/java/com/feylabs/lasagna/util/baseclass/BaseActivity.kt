package com.feylabs.lasagna.util.baseclass

import android.R
import android.app.Activity
import android.content.Context
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.tapadoo.alerter.Alerter


open class BaseActivity : AppCompatActivity() {



    fun String.showLongToast() {
        Toast.makeText(this@BaseActivity, this, Toast.LENGTH_LONG).show()
    }

    fun String.showShortToast() {
        Toast.makeText(this@BaseActivity, this, Toast.LENGTH_SHORT).show()
    }

    fun View.setVisible(){
        this.visibility = View.VISIBLE
    }

    fun View.setGone(){
        this.visibility = View.GONE
    }

    fun View.setInvisible(){
        this.visibility = View.INVISIBLE
    }

    fun showSweetAlert(title: String, desc: String, color: Int) {
        Alerter.create(this)
            .setTitle(title)
            .setText(desc)
            .setBackgroundColorRes(color) // or setBackgroundColorInt(Color.CYAN)
            .show()
    }


}

