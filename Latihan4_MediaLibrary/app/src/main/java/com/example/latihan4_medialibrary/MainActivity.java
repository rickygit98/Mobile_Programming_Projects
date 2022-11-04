package com.example.latihan4_medialibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity {

    MediaPlayer mp;
    ImageButton imageButton;
    AssetFileDescriptor afd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButton = findViewById(R.id.tombolPlay);
        mp = new MediaPlayer();
        try {
            afd = this.getAssets().openFd("aa.mp3");
            mp.setDataSource(afd.getFileDescriptor());
            mp.prepare();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void play(View v){
        if(mp.isPlaying()){
            mp.pause();
            imageButton.setImageResource(R.drawable.playbutton);
            Toast.makeText(this,"Music Paused!",Toast.LENGTH_SHORT).show();
        }else{
            mp.start();
            imageButton.setImageResource(R.drawable.pausebuttonred);
            Toast.makeText(this, "Music Play", Toast.LENGTH_SHORT).show();
        }
    }
}