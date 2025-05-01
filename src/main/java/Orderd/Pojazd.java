package Orderd;

import java.util.HashSet;
import java.util.Set;

public class Pojazd {
    private String marka;
    private String model;
    private String kolor;
    private int rokProdukcji;
    private Set<Naprawa> naprawas = new HashSet<>();

    public Pojazd(String marka, String model, String kolor, int rokProdukcji) {
        setMarka(marka);
        setModel(model);
        setKolor(kolor);
        setRokProdukcji(rokProdukcji);
    }
    public Naprawa addNaprawa(Naprawa naprawa) {
        if (naprawa == null) {
            throw new IllegalArgumentException("Naprawa cannot be null");
        }
        if (naprawas.contains(naprawa)) {
            throw new IllegalArgumentException("Naprawa already exists for this vehicle");
        }
        naprawas.add(naprawa);
        return naprawa;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        checkForNullValue(marka, "Marka cannot be null");
        checkStringForEmptyAndBlank(marka, "Marka cannot be empty or blank");
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        checkForNullValue(model, "Model cannot be null");
        checkStringForEmptyAndBlank(model, "Model cannot be empty or blank");
        this.model = model;
    }

    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        checkForNullValue(kolor, "Kolor cannot be null");
        checkStringForEmptyAndBlank(kolor, "Kolor cannot be empty or blank");
        this.kolor = kolor;
    }

    public int getRokProdukcji() {
        return rokProdukcji;
    }

    public void setRokProdukcji(int rokProdukcji) {
        if (rokProdukcji < 1886 || rokProdukcji > 2023) { // Assuming the current year is 2023
            throw new IllegalArgumentException("Rok produkcji must be between 1886 and 2023");
        }
        this.rokProdukcji = rokProdukcji;
    }

    private void checkStringForEmptyAndBlank(String string, String message) {
        if (string.isEmpty() || string.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }

    private void checkForNullValue(String string, String message) {
        if (string == null) {
            throw new IllegalArgumentException(message);
        }
    }
}
