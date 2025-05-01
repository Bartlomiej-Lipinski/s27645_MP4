package Orderd;
import java.util.HashSet;
import java.util.Set;

public class Mechanik {
    private String specialization;
    private String name;
    private String surname;
    private Set<Naprawa> naprawas = new HashSet<>();

    public Mechanik(String specialization, String name, String surname) {
        setSpecialization(specialization);
        setName(name);
        setSurname(surname);
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        checkForNullValue(specialization, "Specialization cannot be null");
        checkStringForEmptyAndBlank(specialization, "Specialization cannot be empty or blank");
        this.specialization = specialization;
    }
    public Naprawa addNaprawa(Naprawa naprawa) {
        if (naprawa == null) {
            throw new IllegalArgumentException("Naprawa nie może być null.");
        }
        if (naprawas.contains(naprawa)) {
            throw new IllegalArgumentException("Naprawa already exists for this mechanic");
        }
        naprawas.add(naprawa);
        return naprawa;
    }

    public void removeEmployment(Naprawa naprawa) {
        naprawas.remove(naprawa);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        checkForNullValue(name, "Name cannot be null");
        checkStringForEmptyAndBlank(name, "Name cannot be empty or blank");
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        checkForNullValue(surname, "Surname cannot be null");
        checkStringForEmptyAndBlank(surname, "Surname cannot be empty or blank");
        this.surname = surname;
    }

    private void checkStringForEmptyAndBlank(String string, String message) {
        if (string.isEmpty() || string.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }

    private void checkForNullValue(String string, String message) {
        if (string == null) {
            throw new IllegalArgumentException(message);
        }
    }
}
