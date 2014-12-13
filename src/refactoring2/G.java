package refactoring2;

public class G {

    int p;
    String n;

    public void VINC() {
        this.p = this.p + 1;
    }

    public G(String name) {
        this.n = name;
    }

    public String DescrPunt(){
        if (p==0) return "zero";
        if (p==1) return "quindici";
        if (p==2) return "trenta";
        return "quaranta";
        
    }

}