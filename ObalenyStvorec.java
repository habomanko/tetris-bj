import java.util.Random;

public class ObalenyStvorec {
    private int poziciaX;
    private int poziciaY;
    private String farba;
    private Stvorec stvorec;
    private int rotacia;
    private Piece referenciaNaPiece;
    private int poziciaXNaPlatne;
    private int poziciaYNaPlatne;
    public ObalenyStvorec(Piece piece, int poziciaX, int poziciaY, String farba) {
        this.referenciaNaPiece = piece;
        this.poziciaXNaPlatne = poziciaX * 20;
        this.poziciaYNaPlatne = poziciaY * 20;
        Random random = new Random();
        this.poziciaX = poziciaX;
        this.poziciaY = poziciaY;
        this.farba = farba;
        this.stvorec = new Stvorec();
        this.stvorec.posunZvisle(-50);
        this.stvorec.posunVodorovne(-60);
        this.stvorec.zmenStranu(20);
        this.stvorec.zmenFarbu(farba);
        this.stvorec.posunZvisle(poziciaY * 20);
        this.stvorec.posunVodorovne(poziciaX * 20);
        this.rotacia = 0;
    }
    
    public Stvorec getStvorec() {
        return this.stvorec;
    }
    
    public void pripocitajKPoziciiNaPlatneX(int posun) {
        this.poziciaXNaPlatne += posun;
    }
    
    public void setPoziciaNaPlatneX(int poziciaX) {
        this.poziciaXNaPlatne = poziciaX;
    }
    public void setPoziciaNaPlatneY(int poziciaY) {
        this.poziciaYNaPlatne = poziciaY;
    }
    
    public boolean spadol() {
        
        return false;
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
