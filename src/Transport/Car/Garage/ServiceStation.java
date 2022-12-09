package Transport.Car.Garage;

import Transport.Car.Car;
import Transport.Car.Enums.CarType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ServiceStation
        <C extends Car> {
    private Queue<C> queueOfCar = new LinkedList<>();

    public void addToQueue(C... car) {
        for (int c = 0; c < car.length; c++) {
            if (car[c].getCarType() != CarType.BUS && car[c].getCarType() != null) {
                queueOfCar.offer(car[c]);
            }
        }
    }

    public void doCarDiag(C car) {
        for (C cars : queueOfCar) {
            cars.doCarDiag();
            if (cars.isStatusCarDiag()) {
                queueOfCar.remove();
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "ServiceStation{" +
                "queueOfCar=" + queueOfCar + "\n" +
                '}';
    }
}
