import Bag.*;

import java.time.LocalDate;

public class MainBag {
    public static void main(String[] args) {
        Mechanik mechanik = new Mechanik("Jan", "Kowalski", "Specjalizacja A");
        Warsztat warsztat = new Warsztat("Warsztat A");
        Employment employment = new Employment(LocalDate.now(), 3000.0, 8, mechanik, warsztat);
        System.out.println(employment.getCarRepairShop());
        System.out.println(employment.getMechanic());
        for (Employment emp : mechanik.getEmployments()) {
            System.out.println("Zatrudnienie: " + emp.getEmployed() + ", Wynagrodzenie: " + emp.getSalary() + ", Godziny: " + emp.getHowManyHoursShift());
        }
        for (Employment emp : warsztat.getEmployments()) {
            System.out.println("Zatrudnienie: " + emp.getEmployed() + ", Wynagrodzenie: " + emp.getSalary() + ", Godziny: " + emp.getHowManyHoursShift());
        }
        employment.removeEmployment();
        System.out.println("Usunięto zatrudnienie");
        for (Employment emp : mechanik.getEmployments()) {
            System.out.println("Zatrudnienie: " + emp.getEmployed() + ", Wynagrodzenie: " + emp.getSalary() + ", Godziny: " + emp.getHowManyHoursShift());
        }
        for (Employment emp : warsztat.getEmployments()) {
            System.out.println("Zatrudnienie: " + emp.getEmployed() + ", Wynagrodzenie: " + emp.getSalary() + ", Godziny: " + emp.getHowManyHoursShift());
        }

    }
}
