package com.coufie.chapterenammu1.kedua.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coufie.chapterenammu1.R
import kotlinx.android.synthetic.main.activity_main_coroutines.*
import kotlinx.coroutines.*

class MainCoroutines : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_coroutines)

        contohCoroutines()
//        contohCoroutines2()


        CoroutineScope(Dispatchers.Main).launch {
//            contohCoroutines2()
        }
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