package Human.ListOfHuman;

import Human.MyException.DoubleNameException;
import Human.Sponsor;
import Other.DoubleProductException;

import java.util.ArrayList;

public class ListOfSponsor {
    private ArrayList<Sponsor> listOfSponsor = new ArrayList<>();

    public void addToList(Sponsor sponsor) throws DoubleNameException {
        for (Sponsor sponsors : listOfSponsor) {
            if (sponsor.getName().equals(sponsors.getName())) {
                throw new DoubleNameException();
            }
        }
        this.listOfSponsor.add(sponsor);
    }

    public final ArrayList<Sponsor> getListOfSponsor() {
        return listOfSponsor;
    }

    @Override
    public String toString() {
        return "Список спонсоров " + listOfSponsor;
    }
}
