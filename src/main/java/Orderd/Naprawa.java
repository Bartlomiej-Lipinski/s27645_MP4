package Orderd;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Naprawa {
    private static List<Naprawa> naprawas = new ArrayList<>();
    private String opis;
    private double koszt;

    public Naprawa(String opis, double koszt) {
        setOpis(opis);
        setKoszt(koszt);
        if (naprawas.contains(this)) {
            throw new IllegalArgumentException("Naprawa already exists");
        }
        naprawas.add(this);
        naprawas.sort(Comparator.comparingDouble(Naprawa::getKoszt));
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

    public static List<Naprawa> getNaprawas() {
        return new ArrayList<>(naprawas);
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
