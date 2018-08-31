package com.example.victordias.sempanela.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.example.victordias.sempanela.Helpers.ExpLVAdapter;
import com.example.victordias.sempanela.Model.Time;
import com.example.victordias.sempanela.R;

import java.util.ArrayList;

public class ResultadoActivity extends AppCompatActivity {

    private ArrayList<Time> times;
    private ExpandableListView expLV;
    private ExpLVAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // tira a barra superior azul do android
        setContentView(R.layout.activity_resultado);

        expLV = (ExpandableListView) findViewById(R.id.ExpListView);
        Intent it = getIntent();
        times = (ArrayList<Time>) it.getSerializableExtra("Times");

        adapter = new ExpLVAdapter(this,times);
        expLV.setAdapter(adapter);
    }
}
