package com.example.utsapp_31120013_rickyyohanes;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class AnimalSound extends AppCompatActivity implements View.OnClickListener {

    ImageButton lionBtn;
    ImageButton goatBtn;
    ImageButton horseBtn;
    ImageButton roosterBtn;
    ImageButton wolfBtn;
    ImageButton catBtn;

    MediaPlayer player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_sound);

        player = new MediaPlayer();

        lionBtn = findViewById(R.id.lionBtn);
        lionBtn.setOnClickListener(this);

        goatBtn = findViewById(R.id.goatBtn);
        goatBtn.setOnClickListener(this);

        horseBtn = findViewById(R.id.horseBtn);
        horseBtn.setOnClickListener(this);

        roosterBtn = findViewById(R.id.roosterBtn);
        roosterBtn.setOnClickListener(this);

        wolfBtn = findViewById(R.id.wolfBtn);
        wolfBtn.setOnClickListener(this);

        catBtn = findViewById(R.id.catBtn);
        catBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.lionBtn:
                player = MediaPlayer.create(this,R.raw.lion);
                player.start();
                break;
            case R.id.goatBtn:
                player = MediaPlayer.create(this,R.raw.goat);
                player.start();
                break;
            case R.id.horseBtn:
                player = MediaPlayer.create(this,R.raw.horse);
                player.start();
                break;
            case R.id.roosterBtn:
                player = MediaPlayer.create(this,R.raw.rooster);
                player.start();
                break;
            case R.id.wolfBtn:
                player = MediaPlayer.create(this,R.raw.wolf);
                player.start();
                break;
            case R.id.catBtn:
                player = MediaPlayer.create(this,R.raw.cat);
                player.start();
                break;
        }

    }
}