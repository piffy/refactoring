package refactoring2;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Giocatore {

    public static final List<String> listaPunteggi = Arrays.asList("zero", "quindici", "trenta", "quaranta");

    private int punteggio;
    public int getPunteggio() {
        return punteggio;
    }
    String nome;
    public String getNome() {
        return nome;
    }

    public void vinciPalla() {
        this.punteggio = this.punteggio + 1;
    }

    public Giocatore(String name) {
        this.nome = name;
    }

    public String getDescrizionePunteggi(){
        return listaPunteggi.get(punteggio);
    }

}