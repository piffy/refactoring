
package refactoring2;


public class Game {

    private Giocatore player1;
    private Giocatore player2;

    public Game(Giocatore player1, Giocatore player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getPunteggio() {
        if (player1.getPunteggio() >= 3 && player2.getPunteggio() >= 3) {
            if (Math.abs(player2.getPunteggio() - player1.getPunteggio()) >= 2) {
                return getGiocatoreInVantaggio().getNome() + " vince";
            } else if (player1.getPunteggio() == player2.getPunteggio()) {
                return "parità";
            } else {
                return "vantaggio " + getGiocatoreInVantaggio().getNome();
            }
        } else {
            return player1.getDescrizionePunteggi() + ", " + player2.getDescrizionePunteggi();
        }
    }

    public Giocatore getGiocatoreInVantaggio() {
        return (player1.getPunteggio() > player2.getPunteggio()) ? player1 : player2;
    }

}