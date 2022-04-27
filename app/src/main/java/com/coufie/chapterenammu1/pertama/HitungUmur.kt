package com.coufie.chapterenammu1.pertama

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coufie.chapterenammu1.R
import kotlinx.android.synthetic.main.activity_hitung_umur.*
import kotlin.concurrent.thread

class HitungUmur : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hitung_umur)

        threadOne()
    }


    fun threadOne(){

        Thread(Runnable {
            btn_hitung_umur.setOnClickListener {
                val nama = et_nama.text.toString()
                val dob = et_dob.text.toString()
                val umur = 2022 - dob.toInt()

                tv_hasil.post(Runnable{
                    tv_hasil.setText("Halo namaku $nama, umurku $umur")
                })
            }
        }).start()
    }

}