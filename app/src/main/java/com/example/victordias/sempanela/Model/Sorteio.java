package com.example.victordias.sempanela.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sorteio {

    private ArrayList<Time> times;

    public Sorteio() {
        this.times = new ArrayList<Time>();
    }

    //Realiza o sorteio de times levando em consideração a quantidade de times
    public ArrayList<Time> realizarSorteioQtTimes(List<Jogador> jogadores, int qtTimes){

        if(jogadores.size() < qtTimes || qtTimes <= 0){
            return null;
        }


        //Essa variável define a quantidade de jogadores por time
        //sempre deixando os times com o maximo de jogadores possivel
        int qtJDxTM = jogadores.size() / qtTimes;


        return RealizaSorteio(jogadores, qtJDxTM, qtTimes);

    }

    //Realiza o sorteio de times levando em consideração a quantidade de jogadores x time
    public ArrayList<Time> realizarSorteioQtJogadoresPorTime(List<Jogador> jogadores, int qtJDxTM){

        if(qtJDxTM > jogadores.size() || qtJDxTM <= 0){
            return null;
        }
        int qtTimes = jogadores.size() / qtJDxTM;

        return RealizaSorteio(jogadores, qtJDxTM, qtTimes);
    }

    private ArrayList<Time> RealizaSorteio(List<Jogador> jogadores, int qtJDxTM, int qtTimes) {

        int numeroDeReservas = 0;

        int sorteado = 0;
        Random random = new Random();

        //laço que define o tamanho dos times e a quantidade de jogadores na reserva
        while ((jogadores.size() + numeroDeReservas) % qtTimes != 0) {
            numeroDeReservas++;
        }

        for (int i = 0; i < qtTimes; i++) {
            Time time = new Time("Time " + (i + 1));
            for (int z = 0; z < qtJDxTM; z++) {
                sorteado = random.nextInt(jogadores.size());
                time.setJogador(jogadores.get(sorteado));

                jogadores.remove(jogadores.get(sorteado));
            }
            times.add(time);
        }

        if(numeroDeReservas>0){
            Time timeReserva = new Time("Time de Reservas");
            for (Jogador jogador:jogadores) {

                timeReserva.setJogador(jogador);
            }
            times.add(timeReserva);
        }

        return times;
    }


}
