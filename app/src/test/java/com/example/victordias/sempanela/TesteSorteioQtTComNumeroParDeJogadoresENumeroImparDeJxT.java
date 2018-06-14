package com.example.victordias.sempanela;

import com.example.victordias.sempanela.Model.Jogador;
import com.example.victordias.sempanela.Model.Sorteio;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TesteSorteioQtTComNumeroParDeJogadoresENumeroImparDeJxT {

    @Test
    public void addition_isCorrect() {
        Sorteio sorteio = new Sorteio();
        List<Jogador> jogadores = new ArrayList<>();
        jogadores.add(new Jogador("teste"));
        jogadores.add(new Jogador("teste2"));
        jogadores.add(new Jogador("teste3"));
        jogadores.add(new Jogador("teste4"));
        jogadores.add(new Jogador("teste5"));
        jogadores.add(new Jogador("teste6"));
        assertEquals(2,sorteio.realizarSorteioQtTimes(jogadores,2).size());
    }
}
