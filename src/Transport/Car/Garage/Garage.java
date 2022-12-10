package Transport.Car.Garage;

import Transport.Car.Car;
import Transport.Car.Enums.CarType;
import Transport.Car.MyException.NotDiagException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Garage {
    private Set<Car> listOfCar = new HashSet<>();

    public void addToGarage(Car car) {
        this.listOfCar.add(car);
    }

    public void checkCarDiag() {
        for (Car car : listOfCar) {
            if (car.getCarType() == CarType.BUS) {
                System.out.println("Автобус " + car.getBrand() + " " + car.getModel() + " в диагностике не требуется");
            } else if (car.isStatusCarDiag()) {
                System.out.print(car.getBrand() + " " + car.getModel() + ": ");
                System.out.println("Диагностика пройдена");
            } else {
                System.out.print(car.getBrand() + " " + car.getModel() + ": ");
                System.out.println("Диагностика не пройдена, к заезду не допускается");
                System.out.println("Чтобы бы пройти ТО, обратитесь к механику");
            }
        }
    }

    public final Set<Car> getListOfCar() {
        return listOfCar;
    }


    @Override
    public String toString() {
        return "Гараж(список машин)" + listOfCar;
    }
}
