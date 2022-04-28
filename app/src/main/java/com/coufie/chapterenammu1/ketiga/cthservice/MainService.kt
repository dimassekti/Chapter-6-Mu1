package com.coufie.chapterenammu1.ketiga.cthservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coufie.chapterenammu1.R
import com.coufie.chapterenammu1.ketiga.cthservice.services.ServicePlayer
import kotlinx.android.synthetic.main.activity_main_service.*

class MainService : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_service)


        btnplayy.setOnClickListener {
            startService(Intent(this, ServicePlayer::class.java))
        }

        btnstopp.setOnClickListener {
            stopService(Intent(this, ServicePlayer::class.java))
        }
    }
}