package Atrybutu;


public class Mechanik {
    private String imie;
    private String nazwisko;
    private int wiek; // nie może być mniejszy niż 18 i większy niż 65
    private int iloscNapraw; // wzrosnąć o wiecej niż 5 nie może zmaleć

    public Mechanik(String imie, String nazwisko, int wiek, int iloscNapraw) {
        setImie(imie);
        setNazwisko(nazwisko);
        setWiek(wiek);
        setIloscNapraw(iloscNapraw);
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        if (imie == null || imie.isEmpty()) {
            throw new IllegalArgumentException("Imię nie może być puste");
        }
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        if (nazwisko == null || nazwisko.isEmpty()) {
            throw new IllegalArgumentException("Nazwisko nie może być puste");
        }
        this.nazwisko = nazwisko;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        if (this.wiek < wiek){
            throw new IllegalArgumentException("Wiek nie może wzrosnąć");
        }
        if (wiek < 18 || wiek > 65) {
            throw new IllegalArgumentException("Wiek musi być w przedziale 18-65");
        }
        this.wiek = wiek;
    }

    public int getIloscNapraw() {
        return iloscNapraw;
    }

    public void setIloscNapraw(int iloscNapraw) {
        if (iloscNapraw < 0) {
            throw new IllegalArgumentException("Ilość napraw nie może być ujemna");
        }
        if (iloscNapraw- this.iloscNapraw > 5) {
            throw new IllegalArgumentException("Ilość napraw nie może wzrosnąć o więcej niż 5");
        }
        if (iloscNapraw < this.iloscNapraw) {
            throw new IllegalArgumentException("Ilość napraw nie może zmaleć");
        }
        this.iloscNapraw = iloscNapraw;
    }
}
