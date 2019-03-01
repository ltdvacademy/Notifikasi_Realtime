package id.poncoe.notificationrealtime.notifikasi.java;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import id.poncoe.notificationrealtime.*;
import id.poncoe.notificationrealtime.MainActivity;

/**
 * Created by Poncoe on 26/12/16.
 */

public class Notifikasi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifikasi);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String openURL = getIntent().getStringExtra("openURL");

        final TextView textView = (TextView)findViewById(R.id.debug_view);
        textView.setText("URL from additionalData: " + openURL);


        Button onBackButton = (Button)(findViewById(R.id.back_button));
        onBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        WebView webView = (WebView)(findViewById(R.id.webview));
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        if (openURL == null) {
            webView.loadUrl("https://github.com/poncoe");
        } else {
            webView.loadUrl(openURL);
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home)
            startActivity(new Intent(Notifikasi.this, MainActivity.class));
            finish();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
    }
}