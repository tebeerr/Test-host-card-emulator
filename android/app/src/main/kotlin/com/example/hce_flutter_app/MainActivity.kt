package com.example.hce_flutter_app

import android.content.Intent
import io.flutter.embedding.android.FlutterActivity
import io.flutter.plugin.common.MethodChannel
import android.nfc.cardemulation.HostApduService
import android.os.Bundle

class MainActivity : FlutterActivity() {
    private val CHANNEL = "com.example.hce_flutter_app/hce"

    override fun configureFlutterEngine(flutterEngine: io.flutter.embedding.engine.FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler { call, result ->
            when (call.method) {
                "startHceService" -> {
                    val data = call.argument<String>("data") ?: "DefaultData"
                    val intent = Intent(this, MyHostApduService::class.java)
                    intent.putExtra("cardData", data)
                    startService(intent)
                    result.success("HCE Service started with data: $data")
                }
                else -> result.notImplemented()
            }
        }
    }
}