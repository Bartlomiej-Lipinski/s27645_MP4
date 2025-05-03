package Subset;
import java.util.Set;

public class Naprawa {
    private int numerNaprawy;
    private String opis;
    private double koszt;
    private Set<Mechanik> mechanicy = new HashSet<>();

    public Naprawa(int numerNaprawy, String opis, double koszt) {
        this.numerNaprawy = numerNaprawy;
        this.opis = opis;
        this.koszt = koszt;
    }

    public void addMechanik(Mechanik mechanik) {
        if (mechanik == null) {
            throw new IllegalArgumentException("Mechanik nie może być null");
        }
        mechanicy.add(mechanik);
        mechanik.addNaprawa(this, true);
    }

    public void removeMechanik(Mechanik mechanik) {
        if (mechanik == null) {
            throw new IllegalArgumentException("Mechanik nie może być null");
        }
        mechanicy.remove(mechanik);
        mechanik.removeNaprawa(this);
    }

    public Set<Mechanik> getMechanicy() {
        return mechanicy;
    }
}