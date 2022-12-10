package Human.ListOfHuman;

import Human.Mechanic;
import Human.MyException.DoubleNameException;
import Human.Sponsor;

import java.util.ArrayList;

public class ListOfMechanic {
    private ArrayList<Mechanic> listOfMechanic = new ArrayList<>();

    public void addToList(Mechanic mechanic) throws DoubleNameException {
        for (Mechanic mechanics : listOfMechanic) {
            if (mechanic.getName().equals(mechanics.getName())) {
                throw new DoubleNameException();
            }
        }
        this.listOfMechanic.add(mechanic);
    }

    public final ArrayList<Mechanic> getListOfMechanic() {
        return listOfMechanic;
    }

    @Override
    public String toString() {
        return "Список механиков " + listOfMechanic;
    }
}
