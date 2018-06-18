package com.example.victordias.sempanela.Controller;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.victordias.sempanela.Helpers.ListAdapter;
import com.example.victordias.sempanela.Model.Jogador;
import com.example.victordias.sempanela.Model.Sorteio;
import com.example.victordias.sempanela.Model.Time;
import com.example.victordias.sempanela.R;

import java.util.ArrayList;
import java.util.List;

public class SorteioActivity extends AppCompatActivity {

    ArrayList<Jogador> jogadores;
    ListView lv;
    Button btincluir,btnSomar,btnDiminuir;
    FloatingActionButton btSortear;
    EditText etJogadores;
    RadioGroup tipoSorteio;
    TextView tvNumero;
    String resposta;
    int quantidadeTimes = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorteio);


        jogadores = new ArrayList<Jogador>();
        lv = (ListView) findViewById(R.id.lvJogadores);
        btincluir = (Button) findViewById(R.id.btInserirJogador);
        btSortear = (FloatingActionButton) findViewById(R.id.btSortear);
        etJogadores = (EditText) findViewById(R.id.etJogador);
        tipoSorteio = (RadioGroup) findViewById(R.id.sorteio);
        btnSomar = (Button) findViewById (R.id.btnSomar);
        btnDiminuir = (Button) findViewById(R.id.btnDiminuir);
        tvNumero = (TextView) findViewById(R.id.tvNumero);

        btnSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantidadeTimes++;
                tvNumero.setText(""+quantidadeTimes);

            }
        });

        btnDiminuir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quantidadeTimes > 1) {
                    quantidadeTimes--;
                    tvNumero.setText("" + quantidadeTimes);
                }else{
                    Context contexto = getApplicationContext();
                    int duracao = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(contexto, "Não pode quantidade negativa ou 0!",duracao);
                    toast.show();
                    return;
                }

            }
        });



        tipoSorteio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton button = (RadioButton) tipoSorteio.findViewById(checkedId);
                resposta = button.getText().toString();
            }
        });

        btSortear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(resposta == null){
                    Context contexto = getApplicationContext();
                    int duracao = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(contexto, "Escolha uma das opções e digite um número",duracao);
                    toast.show();
                    return;
                }else{
                    Sorteio sorteio = new Sorteio();
                    if(resposta.equals("Quantidade de Times")){

                        ArrayList<Time> timesSorteados = sorteio.realizarSorteioQtTimes(jogadores,quantidadeTimes);
                        if(timesSorteados == null){
                            Context contexto = getApplicationContext();
                            int duracao = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(contexto, "Quantidade de Jogadores não pode ser menor que a quantidade de times",duracao);
                            toast.show();
                            return;
                        }else{
                            telaResultado(timesSorteados);

                        }

                    }else{
                        ArrayList<Time> timesSorteados = sorteio.realizarSorteioQtJogadoresPorTime(jogadores,quantidadeTimes);
                        if(timesSorteados == null){
                            Context contexto = getApplicationContext();
                            int duracao = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(contexto, "Quantidade de Jogadores não pode ser menor que a quantidade de Jogadores por Time",duracao);
                            toast.show();
                            return;
                        }else{
                            telaResultado(timesSorteados);
                        }
                    }



                }
            }
        });
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

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long arg3) {
                ListAdapter adapter = new ListAdapter(
                        getApplicationContext(), R.layout.custom_list_layout, jogadores
                );



                String texto = "Jogador " + adapter.getItem(pos).getNome() + " excluído";

                jogadores.remove(adapter.getItem(pos));
                ListAdapter adapter2 = new ListAdapter(
                        getApplicationContext(),R.layout.custom_list_layout,jogadores
                );
                lv.setAdapter(adapter2);
                Context contexto = getApplicationContext();

                int duracao = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(contexto, texto,duracao);
                toast.show();

                return false;
            }
        });
    }

    public void telaResultado(ArrayList<Time> times){
        Intent i = new Intent(SorteioActivity.this,ResultadoActivity.class);
        i.putExtra("Times", times);
        startActivity(i);
    }

}
