package Wlasne;

public class Mechanik {
    private String imie;
    private String nazwisko;
    private Enum<ExpirenceLevel> expirenceLevel;
    private int yearsOfExperience;
    private int numberOfCompletedRepairs;

    public Mechanik(String imie, String nazwisko, Enum<ExpirenceLevel> expirenceLevel, int yearsOfExperience) {
        setImie(imie);
        setNazwisko(nazwisko);
        setYearsOfExperience(yearsOfExperience);
        setExpirenceLevel(expirenceLevel);
    }
    public String getImie() {
        return imie;
    }
    public void setImie(String imie) {
        if (imie == null){
            throw new IllegalArgumentException("Imie cannot be null");
        }
        if (imie.isBlank()){
            throw new IllegalArgumentException("Imie cannot be empty or blank");
        }
        this.imie = imie;
    }
    public String getNazwisko() {
        return nazwisko;
    }
    public void setNazwisko(String nazwisko) {
        if (nazwisko == null){
            throw new IllegalArgumentException("Nazwisko cannot be null");
        }
        if (nazwisko.isBlank()){
            throw new IllegalArgumentException("Nazwisko cannot be empty or blank");
        }
        this.nazwisko = nazwisko;
    }
    public Enum<ExpirenceLevel> getExpirenceLevel() {
        return expirenceLevel;
    }
    public void setExpirenceLevel(Enum<ExpirenceLevel> expirenceLevel) {
        if (expirenceLevel == null) {
            throw new IllegalArgumentException("Expirence level cannot be null");
        }
        switch (expirenceLevel){
            case ExpirenceLevel.Junior:
                if (yearsOfExperience < -1 || yearsOfExperience > 2) {
                    throw new IllegalArgumentException("Years of experience for Junior level must be below 2");
                }
                break;
            case ExpirenceLevel.Mid:
                if (yearsOfExperience < 2 || yearsOfExperience > 5) {
                    throw new IllegalArgumentException("Years of experience for Mid level must be between 2 and 5");
                }
                if (numberOfCompletedRepairs < 20) {
                    throw new IllegalArgumentException("Number of completed repairs for Mid level must be at least 20");
                }
                break;
            case ExpirenceLevel.Senior:
                if (yearsOfExperience < 6) {
                    throw new IllegalArgumentException("Years of experience for Senior level must be at least 5");
                }
                if (numberOfCompletedRepairs < 60) {
                    throw new IllegalArgumentException("Number of completed repairs for Senior level must be at least 50");
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + expirenceLevel);
        }
    }
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
    public void setYearsOfExperience(int yearsOfExperience) {
        if (yearsOfExperience < 0) {
            throw new IllegalArgumentException("Years of experience cannot be negative");
        }
        this.yearsOfExperience = yearsOfExperience;
    }
    public int getNumberOfCompletedRepairs() {
        return numberOfCompletedRepairs;
    }
    public void setNumberOfCompletedRepairs(int numberOfCompletedRepairs) {
        if (numberOfCompletedRepairs < 0) {
            throw new IllegalArgumentException("Number of completed repairs cannot be negative");
        }
        this.numberOfCompletedRepairs = numberOfCompletedRepairs;
    }

}
