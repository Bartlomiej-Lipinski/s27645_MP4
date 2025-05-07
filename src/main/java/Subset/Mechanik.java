package Subset;

import Utility.ObjectPlus4;

import java.util.HashSet;
import java.util.Set;

public class Mechanik extends ObjectPlus4 {
    private String imie;
    private String nazwisko;
    private String specjalizacja;
    private Set<Naprawa> wszystkieNaprawy = new HashSet<>();
    private Set<Naprawa> biezaceNaprawy = new HashSet<>();

    public Mechanik(String imie, String nazwisko, String specjalizacja) {
        super();
        setImie(imie);
        setNazwisko(nazwisko);
        setSpecjalizacja(specjalizacja);
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

    public String getSpecjalizacja() {
        return specjalizacja;
    }

    public void setSpecjalizacja(String specjalizacja) {
        checkForNullValue(specjalizacja, "Specjalizacja cannot be null");
        checkStringForEmptyAndBlank(specjalizacja, "Specjalizacja cannot be empty or blank");
        this.specjalizacja = specjalizacja;
    }

    private void checkForNullValue(String value, String message) {
        if (value == null) {
            throw new IllegalArgumentException(message);
        }
    }

    private void checkStringForEmptyAndBlank(String value, String message) {
        if (value.isEmpty() || value.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }

    public void addNaprawa(Naprawa naprawa) {
        if (naprawa == null) {
            throw new IllegalArgumentException("Naprawa nie może być null");
        }
        if (wszystkieNaprawy.contains(naprawa)) {
            throw new IllegalStateException("Naprawa już istnieje");
        }
        wszystkieNaprawy.add(naprawa);
        addLink("naprawa", "mechanik", naprawa);
    }

    public void addBiezacaNaprawa(Naprawa naprawa) throws Exception {
        if (naprawa == null) {
            throw new IllegalArgumentException("Naprawa nie może być null");
        }

        if (!wszystkieNaprawy.contains(naprawa)) {
            throw new IllegalStateException("Naprawa musi najpierw zostać dodana do wszystkich napraw");
        }
        addLink_subset("bieżąceNaprawy","mechanik","naprawa",naprawa);
        biezaceNaprawy.add(naprawa);
    }

    public void removeNaprawa(Naprawa naprawa) {
        if (naprawa == null) {
            throw new IllegalArgumentException("Naprawa nie może być null");
        }
        wszystkieNaprawy.remove(naprawa);
        biezaceNaprawy.remove(naprawa);
    }
    public void removeCurrentNaprawa(Naprawa naprawa) {
        if (naprawa == null) {
            throw new IllegalArgumentException("Naprawa nie może być null");
        }
        if (isLink("bieżąceNaprawy",  naprawa)) {
            throw new IllegalArgumentException("remove current repair first");
        }
    }

    public void getWszystkieNaprawy() throws Exception {
        showLinks("naprawa", System.out);
    }

    public void getBiezaceNaprawy() throws Exception {
        showLinks("bieżąceNaprawy", System.out);
    }
}
