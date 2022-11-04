package com.example.latihan5_database;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText txtKode;
    EditText txtHasil;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtKode = findViewById(R.id.txtKode);
        txtHasil = findViewById(R.id.txtHasil);
    }

    //ini untuk buttonnya
    public void getData(View v)
    {
        new ambilData(this).execute();
        Toast.makeText(this, "Data di Load!", Toast.LENGTH_SHORT).show();
    }

    //ini adalah class inner untuk mengakses melalui port HTTP.
    private class ambilData extends AsyncTask<String, Void, Void>
    {
        private final Context context;

        private ambilData(Context context) {
            this.context = context;
        }
        protected  void onPreExecute()
        {
            progressDialog = new ProgressDialog(this.context);
            progressDialog.setMessage("Loading Data!");
            progressDialog.show();
        }

        @SuppressWarnings("unchecked")
        @Override
        protected Void doInBackground(String... strings) {
            try {

                String kode = txtKode.getText().toString();
                URL url = new URL("http://yuliushari.com/mobile2022/index.php?id="+kode);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.setRequestMethod("GET");
                connection.setRequestProperty("USER-AGENT", "Mozilla/6.0");

                StringBuilder data = new StringBuilder();
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line ="";
                StringBuilder response = new StringBuilder();
                while ((line = br.readLine())!= null)
                {
                    response.append(line);
                }
                br.close();
                data.append(response.toString());

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        txtHasil.setText(data.toString());
                        progressDialog.dismiss();
                    }
                });


            }catch (Exception e)
            {
                e.printStackTrace();
            }
            return null;
        }
    }

}