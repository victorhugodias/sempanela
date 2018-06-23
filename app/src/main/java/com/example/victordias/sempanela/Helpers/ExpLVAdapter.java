package com.example.victordias.sempanela.Helpers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.victordias.sempanela.Model.Time;
import com.example.victordias.sempanela.R;

import java.util.ArrayList;

public class ExpLVAdapter extends BaseExpandableListAdapter{

    private ArrayList<Time> times;
    private Context context;

    public ExpLVAdapter(Context context, ArrayList<Time> times) {
        this.times = times;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return times.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return times.get(i).getJogadores().size();
    }

    @Override
    public Object getGroup(int i) {
        return times.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return times.get(i).getJogadores().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String nomeGrupo = (String) times.get(i).getNome();
        view = LayoutInflater.from(context).inflate(R.layout.custom_group_list_layout,null);
        TextView tvGroup = view.findViewById(R.id.tvGroup);
        tvGroup.setText(nomeGrupo);

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        String jogador = (String) times.get(i).getJogadores().get(i1).getNome();
        view = LayoutInflater.from(context).inflate(R.layout.custom_list_layout,null);
        TextView tvJogador = view.findViewById(R.id.tvNome);
        tvJogador.setText(jogador);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
