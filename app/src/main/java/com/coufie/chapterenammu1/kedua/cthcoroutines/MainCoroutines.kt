package com.coufie.chapterenammu1.kedua.cthcoroutines

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.coufie.chapterenammu1.R
import kotlinx.android.synthetic.main.activity_main_coroutines.*
import kotlinx.coroutines.*

class MainCoroutines : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_coroutines)

//        contohCoroutines()
//        contohCoroutines2()
        contohCoroutinesTiga()


        CoroutineScope(Dispatchers.Main).launch {
//            contohCoroutines2()
        }
    }

    fun contohCoroutinesTiga(){
        GlobalScope.launch {
            CoroutineScope(Dispatchers.Main).launch{

                btnhitungg.setOnClickListener {
                    val tinggiBadan = tinggii.text.toString()
                    val beratBadan = beratt.text.toString()
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

                    tv_satuu.text = bmi
                }


            }
            CoroutineScope(Dispatchers.IO).launch{
                Log.d(TAG, "dispatcher IO")
            }

            CoroutineScope(Dispatchers.Default).launch{
                Log.d(TAG, "dispatcher default")
            }
        }
    }

    suspend fun doText():String{
        return "Hello dododo"
    }


    //cara 1
    fun contohCoroutines(){
        GlobalScope.launch {
            delay(2000)
            tv_satuu.text = "Hello Binar"
        }
    }

    //cara 2
    fun contohCoroutines2(){
        GlobalScope.launch {
            hasil()
        }
    }
    suspend fun hasil():String{
        delay(2000)
        val a = tv_satuu.setText("Hello Binar 2")
        return a.toString()
    }




}