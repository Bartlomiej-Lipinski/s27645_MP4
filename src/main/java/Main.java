public class Main {
    public static void main(String[] args) {
        // Create instances of Warsztat and Projekt
        Warsztat warsztat = new Warsztat("Warsztat A");
        Projekt projekt = new Projekt("Projekt A");

        // Create an instance of Mechanik
        Mechanik mechanik = new Mechanik();

        // Set the warsztat and projekt
        mechanik.setWarsztat(warsztat);
        mechanik.setProjekt(projekt);

        // Print the names of warsztat and projekt
        System.out.println("Warsztat: " + mechanik.getWarsztat().getNazwa());
        System.out.println("Projekt: " + mechanik.getProjekt().getNazwa());
    }
}
