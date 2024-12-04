package com.example.hce_flutter_app

import android.nfc.cardemulation.HostApduService
import android.os.Bundle
import android.util.Log

class MyHostApduService : HostApduService() {

    override fun processCommandApdu(commandApdu: ByteArray?, extras: Bundle?): ByteArray? {
        // Process the APDU command and return the response
        Log.d("HCE", "Received command APDU: ${commandApdu?.contentToString()}")
        val responseApdu = byteArrayOf(0x90.toByte(), 0x00.toByte()) // Success response
        return responseApdu
    }

    override fun onDeactivated(reason: Int) {
        // Handle deactivation (e.g., lost connection)
        Log.d("HCE", "Deactivated: Reason $reason")
    }
}