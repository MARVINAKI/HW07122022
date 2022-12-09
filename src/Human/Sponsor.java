package Human;


import Transport.Car.Car;

public class Sponsor
        <C extends Car>
        extends Human {
    private int suppAmount;

    public Sponsor(String name, int suppAmount) {
        super(name);
        setSuppAmount(suppAmount);
    }

    public final void doSponsorRace(int sum, C car) {
            if (sum < 0 || sum > getSuppAmount()) {
                throw new IllegalArgumentException("Некорректная сумма");
            }
        this.suppAmount = getSuppAmount() - sum;
        car.setPrizeMoney(sum);
        car.setSponsors(this);
    }

    private int getSuppAmount() {
        return suppAmount;
    }

    private void setSuppAmount(int suppAmount) {
        this.suppAmount = Math.abs(suppAmount);
    }

    @Override
    public String toString() {
        return "Sponsor" + super.toString() + '}';
    }
}
