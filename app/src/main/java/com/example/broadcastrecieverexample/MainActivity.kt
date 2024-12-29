package com.example.broadcastrecieverexample

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.broadcastrecieverexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val airplaneModeChangeReceiver:MyBroadcastReciever = MyBroadcastReciever()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.clickMe.setOnClickListener {
            val intent = Intent()
            intent.addCategory(Intent.CATEGORY_DEFAULT)
            intent.setAction("my.custom.action.tag.fordemo")
            sendBroadcast(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        /*val filter =  IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(airplaneModeChangeReceiver,filter)*/
    }

    override fun onStop() {
        super.onStop()
       /* unregisterReceiver(airplaneModeChangeReceiver)*/
    }
}