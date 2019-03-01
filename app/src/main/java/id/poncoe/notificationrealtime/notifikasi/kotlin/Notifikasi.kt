package id.poncoe.notificationrealtime.notifikasi.kotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.TextView

import id.poncoe.notificationrealtime.MainActivity
import id.poncoe.notificationrealtime.R

/**
 * Created by Poncoe on 26/12/16.
 */

class Notifikasi : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notifikasi)

        if (supportActionBar != null)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val openURL = intent.getStringExtra("openURL")

        val textView = findViewById<View>(R.id.debug_view) as TextView
        textView.text = "URL from additionalData: " + openURL!!


        val onBackButton = findViewById<View>(R.id.back_button) as Button
        onBackButton.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

        val webView = findViewById<View>(R.id.webview) as WebView
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()
        if (openURL == null) {
            webView.loadUrl("https://github.com/poncoe")
        } else {
            webView.loadUrl(openURL)
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home)
            startActivity(Intent(this@Notifikasi, MainActivity::class.java))
        finish()

        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {}
}