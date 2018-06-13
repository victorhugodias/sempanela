package com.example.victordias.sempanela.Helpers;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.victordias.sempanela.Model.Jogador;
import com.example.victordias.sempanela.R;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Jogador>{

    ArrayList<Jogador> jogadores;
    Context context;
    int resourse;

    public ListAdapter(Context context, int resourse, ArrayList<Jogador> jogadores){
        super(context, resourse, jogadores);
        this.jogadores = jogadores;
        this.context = context;
        this.resourse = resourse;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) getContext()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.custom_list_layout, null, true);
        }
        Jogador jogador = getItem(position);
        TextView tvNome = convertView.findViewById(R.id.tvNome);
        tvNome.setText(jogador.getNome());

        return convertView;
    }
}
