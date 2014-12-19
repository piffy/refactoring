package refactoring2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/*
Original code by Victor Farcic, https://github.com/vfarcic

**Regole:**

* I punteggi da 0 a 3 punti sono descritti come "zero", "quindici", "trenta", e "quaranta" rispettivamente.
* Se entrambi hanno fatto almeno tre punti, e un giocatore ha un punto di vantaggio, il punteggio è "vantaggio" per un giocatore.
* Se entrambi hanno fatto almeno tre punti e hanno lo stesso punteggio, il risultato è "parità".
* Un game è vinto dal primo giocatre che ha almeno quattro punti e due punti di vantaggio.
*/
public class GameTest {

    Game game;

    @Before
    public void perTuttiITest() {
        game = new Game("Pippo", "Pluto");
    }

    @Test
    public void zeroDeveEssereLaDescrzionePerIlPunteggio0() {
        assertEquals(game.getPunteggio(), "zero, zero");
    }

    @Test
    public void quindiciDeveEssereIlDescrittorePerIlPunteggio1() {
        game.puntoPer("Pluto");
        assertEquals(game.getPunteggio(), "zero, quindici");
    }

    @Test
    public void trentaDeveEssereIlDescrittorePerIlPunteggio2() {
        game.puntoPer("Pippo");
        game.puntoPer("Pippo");
        game.puntoPer("Pluto");
        assertEquals(game.getPunteggio(), "trenta, quindici");
    }

    @Test
    public void quarantaSDeveEssereIlDescrittorePerIlPunteggio3() {
        game.puntoPer("Pippo");game.puntoPer("Pippo");game.puntoPer("Pippo");
        assertEquals(game.getPunteggio(), "quaranta, zero");
    }

    @Test
    public void vantaggioDeveEssereIlDescrittorePerIlPunteggioQuandoEntrmbiHannoFatto3PuntiEUnGiocatoreHaUnPuntoDiVantaggio() {
        game.puntoPer("Pippo");game.puntoPer("Pippo");game.puntoPer("Pippo");
        game.puntoPer("Pluto");game.puntoPer("Pluto");game.puntoPer("Pluto");game.puntoPer("Pluto");
        assertEquals(game.getPunteggio(), "vantaggio Pluto");
    }

    @Test
    public void paritàDeveEssereIlDescrittorePerIlPunteggioQuandoEntrmbiHannoFatto3PuntiEIPunteggiSonoUguali() {
        game.puntoPer("Pippo");game.puntoPer("Pippo");game.puntoPer("Pippo");
        game.puntoPer("Pluto");game.puntoPer("Pluto");game.puntoPer("Pluto");
        assertEquals(game.getPunteggio(), "parità");
        game.puntoPer("Pippo");
        assertFalse(game.getPunteggio().equals("parità"));
        game.puntoPer("Pluto");
        assertEquals(game.getPunteggio(), "parità");
    }

    @Test
    public void ilGameDeveEssereVintoDalPrimoGiocatoreCheAbbiAlmenoQuattroPuntiEDuePuntiDiVantaggio() {
        game.puntoPer("Pippo");game.puntoPer("Pippo");game.puntoPer("Pippo");game.puntoPer("Pippo");
        game.puntoPer("Pluto");game.puntoPer("Pluto");game.puntoPer("Pluto");
        assertFalse(game.getPunteggio().equals("Pippo vince"));
        assertFalse(game.getPunteggio().equals("Pluto vince"));
        game.puntoPer("Pippo");
        assertEquals(game.getPunteggio(), "Pippo vince");
    }

}