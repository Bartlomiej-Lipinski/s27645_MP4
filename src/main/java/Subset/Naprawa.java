package Subset;
import Utility.ObjectPlusPlus;

import java.util.HashSet;
import java.util.Set;

public class Naprawa extends ObjectPlusPlus {
    private int numerNaprawy;
    private String opis;
    private double koszt;

    public Naprawa(int numerNaprawy, String opis, double koszt) {
        this.numerNaprawy = numerNaprawy;
        this.opis = opis;
        this.koszt = koszt;
    }
    public int getNumerNaprawy() {
        return numerNaprawy;
    }
    public void setNumerNaprawy(int numerNaprawy) {
        this.numerNaprawy = numerNaprawy;
    }
    public String getOpis() {
        return opis;
    }
    public void setOpis(String opis) {
        if (opis == null || opis.isEmpty()) {
            throw new IllegalArgumentException("Opis nie może być pusty");
        }
        this.opis = opis;
    }
    public double getKoszt() {
        return koszt;
    }
    public void setKoszt(double koszt) {
        if (koszt < 0) {
            throw new IllegalArgumentException("Koszt nie może być ujemny");
        }
        this.koszt = koszt;
    }

}