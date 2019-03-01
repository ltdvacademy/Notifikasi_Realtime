package id.poncoe.notificationrealtime.notifikasi.kotlin

import android.app.IntentService
import android.content.Intent
import android.util.Log

import com.google.firebase.iid.FirebaseInstanceId

import java.io.IOException


class DeleteTokenService : IntentService(TAG) {

    override fun onHandleIntent(intent: Intent?) {
        try {
            // Resets Instance ID and revokes all tokens.
            FirebaseInstanceId.getInstance().deleteInstanceId()

            // Now manually call onTokenRefresh()
            Log.d(TAG, "Getting new token")
            FirebaseInstanceId.getInstance().token

            println("TOKEN DELETED. NEW TOKEN FROM SERVICE: " + FirebaseInstanceId.getInstance().token!!)

        } catch (e: IOException) {
            println("INTENT SERVICE IOException")

            e.printStackTrace()
        }

    }

    companion object {
        val TAG = id.poncoe.notificationrealtime.notifikasi.java.DeleteTokenService::class.java.simpleName
    }


}