package com.example.latihan2_taxyonline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class activityBrowser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        WebView wv1 = findViewById(R.id.webview1);

        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.loadUrl("https://www.google.com/");
        wv1.reload();
    }
}