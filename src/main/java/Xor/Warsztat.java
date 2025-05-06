package Xor;

public class Warsztat {
    private String nazwa;
    private Mechanik mechanik;

    public Warsztat(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    public Mechanik getMechanik() {
        return mechanik;
    }
    public void setMechanik(Mechanik mechanik) {
        if (this.mechanik != null) {
            throw new IllegalStateException("Warsztat jest już przypisany do mechanika. Nie można przypisać do innego mechanika.");
        }
        if (mechanik.getWarsztat() != null || mechanik.getProjekt() != null) {
            throw new IllegalStateException("Mechanik jest już przypisany do warsztatu lub projektu. Nie można przypisać do innego warsztatu.");
        }

        this.mechanik = mechanik;
        mechanik.setWarsztat(this);
    }
}
