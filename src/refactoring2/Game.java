
package refactoring2;


public class Game {
    
public static String DescrPunt(int p){
        if (p==0) return "zero";
        if (p==1) return "quindici";
        if (p==2) return "trenta";
        return "quaranta";    
}    

public void VINC(int nGioc){
        if (nGioc==1)
            g1Punt++;
        else
            g2Punt++;
        
} 


    String g1Nome;
    String g2Nome;
    int g1Punt;
    int g2Punt;
    

    public Game(G x, G y) {
        this.g1Nome = x.toString();
        this.g2Nome = y.toString();
    }

    public String P() {
        if (g1Punt >= 3 && g2Punt >= 3) {
            if (Math.abs(g2Punt - g1Punt) >= 2) {
                if (g1Punt > g2Punt)
                return g1Nome+" vince";
                if (g1Punt < g2Punt)
                return g2Nome+ " vince ";
                
            } else if (g1Punt == g2Punt) {
                return "parità";
            } else {
                if (g1Punt > g2Punt)
                return "vantaggio " +g1Nome;
                if (g1Punt < g2Punt)
                return "vantaggio " +g2Nome;
            }
        } else {
            String puntiG1,puntiG2;
            puntiG1=DescrPunt(g1Punt);
            puntiG2=DescrPunt(g2Punt);
            return puntiG1 + ", " + puntiG2;
        }
        return "Errore";
    }


}