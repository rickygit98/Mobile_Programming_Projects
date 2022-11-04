package com.example.utsapp_31120013_rickyyohanes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Story_Detail extends AppCompatActivity implements View.OnClickListener, TextToSpeech.OnInitListener {

    TextToSpeech textToSpeech;
    ImageButton speakStoryBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_detail);

        String story_title = getIntent().getStringExtra("TITLE");
        int story_image = getIntent().getIntExtra("IMG",0);
        String story_description = getIntent().getStringExtra("DESC");
        String story_moral = getIntent().getStringExtra("MORAL");

        TextView story_titletv = findViewById(R.id.storyTitleTv);
        TextView story_descriptiontv = findViewById(R.id.storyDescriptionTv);
        TextView story_moraltv = findViewById(R.id.storyMoralTv);
        ImageView story_imageiv = findViewById(R.id.storyImageIv);

        story_titletv.setText(story_title);
        story_descriptiontv.setText(story_description);
        story_moraltv.setText(story_moral);
        story_imageiv.setImageResource(story_image);

        // textToSpeech Config
        textToSpeech = new TextToSpeech(this,this);
        textToSpeech.setSpeechRate((float)0.6);
        textToSpeech.setPitch((float) 6.0);
        textToSpeech.setLanguage((Locale.ENGLISH));

        //Onclick speaker event
        speakStoryBtn = findViewById(R.id.speakStoryBtn);
        speakStoryBtn.setOnClickListener(this);
    }

    public void speakStory(View v){
        String story_title = getIntent().getStringExtra("TITLE");
        String story_description = getIntent().getStringExtra("DESC");
        String story_moral = getIntent().getStringExtra("MORAL");

        String result = story_title + "... " + story_description + "...  The Moral value of this story : " + story_moral;

        if(textToSpeech.isSpeaking()){
            textToSpeech.stop();
            speakStoryBtn.setImageResource(R.drawable.ic_baseline_play_arrow_24);
        }else{
            textToSpeech.speak(result,TextToSpeech.QUEUE_FLUSH,null);
            speakStoryBtn.setImageResource(R.drawable.ic_baseline_pause_24);
        }

    }

    @Override
    public void onInit(int status) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.speakStoryBtn:
            speakStory(v);
        }
    }
}