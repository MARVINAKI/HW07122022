package Other;

import java.util.HashSet;
import java.util.Set;

public class ListOfPassport
        <P extends Passport> {
    private final Set<Passport> listOfPass = new HashSet<>();

    public void addToList(P passport) throws DoubleProductException {
        for (Passport passports : listOfPass) {
            if (passport.getPassNumber() == passports.getPassNumber()) {
                throw new DoubleProductException();
            }
        }
        listOfPass.add(passport);
    }

    public void findPass(String passNumber) {
        for (Passport passports : listOfPass) {
            if (passNumber.trim().replace(" ","").equalsIgnoreCase(passports.getPassNumber())) {
                System.out.println(passports);
            }
        }
    }

    @Override
    public String toString() {
        return "ListOfPassport{" +
                "listOfPass=" + listOfPass +
                '}';
    }
}
