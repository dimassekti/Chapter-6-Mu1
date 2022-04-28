package com.coufie.chapterenammu1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import com.coufie.chapterenammu1.kedua.asynctask.MainAsyncTask
import com.coufie.chapterenammu1.kedua.coroutines.MainCoroutines
import com.coufie.chapterenammu1.kedua.listfilm.FilmActivity
import com.coufie.chapterenammu1.pertama.HitungUmur
import com.coufie.chapterenammu1.pertamabmi.BMICalculator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        contohThreadSatu()
//        contohHandler()

//        contohHandlerThread()
//        contohHT()

        btn_htgumur.setOnClickListener {
            startActivity(Intent(this, HitungUmur::class.java))
        }

        btn_htgbmi.setOnClickListener {
            startActivity(Intent(this, BMICalculator::class.java))

        }

        btn_duaasync.setOnClickListener {
            startActivity(Intent(this, MainAsyncTask::class.java))

        }

        btn_duacoroutines.setOnClickListener {
            startActivity(Intent(this, MainCoroutines::class.java))

        }

        btn_listfilm.setOnClickListener {
            startActivity(Intent(this, FilmActivity::class.java))

        }

    }

    fun contohThreadSatu(){
        Thread(Runnable {
            tvSatu.post(Runnable {
                //tv 1
                tvSatu.text = "Hello World"

                //tv 2
                tvDua.postDelayed(Runnable {
                    tvDua.text = "Welcome, ze"
                }, 2000)

                btnChange.setOnClickListener{
                    tvSatu.post(Runnable {
                        tvSatu.text = "Hello Binar Academy"
                    })
                }

            })
        }).start()
    }

    fun contohHandler(){
        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            startActivity(Intent(this, HitungUmur::class.java))
        }, 2000)

        Handler(Looper.getMainLooper()).post(Runnable {
            tvDua.setText("Hello")
        })
    }

    fun contohHandlerThread(){
        val han = object  : Handler(Looper.getMainLooper()){
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                val pesan2 = msg.obj as String
                tvDua.text = pesan2
            }
        }

        Thread(Runnable {
            val a = "contoh handler thread"
            val pesan = Message.obtain()
            pesan.obj = a
            pesan.target = han
            pesan.sendToTarget()
        }).start()
    }

    fun contohHT(){

        val targetHandler = object  : Handler(Looper.getMainLooper()){
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                val a = msg.obj as String
                tvSatu.text = a
            }
        }

        Thread(Runnable {
            val pesan = "qwerty"
            val a = Message.obtain()
            a.obj = pesan
            a.target = targetHandler
            a.sendToTarget()

        }).start()
    }

}
