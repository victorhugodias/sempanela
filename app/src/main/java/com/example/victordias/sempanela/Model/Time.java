package com.example.victordias.sempanela.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Time implements Serializable {

    private List<Jogador> jogadores;
    private String nome;


    public Time(String nome,List<Jogador> jogadores){
        this.setNome(nome);
        this.jogadores = jogadores;

    }

    public Time(String nome){
        this.jogadores = new ArrayList<Jogador>();
        this.setNome(nome);
    }

    public void setJogador(Jogador jogador){
        jogadores.add(jogador);
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
