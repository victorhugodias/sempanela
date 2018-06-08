package com.example.victordias.sempanela;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class SorteioActivity extends AppCompatActivity {

    ArrayList<Jogador> jogadores;
    ListView lv;
    Button btincluir;
    EditText etQuantidadeTimes;
    EditText etJogadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorteio);


        jogadores = new ArrayList<Jogador>();
        lv = (ListView) findViewById(R.id.lvJogadores);
        btincluir = (Button) findViewById(R.id.btInserirJogador);
        etQuantidadeTimes = (EditText) findViewById(R.id.etQuantidadeTimes);
        etJogadores = (EditText) findViewById(R.id.etJogador);


        btincluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jogadores.add(new Jogador(etJogadores.getText().toString()));
                etJogadores.setText(null);
                ListAdapter adapter = new ListAdapter(
                        getApplicationContext(),R.layout.custom_list_layout,jogadores
                );
                lv.setAdapter(adapter);
            }
        });
    }
}
