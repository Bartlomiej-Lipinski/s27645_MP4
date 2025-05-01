package Bag;

import java.util.*;

public class Warsztat {
    private String place;
    private Set<Employment> employments = new HashSet<>();

    public Warsztat(String place) {
        setPlace(place);
    }

    public Employment addEmployment(Employment employment) {
        if (employment == null) {
            throw new IllegalArgumentException("Employment cannot be null");
        }
        if (employments.contains(employment)){
            throw new IllegalArgumentException("Employment already exists in this car repair shop");
        }
        employments.add(employment);
        return employment;
    }

    public void removeEmployment(Employment employment) {
        if (employment == null) {
            throw new IllegalArgumentException("Employment cannot be null");
        }
        employments.remove(employment);
    }

    public void removeCarRepairShop() {
        Set<Employment> temp = new HashSet<>(employments);
        for (Employment employment : temp) {
            employment.removeEmployment();
        }
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        checkForNullValue(place, "Place is null");
        checkStringForEmptyAndBlank(place, "Place is empty or contains only spaces");
        this.place = place;
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
        if (this == o) return true;
        if (!(o instanceof Warsztat)) return false;
        Warsztat carRepairShop = (Warsztat) o;
        return Objects.equals(place, carRepairShop.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(place);
    }

    @Override
    public String toString() {
        return "CarRepairShop{" +
                "place='" + place + '\'' +
                ", employments=" + employments +
                '}';
    }
    public Set<Employment> getEmployments() {
        return employments;
    }
}
