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

    G pippo;
    G pluto;
    Game game;

    @Before
    public void perTuttiITest() {
        pippo = new G("Pippo");
        pluto = new G("Pluto");
        game = new Game(pippo, pluto);
    }

    @Test
    public void zeroDeveEssereLaDescrizionePerIlPunteggio0() {
        Game game = new Game(pippo, pluto);
        assertEquals(game.P(), "zero, zero");
    }

    @Test
    public void quindiciDeveEssereIlDescrittorePerIlPunteggio1() {
        pluto.VINC();
        assertEquals(game.P(), "zero, quindici");
    }

    @Test
    public void trentaDeveEssereIlDescrittorePerIlPunteggio2() {
        pippo.VINC();
        pippo.VINC();
        pluto.VINC();
        assertEquals(game.P(), "trenta, quindici");
    }

    @Test
    public void quarantaSDeveEssereIlDescrittorePerIlPunteggio3() {
        pippo.VINC();pippo.VINC();pippo.VINC();
        assertEquals(game.P(), "quaranta, zero");
    }

    @Test
    public void vantaggioDeveEssereIlDescrittorePerIlPunteggioQuandoEntrmbiHannoFatto3PuntiEUnGiocatoreHaUnPuntoDiVantaggio() {
        pippo.VINC();pippo.VINC();pippo.VINC();
        pluto.VINC();pluto.VINC();pluto.VINC();pluto.VINC();
        assertEquals(game.P(), "vantaggio Pluto");
    }

    @Test
    public void paritàDeveEssereIlDescrittorePerIlPunteggioQuandoEntrmbiHannoFatto3PuntiEIPunteggiSonoUguali() {
        pippo.VINC();pippo.VINC();pippo.VINC();
        pluto.VINC();pluto.VINC();pluto.VINC();
        assertEquals(game.P(), "parità");
        pippo.VINC();
        assertFalse(game.P().equals("parità"));
        pluto.VINC();
        assertEquals(game.P(), "parità");
    }

    @Test
    public void ilGameDeveEssereVintoDalPrimoGiocatoreCheAbbiAlmenoQuattroPuntiEDuePuntiDiVantaggio() {
        pippo.VINC();pippo.VINC();pippo.VINC();pippo.VINC();
        pluto.VINC();pluto.VINC();pluto.VINC();
        assertFalse(game.P().equals("Pippo vince"));
        assertFalse(game.P().equals("Pluto vince"));
        pippo.VINC();
        assertEquals(game.P(), "Pippo vince");
    }

}