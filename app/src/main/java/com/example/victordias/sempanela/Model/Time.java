package com.example.victordias.sempanela.Model;

import java.util.ArrayList;
import java.util.List;

public class Time {

    private List<Jogador> jogadores;
    private String nome;
    private static int contador=0;

    public Time(List<Jogador> jogadores){
        this.jogadores = jogadores;
        contador++;
        nome= "Time " + contador;
    }

    public Time(){
        this.jogadores = new ArrayList<Jogador>();
        contador++;
        nome= "Time " + contador;
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
