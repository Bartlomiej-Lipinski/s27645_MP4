package Xor;

public class Projekt{
    private String nazwa;
    Mechanik mechanik;

    public Projekt(String nazwa) {
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
            throw new IllegalStateException("Projekt jest już przypisany do mechanika. Nie można przypisać do innego mechanika.");
        }
        this.mechanik = mechanik;
        mechanik.setProjekt(this);
    }
}
