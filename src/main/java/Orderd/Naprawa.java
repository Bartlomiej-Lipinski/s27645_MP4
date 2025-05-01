package Orderd;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Naprawa {
    private static Set<Naprawa> naprawas = new TreeSet<>(Comparator.comparingDouble(Naprawa::getKoszt));
    private Pojazd pojazd;
    private Mechanik mechanik;
    private String opis;
    private double koszt;

    public Naprawa(Pojazd pojazd, Mechanik mechanik, String opis, double koszt) {
        setPojazd(pojazd);
        setMechanik(mechanik);
        setOpis(opis);
        setKoszt(koszt);
        if (naprawas.contains(this)) {
            throw new IllegalArgumentException("Naprawa already exists");
        }
        Naprawa n1 = pojazd.addNaprawa(this);
        Naprawa n2 = mechanik.addNaprawa(this);
        naprawas.add(this);
        if (n1 != this || n2 != this) {
            throw new IllegalArgumentException("Naprawa already exists in Pojazd or Mechanik");
        }
    }

    public Pojazd getPojazd() {
        return pojazd;
    }
    public void setPojazd(Pojazd pojazd) {
        checkForNullValue(pojazd, "Pojazd cannot be null");
        this.pojazd = pojazd;
    }
    public Mechanik getMechanik() {
        return mechanik;
    }
    public void setMechanik(Mechanik mechanik) {
        checkForNullValue(mechanik, "Mechanik cannot be null");
        this.mechanik = mechanik;
    }
    public String getOpis() {
        return opis;
    }
    public void setOpis(String opis) {
        checkForNullValue(opis, "Opis cannot be null");
        checkStringForEmptyAndBlank(opis, "Opis cannot be empty or blank");
        this.opis = opis;
    }
    public double getKoszt() {
        return koszt;
    }
    public void setKoszt(double koszt) {
        if (koszt < 0) {
            throw new IllegalArgumentException("Koszt cannot be negative");
        }
        this.koszt = koszt;
    }
    private void checkStringForEmptyAndBlank(String string, String message) {
        if (string.isEmpty() || string.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }
    private void checkForNullValue(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }
}
