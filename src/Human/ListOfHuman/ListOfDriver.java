package Human.ListOfHuman;

import Human.Driver;
import Human.MyException.DoubleNameException;
import Human.Sponsor;
import Transport.Car.Car;

import java.util.ArrayList;

public class ListOfDriver {
    private ArrayList<Driver> listOfDriver = new ArrayList<>();

    public void addToList(Driver driver) throws DoubleNameException {
        for (Driver drivers : listOfDriver) {
            if (driver.getName().equals(drivers.getName())) {
                throw new DoubleNameException();
            }
        }
        this.listOfDriver.add(driver);
    }

    public ArrayList<Driver> getListOfDriver() {
        return listOfDriver;
    }

    @Override
    public String toString() {
        return "Список водителей " + listOfDriver;
    }
}
