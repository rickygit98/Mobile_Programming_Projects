package com.example.aplikasipertama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText bil1, bil2;
    TextView txtHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bil1 = findViewById(R.id.txtBil1);
        bil2 = findViewById(R.id.txtBil2);
        txtHasil  = findViewById(R.id.txtHasil);
    }

    public void hitung(View v)
    {
        int a = Integer.parseInt(bil1.getText().toString());
        int b = Integer.parseInt(bil2.getText().toString());
        int hasil = a+b;
        txtHasil.setText("hasilnya adalah"+hasil);

    }
}