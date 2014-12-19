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
    public void zeroDeveEssereLaDescrizionePerIlPunteggio0() {
        assertEquals(game.P(), "zero, zero");
    }

    @Test
    public void quindiciDeveEssereIlDescrittorePerIlPunteggio1() {
        game.VINC("Pluto");
        assertEquals(game.P(), "zero, quindici");
    }

    @Test
    public void trentaDeveEssereIlDescrittorePerIlPunteggio2() {
        game.VINC("Pippo");
        game.VINC("Pluto");
        game.VINC("Pippo");
        assertEquals(game.P(), "trenta, quindici");
    }

    @Test
    public void quarantaSDeveEssereIlDescrittorePerIlPunteggio3() {
        game.VINC("Pippo");game.VINC("Pippo");game.VINC("Pippo");
        assertEquals(game.P(), "quaranta, zero");
    }

    @Test
    public void vantaggioDeveEssereIlDescrittorePerIlPunteggioQuandoEntrmbiHannoFatto3PuntiEUnGiocatoreHaUnPuntoDiVantaggio() {
        game.VINC("Pippo");game.VINC("Pippo");game.VINC("Pippo");
        game.VINC("Pluto");game.VINC("Pluto");game.VINC("Pluto");game.VINC("Pluto");
        assertEquals(game.P(), "vantaggio Pluto");
    }

    @Test
    public void paritàDeveEssereIlDescrittorePerIlPunteggioQuandoEntrmbiHannoFatto3PuntiEIPunteggiSonoUguali() {
        game.VINC("Pippo");game.VINC("Pippo");game.VINC("Pippo");
        game.VINC("Pluto");game.VINC("Pluto");game.VINC("Pluto");
        assertEquals(game.P(), "parità");
        game.VINC("Pippo");
        assertFalse(game.P().equals("parità"));
        game.VINC("Pluto");
        assertEquals(game.P(), "parità");
    }

    @Test
    public void ilGameDeveEssereVintoDalPrimoGiocatoreCheAbbiAlmenoQuattroPuntiEDuePuntiDiVantaggio() {
        game.VINC("Pippo");game.VINC("Pippo");game.VINC("Pippo");game.VINC("Pippo");
        game.VINC("Pluto");game.VINC("Pluto");game.VINC("Pluto");
        assertFalse(game.P().equals("Pippo vince"));
        assertFalse(game.P().equals("Pluto vince"));
        game.VINC("Pippo");
        assertEquals(game.P(), "Pippo vince");
    }

}