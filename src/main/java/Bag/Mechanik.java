package Bag;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Mechanik {
    private String specialization;
    private String name;
    private String surname;
    private Set<Employment> employments = new HashSet<>();

    public Mechanik(String specialization, String name, String surname) {
        setSpecialization(specialization);
        setName(name);
        setSurname(surname);
    }

    public Set<Employment> getEmployments() {
        return Collections.unmodifiableSet(employments);
    }

    public Employment addEmployment(Employment employment) {
        if (employment == null) {
            throw new IllegalArgumentException("Employment nie może być null.");
        }
        if (employments.contains(employment)) {
            throw new IllegalArgumentException("Employment already exists for this mechanic");
        }
        employments.add(employment);
        return employment;
    }

    public void removeEmployment(Employment employment) {
        employments.remove(employment);
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        checkForNullValue(specialization, "Specialization cannot be null");
        checkStringForEmptyAndBlank(specialization, "Specialization cannot be empty or blank");
        this.specialization = specialization;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Mechanik that = (Mechanik) o;
        return Objects.equals(specialization, that.specialization)
                && Objects.equals(name, that.name)
                && Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specialization, name, surname);
    }

    @Override
    public String toString() {
        return "Mechanic{" +
                "specialization='" + specialization + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
