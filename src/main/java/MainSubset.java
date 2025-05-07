import Subset.*;
public class MainSubset {
    public static void main(String[] args) throws Exception {
        Mechanik mechanik = new Mechanik("Jan", "Kowalski", "Specjalizacja A");
        Naprawa naprawa = new Naprawa(1, "Opis naprawy A", 100.0);
        Naprawa naprawa2 = new Naprawa(2, "Opis naprawy B", 200.0);
        mechanik.addNaprawa(naprawa);
        mechanik.addNaprawa(naprawa2);
        mechanik.addBiezacaNaprawa(naprawa);
        mechanik.getWszystkieNaprawy();
        mechanik.getBiezaceNaprawy();
        mechanik.removeBiezacaNaprawa(naprawa);
        mechanik.removeNaprawa(naprawa);
        mechanik.getWszystkieNaprawy();


    }
}
