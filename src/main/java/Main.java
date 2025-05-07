import Xor.Mechanik;
import Xor.Projekt;
import Xor.Warsztat;

public class Main {
    public static void main(String[] args) throws Exception {
        // Create instances of Warsztat and Projekt
        Warsztat warsztat = new Warsztat("Warsztat A");
        Projekt projekt = new Projekt("Projekt A");

        // Create an instance of Mechanik
        Mechanik mechanik = new Mechanik("Jan Kowalski");

        // Set the warsztat and projekt
//        mechanik.setProjekt(projekt);
        mechanik.setWarsztat(warsztat);

        // Print the names of warsztat and projekt
//        System.out.println("Warsztat: " + mechanik.getWarsztat().getNazwa());
        mechanik.getConnections();
        Mechanik.getExtent(Mechanik.class).forEach(System.out::println);
        mechanik.remove();
        System.out.println("Usunięto mechanika z warsztatu");
        mechanik.getConnections();
        Mechanik.getExtent(Mechanik.class).forEach(System.out::println);

    }
}
