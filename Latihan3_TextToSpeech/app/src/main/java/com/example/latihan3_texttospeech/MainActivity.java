package com.example.latihan3_texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener{


    TextToSpeech tts;
    EditText input;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.txtInput);
        tts = new TextToSpeech(this,this);
        tts.setSpeechRate((float)0.8);
        tts.setPitch((float) 5.8);
        tts.setLanguage((Locale.ENGLISH));
    }


    public void speak(View v){
        String a = input.getText().toString();
        tts.speak(a,TextToSpeech.QUEUE_FLUSH,null);
    }

    public void hear(View v){
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,"en US");
        try {
            input.setText("");
            startActivityForResult(intent,1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void simpan(View v){
        try {
            OutputStreamWriter o = new OutputStreamWriter(openFileOutput("output.txt",0));
            o.write(input.getText().toString());
            o.close();
            Toast.makeText(this,"Data berhasil disimpan",Toast.LENGTH_LONG).show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void load(View v){
        String t;
        StringBuilder sb = new StringBuilder();

        try {
            InputStreamReader is = new InputStreamReader(openFileInput("output.txt"));
            BufferedReader br = new BufferedReader(is);
            while((t=br.readLine())!=null)
            {
                sb.append(t + "\n");
            }
            is.close();
            input.setText(sb.toString());
            Toast.makeText(this,"Data berhasil diload",Toast.LENGTH_LONG).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void onActivityResult(int RequestCode, int ResultCode, Intent intent) {
        super.onActivityResult(RequestCode, ResultCode, intent);
        switch (RequestCode){
            case 1: {
                if (ResultCode == RESULT_OK && intent != null){
                    ArrayList<String> aa = intent.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    input.setText(aa.get(0));
                }
                break;
            }
        }
    }

    @Override
    public void onInit(int i) {

    }
}