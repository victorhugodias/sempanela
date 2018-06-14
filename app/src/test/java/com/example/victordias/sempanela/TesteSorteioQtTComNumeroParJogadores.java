package com.example.victordias.sempanela;

import com.example.victordias.sempanela.Model.Jogador;
import com.example.victordias.sempanela.Model.Sorteio;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TesteSorteioQtTComNumeroParJogadores {

    @Test
    public void addition_isCorrect() {
//        assertEquals(4, 2 + 2);
        Sorteio sorteio = new Sorteio();

        List<Jogador> jogadores = new ArrayList<>();
        jogadores.add(new Jogador("teste"));
        jogadores.add(new Jogador("teste2"));
        jogadores.add(new Jogador("teste3"));
        jogadores.add(new Jogador("teste4"));
        assertEquals(2,sorteio.realizarSorteioQtTimes(jogadores,2).size());


    }


}