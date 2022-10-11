package com.example.latihan2_taxyonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Browser;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void profileButton(View v){
        Intent intent1 = new Intent(this,Profile.class);
        startActivity(intent1);
    }

    public void webButton(View v){
        Intent intent2 = new Intent(this,activityBrowser.class);
        startActivity(intent2);
    }

    public void callButton(View v){
        Intent intent3 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"08988887288"));
        startActivity(intent3);
    }

}