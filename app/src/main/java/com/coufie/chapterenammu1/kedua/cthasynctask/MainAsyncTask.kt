package com.coufie.chapterenammu1.kedua.cthasynctask

import android.app.ProgressDialog
import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coufie.chapterenammu1.R
import kotlinx.android.synthetic.main.activity_main_async_task.*
import kotlinx.android.synthetic.main.activity_main_async_task.et_beratbadan
import kotlinx.android.synthetic.main.activity_main_async_task.et_tinggibadan

class MainAsyncTask : AppCompatActivity() {

    lateinit var cont : Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_async_task)

        cont = this

        btn_hitungbmi.setOnClickListener {
            contohAsyncTask().execute()
        }

    }

    inner class contohAsyncTask : AsyncTask<Int, Void, String>(){

        lateinit var pdialog : ProgressDialog

        override fun onPreExecute() {
            super.onPreExecute()
            pdialog = ProgressDialog(this@MainAsyncTask)
            pdialog.show()
        }

        override fun doInBackground(vararg p0: Int?): String {

            if(et_beratbadan.text.isNotEmpty() && et_tinggibadan.text.isNotEmpty()){
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
                return bmi
            }
            else{
                return "Mohon Masukan Data Secara Lengkap"
            }
        }

        override fun onProgressUpdate(vararg values: Void?) {
            super.onProgressUpdate(*values)
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            tv_bmistatus.text = result
            pdialog.dismiss()
        }



    }

}