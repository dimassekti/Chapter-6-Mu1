package com.coufie.chapterenammu1.ketiga.cthservice.services


import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings
import com.coufie.chapterenammu1.R


class ServicePlayer:Service() {

    private lateinit var player : MediaPlayer

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        player = MediaPlayer.create(this, R.raw.a99518)
        player.isLooping = true
        player.start()
        return super.onStartCommand(intent, flags, startId)
    }
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        player.stop()
    }
}