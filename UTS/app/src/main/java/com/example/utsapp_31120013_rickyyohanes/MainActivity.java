package com.example.utsapp_31120013_rickyyohanes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton animalSoundBtn;
    ImageButton storyTellerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        animalSoundBtn = findViewById(R.id.animalSoundBtn);
        animalSoundBtn.setOnClickListener(this);
        
        storyTellerBtn = findViewById(R.id.storyTellerBtn);
        storyTellerBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.animalSoundBtn:
                startActivity(new Intent(this,AnimalSound.class));
                break;
            case R.id.storyTellerBtn:
                startActivity(new Intent(this,StoryTeller.class));
                break;
        }
    }
}