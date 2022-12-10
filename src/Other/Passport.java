package Other;

import java.util.Objects;

public class Passport {
    private String passNumber;
    private String surname;
    private String name;
    private String patronymic;
    private int dataOfBirth;

    public Passport(String passNumber, String surname, String name, int dataOfBirth) {
        setPassNumber(passNumber);
        setSurname(surname);
        setName(name);
        setDataOfBirth(dataOfBirth);
    }

    public Passport(String passNumber, String surname, String name, String patronymic, int dataOfBirth) {
        setPassNumber(passNumber);
        setSurname(surname);
        setName(name);
        setPatronymic(patronymic);
        setDataOfBirth(dataOfBirth);
    }

    private void setPassNumber(String passNumber) {
        if (passNumber == null || passNumber.trim().replace(" ", "").isEmpty()) {
            throw new NullPointerException();
        }
        this.passNumber = passNumber;
    }

    private void setSurname(String surname) {
        if (passNumber == null || passNumber.trim().replace(" ", "").isEmpty()) {
            throw new NullPointerException();
        }
        this.surname = surname;
    }

    private void setName(String name) {
        if (passNumber == null || passNumber.trim().replace(" ", "").isEmpty()) {
            throw new NullPointerException();
        }
        this.name = name;
    }

    private void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    private void setDataOfBirth(int dataOfBirth) {
        if (String.valueOf(dataOfBirth).length() != 8) {
            throw new IllegalArgumentException();
        }
        this.dataOfBirth = Math.abs(dataOfBirth);
    }

    protected final String getPassNumber() {
        return passNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return dataOfBirth == passport.dataOfBirth && passNumber.equals(passport.passNumber) && surname.equals(passport.surname) && name.equals(passport.name) && patronymic.equals(passport.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passNumber, surname, name, patronymic, dataOfBirth);
    }

    @Override
    public String toString() {
        return "Passport{" +
                "passNumber='" + passNumber + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dataOfBirth=" + dataOfBirth +
                '}';
    }
}
