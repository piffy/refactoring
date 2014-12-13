package refactoring2;

public class Giocatore {

    int punteggio;
    String nome;

    public void vinciPalla() {
        this.punteggio = this.punteggio + 1;
    }

    public Giocatore(String name) {
        this.nome = name;
    }

    public String getDescrizionePunteggi(){
        if (punteggio==0) return "zero";
        if (punteggio==1) return "quindici";
        if (punteggio==2) return "trenta";
        return "quaranta";
        
    }

}