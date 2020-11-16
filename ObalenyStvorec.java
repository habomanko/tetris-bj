

public class ObalenyStvorec {
    private int poziciaX;
    private int poziciaY;
    private String farba;
    private Stvorec stvorec;
    private int rotacia;
    public ObalenyStvorec(int poziciaX, int poziciaY, String farba) {
        this.poziciaX = poziciaX;
        this.poziciaY = poziciaY;
        this.farba = farba;
        this.stvorec = new Stvorec();
        this.stvorec.zmenStranu(20);
        this.stvorec.zmenFarbu(farba);
        this.stvorec.posunZvisle(poziciaY * 20);
        this.stvorec.posunVodorovne(poziciaX * 20);
        this.rotacia = 0;
    }
    
    public Stvorec getStvorec() {
        return this.stvorec;
    }
    
    public void otocSa() { 
        this.stvorec.posunZvisle(-this.poziciaY * 20);
        this.stvorec.posunVodorovne(-this.poziciaX * 20);
        
        this.stvorec.posunZvisle(-this.poziciaX * 20);
        this.stvorec.posunVodorovne(this.poziciaY * 20);
        int povodneY = this.poziciaY;
        this.poziciaY = -poziciaX;
        this.poziciaX = povodneY;
        this.rotacia = 0;
    }
}
