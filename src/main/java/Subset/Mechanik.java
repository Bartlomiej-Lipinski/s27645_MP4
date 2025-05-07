package Subset;
import Utility.ObjectPlus4;

public class Mechanik extends ObjectPlus4 {
    private String imie;
    private String nazwisko;
    private String specjalizacja;

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
        addLink("naprawa", "mechanik", naprawa);
    }

    public void addBiezacaNaprawa(Naprawa naprawa) throws Exception {
        if (naprawa == null) {
            throw new IllegalArgumentException("Naprawa nie może być null");
        }
        if (!isLink("naprawa",  naprawa)) {
            throw new IllegalArgumentException("add repair first");
        }
        addLink_subset("bieżąceNaprawy","mechanik","naprawa",naprawa);
    }

    public void removeNaprawa(Naprawa naprawa) {
        if (naprawa == null) {
            throw new IllegalArgumentException("Naprawa nie może być null");
        }
        if (isLink("bieżąceNaprawy",  naprawa)) {
            throw new IllegalArgumentException("remove from Currentrepair first");
        }
        removeLink("naprawa", "mechanik", naprawa);
    }
    public void removeBiezacaNaprawa(Naprawa naprawa) {
        if (naprawa == null) {
            throw new IllegalArgumentException("Naprawa nie może być null");
        }
        if (!isLink("bieżąceNaprawy",  naprawa)) {
            throw new IllegalArgumentException("not a current repair");
        }
        removeLink("bieżąceNaprawy", "mechanik", naprawa);

    }

    public void getWszystkieNaprawy() throws Exception {
        showLinks("naprawa", System.out);
    }

    public void getBiezaceNaprawy() throws Exception {
        showLinks("bieżąceNaprawy", System.out);
    }
}
