package com.example.broadcastrecieverexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.widget.Toast

class MyBroadcastReciever:BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context,"Broadcast Receiver triggered",Toast.LENGTH_SHORT).show()


        if(isAirplaneModeON(context?.applicationContext)){
            Toast.makeText(context,"Airplane mode is ON",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context,"Airplane mode is OFF",Toast.LENGTH_SHORT).show()
        }
    }

    private fun isAirplaneModeON(context: Context?): Boolean {
        return Settings.System.getInt(context?.contentResolver,Settings.Global.AIRPLANE_MODE_ON,0) != 0
    }
}