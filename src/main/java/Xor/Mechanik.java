package Xor;

public class Mechanik {
    private Warsztat warsztat;
    private Projekt projekt;

    public void setWarsztat(Warsztat warsztat) {
        if (this.projekt != null) {
            throw new IllegalStateException("Mechanik jest już przypisany do projektu. Nie można przypisać do warsztatu.");
        }
        this.warsztat = warsztat;
    }

    public void setProjekt(Projekt projekt) {
        if (this.warsztat != null) {
            throw new IllegalStateException("Mechanik jest już przypisany do warsztatu. Nie można przypisać do projektu.");
        }
        this.projekt = projekt;
    }

    public Warsztat getWarsztat() {
        return warsztat;
    }

    public Projekt getProjekt() {
        return projekt;
    }
}
