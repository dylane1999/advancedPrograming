import java.text.DecimalFormat;
import java.util.Arrays;

public class ElectricCar extends Car {

    public Double batteryLevel;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Double getBatteryLevel() {
        return this.batteryLevel;
    }

    public void setBatteryLevel(Double batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    @Override
    public String toString() {
        return String.format("[EV - %s] %s (%s) : %s", df.format(this.getBatteryLevel()), this.getMake(),
                this.getLicensePlate(), Arrays.toString(this.getOwners()));
    }

    public ElectricCar(String make, String color, String licensePlate, Integer numOwners) {
        super(make, color, licensePlate, numOwners);
        this.batteryLevel = 100.00;
    }

}
