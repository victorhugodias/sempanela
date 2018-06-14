package com.example.victordias.sempanela.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sorteio {

    private List<Time> times;

    public Sorteio() {
        this.times = new ArrayList<Time>();
    }

    //Realiza o sorteio de times levando em consideração a quantidade de times
    public List<Time> realizarSorteioQtTimes(List<Jogador> jogadores, int qtTimes){

        if(jogadores.size() < qtTimes || qtTimes <= 0){
            return null;
        }

        int numeroDeReservas = 0;
        //Essa variável define a quantidade de jogadores por time
        //sempre deixando os times com o maximo de jogadores possivel
        int qtdJogadoresPorTime = jogadores.size() / qtTimes;

        int sorteado = 0;
        Random random = new Random();

        //laço que define o tamanho dos times e a quantidade de jogadores na reserva
        while((jogadores.size() + numeroDeReservas) % qtTimes != 0){
            numeroDeReservas++;
        }

        for(int i = 0; i<qtTimes; i++){
            Time time = new Time();
            for(int z = 0; z < qtdJogadoresPorTime; z++){
                sorteado = random.nextInt(jogadores.size());
                time.setJogador(jogadores.get(sorteado));
                jogadores.remove(jogadores.get(sorteado));
            }
            times.add(time);
        }

        //Se houver mais jogadores do que o tamanho dos
        //times permite será criado um time Reservas.
        if(numeroDeReservas> 0){
            Time reservas = new Time(jogadores);
            reservas.setNome("Time de Reservas");
            times.add(reservas);
        }

        return times;

    }

    //Realiza o sorteio de times levando em consideração a quantidade de jogadores x time
    public List<Time> realizarSorteioQtJogadoresPorTime(List<Jogador> jogadores, int qtJDxTM){

        if(qtJDxTM > jogadores.size() || qtJDxTM <= 0){
            return null;
        }
        int qtTimes = jogadores.size() / qtJDxTM;

        //uma vez definida a quantidade de times,
        //podemos utilizar o método anterior
        return realizarSorteioQtTimes(jogadores, qtTimes);
    }



}
