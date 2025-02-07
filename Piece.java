import java.util.ArrayList;
import java.util.Random;
public class Piece {
    private String tvar;
    private int smerX;
    private int smerY;
    private int poziciaX;
    private int poziciaY;
    private String farba;
    private boolean spadol;
    private ArrayList<ObalenyStvorec> zobrazenie;
    private ArrayList<String> tvary;
    private ArrayList<String> farby;
    private Manazer manazer;
    public Piece(String tvar, String farba) {
        Manazer manazer = new Manazer();
        Random random = new Random();
        this.zobrazenie = new ArrayList<ObalenyStvorec>();
        
        this.tvary = new ArrayList<String>();
        this.tvary.add("I");
        this.tvary.add("J");
        this.tvary.add("S");
        this.tvary.add("Z");
        this.tvary.add("O");
        this.tvary.add("T");
        this.tvary.add("L");
        
        this.farby = new ArrayList<String>();
        this.farby.add("red");
        this.farby.add("blue");
        this.farby.add("green");
        this.farby.add("yellow");
        this.farby.add("magenta");
        
        this.tvar = tvar;
        this.smerX = random.nextInt(2)-1;
        this.smerY = random.nextInt(2)-1;
        this.spadol = false;
        this.poziciaX = 0;
        this.poziciaY = 0; 
        if ( tvar == "R" ) {
            this.tvar = tvary.get(random.nextInt(tvary.size()));
        }
        if ( farba == "R" ) {
            this.farba = farby.get(random.nextInt(farby.size()));
        }
        
        switch (this.tvar){
            case "I":
                this.zobrazenie.add(new ObalenyStvorec(this, 0,0,this.farba));
                this.zobrazenie.add(new ObalenyStvorec(this, 0,1,this.farba));
                this.zobrazenie.add(new ObalenyStvorec(this, 0,2,this.farba));
                break;
            case "L":
                this.zobrazenie.add(new ObalenyStvorec(this, 0,0,this.farba));
                this.zobrazenie.add(new ObalenyStvorec(this, 0,1,this.farba));
                this.zobrazenie.add(new ObalenyStvorec(this, 0,2,this.farba));
                this.zobrazenie.add(new ObalenyStvorec(this, 1,2,this.farba));
                break;
            case "J":
                this.zobrazenie.add(new ObalenyStvorec(this, 0,0,this.farba));
                this.zobrazenie.add(new ObalenyStvorec(this, 0,1,this.farba));
                this.zobrazenie.add(new ObalenyStvorec(this, 0,2,this.farba));
                this.zobrazenie.add(new ObalenyStvorec(this, -1,2,this.farba));
                break;
            case "O":
                this.zobrazenie.add(new ObalenyStvorec(this, 0,0,this.farba));
                this.zobrazenie.add(new ObalenyStvorec(this, 0,1,this.farba));
                this.zobrazenie.add(new ObalenyStvorec(this, 1,0,this.farba));
                this.zobrazenie.add(new ObalenyStvorec(this, 1,1,this.farba));
                break;
            case "S":
                this.zobrazenie.add(new ObalenyStvorec(this, 0,1,this.farba));
                this.zobrazenie.add(new ObalenyStvorec(this, 1,1,this.farba));
                this.zobrazenie.add(new ObalenyStvorec(this, 1,0,this.farba));
                this.zobrazenie.add(new ObalenyStvorec(this, 2,0,this.farba));
                break;
            case "Z":
                this.zobrazenie.add(new ObalenyStvorec(this, 0,0,this.farba));
                this.zobrazenie.add(new ObalenyStvorec(this, 1,0,this.farba));
                this.zobrazenie.add(new ObalenyStvorec(this, 1,1,this.farba));
                this.zobrazenie.add(new ObalenyStvorec(this, 2,1,this.farba));
                break;
            case "T":
                this.zobrazenie.add(new ObalenyStvorec(this, 0,0,this.farba));
                this.zobrazenie.add(new ObalenyStvorec(this, 1,0,this.farba));
                this.zobrazenie.add(new ObalenyStvorec(this, 2,0,this.farba));
                this.zobrazenie.add(new ObalenyStvorec(this, 1,1,this.farba));
                break;
            default:
                break;
        }
        int rotujKrat = random.nextInt(3);
        int posunX = random.nextInt(9)+3;
        for (ObalenyStvorec stvorec : this.zobrazenie) {
            for (int i = 0; i < rotujKrat; i++) {
                stvorec.otocSa();
            }
            stvorec.getStvorec().posunVodorovne(posunX*20);
            stvorec.pripocitajKPoziciiNaPlatneX(posunX * 20);
            stvorec.getStvorec().zobraz();
        }
    }
    
    
    public void aktivuj() {
       if ( !this.spadol ) {
           for (ObalenyStvorec stvorec : this.zobrazenie) {
               stvorec.getStvorec().skry();
            }
           for (ObalenyStvorec stvorec : this.zobrazenie) {
               stvorec.otocSa();
           }
           for (ObalenyStvorec stvorec : this.zobrazenie) {
               stvorec.getStvorec().zobraz();
           }
        }
    }
}
