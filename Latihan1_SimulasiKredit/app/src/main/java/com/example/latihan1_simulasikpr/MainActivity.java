package com.example.latihan1_simulasikpr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void kalkulasi(View V){
        EditText txtlamaPinjaman = findViewById(R.id.txtLamaPinjaman);
        EditText txtjumlahPinjaman = findViewById(R.id.txtJumlahPinjaman);
        EditText txtbungaPinjaman = findViewById(R.id.txtBungaPinjaman);

        EditText lbltotalAngsPokok = findViewById(R.id.totalAngsPokok);
        EditText lbltotalAngsBunga = findViewById(R.id.totalAngsBunga);
        EditText lbltotalBayar = findViewById(R.id.totalBayar);

        Float lamaPinjaman = Float.parseFloat(txtlamaPinjaman.getText().toString());
        Float jumlahPinjaman = Float.parseFloat(txtjumlahPinjaman.getText().toString());
        Float bungaPinjaman = Float.parseFloat(txtbungaPinjaman.getText().toString());

        Float totalAngsuranPokok = jumlahPinjaman / lamaPinjaman;
        Float totalAngsuranBunga = jumlahPinjaman * bungaPinjaman / 100 / 12;
        Float totalBayar = totalAngsuranPokok+totalAngsuranBunga;

        Log.d("value", String.valueOf(totalAngsuranPokok));
        Log.d("value", String.valueOf(totalAngsuranBunga));
        Log.d("value", String.valueOf(totalBayar));

        lbltotalAngsPokok.setText(totalAngsuranPokok.toString());
        lbltotalAngsBunga.setText(totalAngsuranBunga.toString());
        lbltotalBayar.setText(totalBayar.toString());

    }
}