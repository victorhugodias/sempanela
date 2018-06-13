package com.example.victordias.sempanela.Model;

import java.util.List;

public class Sorteio {

    private List<Time> times;

    //Realiza o sorteio de times levando em consideração a quantidade de times
    public List<Time> realizarSorteioQtTimes(List<Jogador> jogadores, int qtTimes){

        int numeroDeReservas = 0;
        //Essa variável define a quantidade de jogadores por time
        //sempre deixando os times com o maximo de jogadores possivel
        int qtdJogadoresPorTime = jogadores.size() / qtTimes;

        //laço que define o tamanho dos times e a quantidade de jogadores na reserva
        while((jogadores.size() + numeroDeReservas) % qtTimes != 0){
            numeroDeReservas++;
        }

        for(int i = 0; i<qtTimes; i++){
            Time time = new Time();
            for(int z = 0; z < qtdJogadoresPorTime; z++){
                //logica para sorteio
            }
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

        if(qtJDxTM > jogadores.size()){
            return null;
        }
        int qtTimes = jogadores.size() / qtJDxTM;

        //uma vez definida a quantidade de times,
        //podemos utilizar o método anterior
        return realizarSorteioQtTimes(jogadores, qtTimes);
    }



}
