package com.example.victordias.sempanela.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.victordias.sempanela.R;

public class TimesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // tira a barra superior azul do android
        setContentView(R.layout.activity_times);
    }
}
