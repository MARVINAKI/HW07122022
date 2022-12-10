package Transport.Car;


import Human.Driver;
import Human.Mechanic;
import Human.MyException.WrongSumException;
import Human.Sponsor;
import Transport.Car.Enums.BodyTypePass;
import Transport.Car.Enums.CarType;
import Transport.Car.Enums.LoadCapacity;
import Transport.Car.Enums.PassCapacity;
import Transport.Car.Methods.Competing;
import Transport.Transport;

import java.util.ArrayList;
import java.util.Objects;

public class Car
        <M extends Mechanic>
        extends Transport
        implements Competing {
    private CarType carType;
    private BodyTypePass bodyTypePass;
    private LoadCapacity loadCapacity;
    private PassCapacity passCapacity;
    private boolean statusCarDiag;
    private int prizeMoney;
    private Driver driver;
    private ArrayList<Sponsor> sponsors;
    private ArrayList<Mechanic> mechanics;

    public Car(String brand, String model, double engineVolume, CarType carType, BodyTypePass bodyTypePass) {
        super(brand, model, engineVolume);
        this.carType = carType;
        if (carType == CarType.PASS) {
            this.bodyTypePass = bodyTypePass;
        }
        this.prizeMoney = 0;
        this.statusCarDiag = false;
        this.sponsors = new ArrayList<>();
        this.mechanics = new ArrayList<>();
    }

    public Car(String brand, String model, double engineVolume, CarType carType, LoadCapacity loadCapacity) {
        super(brand, model, engineVolume);
        this.carType = carType;
        if (carType == CarType.TRUCK) {
            this.loadCapacity = loadCapacity;
        }
        this.prizeMoney = 0;
        this.statusCarDiag = false;
        this.sponsors = new ArrayList<>();
        this.mechanics = new ArrayList<>();
    }

    public Car(String brand, String model, double engineVolume, CarType carType, PassCapacity passCapacity) {
        super(brand, model, engineVolume);
        this.carType = carType;
        if (carType == CarType.BUS) {
            this.passCapacity = passCapacity;
        }
        this.prizeMoney = 0;
        this.statusCarDiag = false;
        this.sponsors = new ArrayList<>();
        this.mechanics = new ArrayList<>();
    }

    @Override
    public void doCarDiag() {
        if (getCarType() == CarType.BUS) {
            System.out.println(carType.getCarType() + " проходить диагностику не может");
        } else if (mechanics.size() == 0) {
            System.out.println("У вас нет механика");
        } else {
            for (Mechanic mechanic : mechanics) {
                for (CarType type : mechanic.getCarType()) {
                    if (type.equals(carType)) {
                        System.out.println("Диагностика автомобиля " + getBrand());
                        this.statusCarDiag = true;
                        return;
                    }

                }

            }
            System.out.println("У Вас нет механика для вашего автомобиля");
        }
    }

    @Override
    public final void printType() {
        System.out.println(getBrand() + " " + getCarType());
    }

    @Override
    public final void startMoving() {
        System.out.println(getBrand() + " начало движения");
    }

    @Override
    public final void stopMoving() {
        System.out.println(getBrand() + " остановка");
    }

    @Override
    public final void refill() {

    }

    @Override
    public final void pitStop() {
        System.out.println(getBrand() + " пит-стоп");
    }

    @Override
    public final void bestTimeOfLap() {
        System.out.println(getBrand() + " лучшее время круга");
    }

    @Override
    public final void maxSpeed() {
        System.out.println(getBrand() + " максимальная скорость");
    }

    public final CarType getCarType() {
        return carType;
    }

    public final void setCarType(CarType carType) {
        if (getCarType() == null) {
            this.carType = carType;
        }
    }

    public final BodyTypePass getBodyTypePass() {
        return bodyTypePass;
    }

    public final void setBodyTypePass(BodyTypePass bodyTypePass) {
        if (getBodyTypePass() == null) {
            this.bodyTypePass = bodyTypePass;
        }
    }

    public final LoadCapacity getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(LoadCapacity loadCapacity) {
        if (getLoadCapacity() == null) {
            this.loadCapacity = loadCapacity;
        }
    }

    public PassCapacity getPassCapacity() {
        return passCapacity;
    }

    public void setPassCapacity(PassCapacity passCapacity) {
        if (getPassCapacity() == null) {
            this.passCapacity = passCapacity;
        }
    }

    public final boolean isStatusCarDiag() {
        return statusCarDiag;
    }

    public final int getPrizeMoney() {
        return prizeMoney;
    }

    public final void setPrizeMoney(int prizeMoney) {
        if (prizeMoney > 0) {
            this.prizeMoney += prizeMoney;
        } else {
            throw new IllegalArgumentException("Некорректная сумма");
        }
    }

    public final Driver getDriver() {
        return driver;
    }

    public final void setDriver(Driver driver) {
        this.driver = driver;
    }

    public final ArrayList<Sponsor> getSponsors() {
        return sponsors;
    }

    public final void setSponsors(Sponsor sponsor) {
        this.sponsors.add(sponsor);
    }

    public final ArrayList<Mechanic> getMechanics() {
        return mechanics;
    }

    public final void setMechanics(Mechanic mechanic) {
        this.mechanics.add(mechanic);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car<?> car = (Car<?>) o;
        return statusCarDiag == car.statusCarDiag && prizeMoney == car.prizeMoney && carType == car.carType && bodyTypePass == car.bodyTypePass && loadCapacity == car.loadCapacity && passCapacity == car.passCapacity && driver.equals(car.driver) && sponsors.equals(car.sponsors) && mechanics.equals(car.mechanics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), carType, bodyTypePass, loadCapacity, passCapacity, statusCarDiag, prizeMoney, driver, sponsors, mechanics);
    }

    @Override
    public String toString() {
        return super.toString() + ", " + carType + ", " +
                (getCarType() == CarType.PASS ? bodyTypePass
                        : getCarType() == CarType.TRUCK ? loadCapacity
                        : getCarType() == CarType.BUS ? passCapacity : "") +
                ", " + driver + ", " + sponsors + ", " + mechanics +
                "}" + "\n";
    }
}
