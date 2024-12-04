public class MyHostApduService {
    package com.example.hce_flutter_app

import android.nfc.cardemulation.HostApduService
import android.os.Bundle
import android.util.Log

class MyHostApduService : HostApduService() {
    override fun processCommandApdu(commandApdu: ByteArray?, extras: Bundle?): ByteArray? {
        Log.d("HCE", "Received APDU command: ${commandApdu?.joinToString()}")
        
        // Respond with a static NDEF message
        val response = "Hello NFC!".toByteArray(Charsets.UTF_8)
        return response
    }
    return null

    override fun onDeactivated(reason: Int) {
        Log.d("HCE", "Service deactivated, reason: $reason")
    }
}

}
