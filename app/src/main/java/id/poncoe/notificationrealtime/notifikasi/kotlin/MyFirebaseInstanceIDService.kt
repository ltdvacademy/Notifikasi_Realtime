package id.poncoe.notificationrealtime.notifikasi.kotlin

import android.content.Intent
import android.support.v4.content.LocalBroadcastManager

import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService

import id.poncoe.notificationrealtime.notifikasi.java.Configuration


class MyFirebaseInstanceIDService : FirebaseInstanceIdService() {
    override fun onTokenRefresh() {
        super.onTokenRefresh()
        val refreshedToken = FirebaseInstanceId.getInstance().token

        println("New Reg ID/Token: " + refreshedToken!!)

        // Notify UI that registration has completed, so the progress indicator can be hidden.
        val registrationComplete = Intent(Configuration.REGISTRATION_COMPLETE)
        registrationComplete.putExtra("token", refreshedToken)
        LocalBroadcastManager.getInstance(this).sendBroadcast(registrationComplete)
    }

    companion object {

        private val TAG = id.poncoe.notificationrealtime.notifikasi.java.MyFirebaseInstanceIDService::class.java.simpleName
    }

}