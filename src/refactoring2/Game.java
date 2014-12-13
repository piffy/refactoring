
package refactoring2;


public class Game {

    public G g1;
    public G g2;

    public Game(G x, G y) {
        this.g1 = x;
        this.g2 = y;
    }

    public String P() {
        if (g1.p >= 3 && g2.p >= 3) {
            if (Math.abs(g2.p - g1.p) >= 2) {
                if (g1.p > g2.p)
                return  g1.n+" vince";
                if (g1.p < g2.p)
                return g2.n+ " vince ";
                
            } else if (g1.p == g2.p) {
                return "parità";
            } else {
                if (g1.p > g2.p)
                return "vantaggio " + g1.n;
                if (g1.p < g2.p)
                return "vantaggio " + g2.n;
            }
        } else {
            String puntiG1,puntiG2;
            puntiG1=g1.DescrPunt();
            puntiG2=g2.DescrPunt();
            return puntiG1 + ", " + puntiG2;
        }
        return "Errore";
    }


}