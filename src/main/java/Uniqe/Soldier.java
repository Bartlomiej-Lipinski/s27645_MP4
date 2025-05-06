package Uniqe;

import java.util.HashSet;
import java.util.Set;

public class Soldier {
    private static Set<Soldier> soldiers = new HashSet<>();
    private String imie;
    private String nazwisko;
    private String stopien;
    private String jednostka;
    private String dataUrodzenia;
    private final String NumerLegitymacji;

    public Soldier(String imie, String nazwisko, String stopien, String jednostka, String dataUrodzenia, String NumerLegitymacji) {
        setImie(imie);
        setNazwisko(nazwisko);
        setStopien(stopien);
        setJednostka(jednostka);
        setDataUrodzenia(dataUrodzenia);
        checkForNullValue(NumerLegitymacji, "Numer legitymacji cannot be null");
        checkStringForEmptyAndBlank(NumerLegitymacji, "Numer legitymacji cannot be empty or blank");
        this.NumerLegitymacji = NumerLegitymacji;
        if (soldiers.contains(this)) {
            throw new IllegalArgumentException("Soldier already exists");
        }
        if (soldiers.stream().anyMatch(s -> s.getNumerLegitymacji().equals(NumerLegitymacji))) {
            throw new IllegalArgumentException("Soldier with this ID already exists");
        }
        soldiers.add(this);
    }
    public String getImie() {
        return imie;
    }
    public void setImie(String imie) {
        checkForNullValue(imie, "Imie cannot be null");
        checkStringForEmptyAndBlank(imie, "Imie cannot be empty or blank");
        this.imie = imie;
    }
    public String getNazwisko() {
        return nazwisko;
    }
    public void setNazwisko(String nazwisko) {
        checkForNullValue(nazwisko, "Nazwisko cannot be null");
        checkStringForEmptyAndBlank(nazwisko, "Nazwisko cannot be empty or blank");
        this.nazwisko = nazwisko;
    }
    public String getStopien() {
        return stopien;
    }
    public void setStopien(String stopien) {
        checkForNullValue(stopien, "Stopien cannot be null");
        checkStringForEmptyAndBlank(stopien, "Stopien cannot be empty or blank");
        this.stopien = stopien;
    }
    public String getJednostka() {
        return jednostka;
    }
    public void setJednostka(String jednostka) {
        checkForNullValue(jednostka, "Jednostka cannot be null");
        checkStringForEmptyAndBlank(jednostka, "Jednostka cannot be empty or blank");
        this.jednostka = jednostka;
    }
    public String getDataUrodzenia() {
        return dataUrodzenia;
    }
    public void setDataUrodzenia(String dataUrodzenia) {
        checkForNullValue(dataUrodzenia, "Data urodzenia cannot be null");
        checkStringForEmptyAndBlank(dataUrodzenia, "Data urodzenia cannot be empty or blank");
        this.dataUrodzenia = dataUrodzenia;
    }
    public String getNumerLegitymacji() {
        return NumerLegitymacji;
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
