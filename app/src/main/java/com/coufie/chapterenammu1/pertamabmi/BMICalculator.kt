package com.coufie.chapterenammu1.pertamabmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import com.coufie.chapterenammu1.R
import kotlinx.android.synthetic.main.activity_bmicalculator.*

class BMICalculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmicalculator)

        threadAndHandlerBMI()

    }

    fun threadAndHandlerBMI(){

        val han = object  : Handler(Looper.getMainLooper()){
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                val pesanIn = msg.obj as String

                tv_bmistatus.post(Runnable {
                    tv_bmistatus.text = pesanIn
                })

            }
        }

        Thread(Runnable {

            btn_hitungbmi.setOnClickListener {
                val beratBadan = et_beratbadan.text.toString()
                val tinggiBadan = et_tinggibadan.text.toString()
                val hasil = beratBadan.toDouble() / (tinggiBadan.toDouble()/100 * tinggiBadan.toDouble()/100)
                var bmi = ""

                if(hasil > 29.9){
                    bmi = "Obesitas"
                }else if(hasil > 24.9 ){
                    bmi = "Overweight"
                }else if(hasil > 18.49 ){
                    bmi = "Normal"
                }
                else{
                    bmi = "Kurus"
                }

                val pesanOut = Message.obtain()
                pesanOut.obj = bmi
                pesanOut.target = han
                pesanOut.sendToTarget()
            }

        }).start()
    }


}