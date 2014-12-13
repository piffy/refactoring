
package refactoring2;


public class Game {

    Giocatore player1;
    Giocatore player2;

    public Game(Giocatore player1, Giocatore player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getPunteggio() {
        if (player1.punteggio >= 3 && player2.punteggio >= 3) {
            if (Math.abs(player2.punteggio - player1.punteggio) >= 2) {
                if (player1.punteggio > player2.punteggio)
                return  player1.nome+" vince";
                if (player1.punteggio < player2.punteggio)
                return player2.nome+ " vince ";
                
            } else if (player1.punteggio == player2.punteggio) {
                return "parità";
            } else {
                if (player1.punteggio > player2.punteggio)
                return "vantaggio " + player1.nome;
                if (player1.punteggio < player2.punteggio)
                return "vantaggio " + player2.nome;
            }
        } else {
            String puntiG1,puntiG2;
            puntiG1=player1.getDescrizionePunteggi();
            puntiG2=player2.getDescrizionePunteggi();
            return puntiG1 + ", " + puntiG2;
        }
        return "Errore";
    }


}