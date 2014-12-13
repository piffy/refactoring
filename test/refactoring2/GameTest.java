/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

    Giocatore pippo;
    Giocatore pluto;
    Game game;

    @Before
    public void perTuttiITest() {
        pippo = new Giocatore("Pippo");
        pluto = new Giocatore("Pluto");
        game = new Game(pippo, pluto);
    }

    @Test
    public void zeroDeveEssereLaDescrzionePerIlPunteggio0() {
        Game game = new Game(pippo, pluto);
        assertEquals(game.getPunteggio(), "zero, zero");
    }

    @Test
    public void quindiciDeveEssereIlDescrittorePerIlPunteggio1() {
        pluto.vinciPalla();
        assertEquals(game.getPunteggio(), "zero, quindici");
    }

    @Test
    public void trentaDeveEssereIlDescrittorePerIlPunteggio2() {
        pippo.vinciPalla();
        pippo.vinciPalla();
        pluto.vinciPalla();
        assertEquals(game.getPunteggio(), "trenta, quindici");
    }

    @Test
    public void quarantaSDeveEssereIlDescrittorePerIlPunteggio3() {
        pippo.vinciPalla();pippo.vinciPalla();pippo.vinciPalla();
        assertEquals(game.getPunteggio(), "quaranta, zero");
    }

    @Test
    public void vantaggioDeveEssereIlDescrittorePerIlPunteggioQuandoEntrmbiHannoFatto3PuntiEUnGiocatoreHaUnPuntoDiVantaggio() {
        pippo.vinciPalla();pippo.vinciPalla();pippo.vinciPalla();
        pluto.vinciPalla();pluto.vinciPalla();pluto.vinciPalla();pluto.vinciPalla();
        assertEquals(game.getPunteggio(), "vantaggio Pluto");
    }

    @Test
    public void paritàDeveEssereIlDescrittorePerIlPunteggioQuandoEntrmbiHannoFatto3PuntiEIPunteggiSonoUguali() {
        pippo.vinciPalla();pippo.vinciPalla();pippo.vinciPalla();
        pluto.vinciPalla();pluto.vinciPalla();pluto.vinciPalla();
        assertEquals(game.getPunteggio(), "parità");
        pippo.vinciPalla();
        assertFalse(game.getPunteggio().equals("parità"));
        pluto.vinciPalla();
        assertEquals(game.getPunteggio(), "parità");
    }

    @Test
    public void ilGameDeveEssereVintoDalPrimoGiocatoreCheAbbiAlmenoQuattroPuntiEDuePuntiDiVantaggio() {
        pippo.vinciPalla();pippo.vinciPalla();pippo.vinciPalla();pippo.vinciPalla();
        pluto.vinciPalla();pluto.vinciPalla();pluto.vinciPalla();
        assertFalse(game.getPunteggio().equals("Pippo vince"));
        assertFalse(game.getPunteggio().equals("Pluto vince"));
        pippo.vinciPalla();
        assertEquals(game.getPunteggio(), "Pippo vince");
    }

}