package Xor;

import Utility.ObjectPlus4;

public class Mechanik extends ObjectPlus4 {
    private Warsztat warsztat;
    private Projekt projekt;
    private String imie;

    public Mechanik(String imie) {
        setImie(imie);
        addXorRole("warsztat");
        addXorRole("projekt");
    }


    public void setWarsztat(Warsztat warsztat) throws Exception {
        if (warsztat == null) {
            throw new IllegalStateException("Projekt cannot be null");
        }
       addLinkXor("warsztat", "mechanik", warsztat);
        clearAsociations();
        this.warsztat = warsztat;
    }

    public void setProjekt(Projekt projekt) throws Exception {
        if (projekt == null) {
            throw new IllegalArgumentException("Projekt cannot be null");
        }
        addLinkXor("projekt", "mechanik", projekt);
        clearAsociations();
        this.projekt = projekt;
    }

    public Warsztat getWarsztat() {
        if (warsztat == null) {
            throw new IllegalStateException("Warsztat is not assigned");
        }
        return warsztat;
    }

    public Projekt getProjekt() {
        if (projekt == null) {
            throw new IllegalStateException("Projekt is not assigned");
        }
        return projekt;
    }
    public void clearAsociations() {
        this.warsztat = null;
        this.projekt = null;
    }
    public String getImie() {
        return imie;
    }
    public void setImie(String imie) {
        if (imie == null || imie.isEmpty()) {
            throw new IllegalArgumentException("Imie cannot be null or empty");
        }
        this.imie = imie;
    }
}
