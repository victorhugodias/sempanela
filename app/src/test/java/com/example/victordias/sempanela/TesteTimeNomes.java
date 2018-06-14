package com.example.victordias.sempanela;

import com.example.victordias.sempanela.Model.Jogador;
import com.example.victordias.sempanela.Model.Sorteio;
import com.example.victordias.sempanela.Model.Time;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TesteTimeNomes {
    @Test
    public void addition_isCorrect() {
        Sorteio sorteio = new Sorteio();
        List<Jogador> jogadores = new ArrayList<>();
        jogadores.add(new Jogador("teste"));
        jogadores.add(new Jogador("teste2"));
        jogadores.add(new Jogador("teste3"));
        jogadores.add(new Jogador("teste4"));
        jogadores.add(new Jogador("teste5"));

        List<Time> times = sorteio.realizarSorteioQtTimes(jogadores,2);
        assertEquals(3,times.size());

        assertEquals("Time 1",times.get(0).getNome());
        assertEquals("Time 2",times.get(1).getNome());
        assertEquals("Time de Reservas",times.get(2).getNome());
    }
}
