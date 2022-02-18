
public class ParkingLot {

    public String address;
    public Car[] cars;

    public ParkingLot() {
    }

    public ParkingLot(String address, Integer numCars) {
        this.address = address;
        this.cars = new Car[numCars];
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Car[] getCars() {
        return this.cars;
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }

    // This method takes a Car car as its parameter and adds the car to cars.
    // The first 1/3 spots are reserved for only electric cars; the rest of the
    // spots can be parked by any type of car. If this parking lot is full, do
    // nothing.
    // Return true if the car is correctly added to cars. Otherwise, return false
    // (e.g. if the parking lot is full and the car is not added).
    public boolean park(Car car) {
        if (car instanceof ElectricCar) {
            // place in first 1/3 if possible by starting from 0
            for (int i = 0; i < cars.length; i++) {
                if (cars[i] == null) {
                    cars[i] = car;
                    return true;
                }
            }
        }
        // start after 1/3
        Integer startIndex = cars.length / 3;
        for (int i = startIndex; i < cars.length; i++) {
            if (cars[i] == null) {
                cars[i] = car;
                return true;
            }
        }
        return false;
    }

    // This method takes a String licensePlate as its parameter and removes the Car
    // with the same licensePlate from cars if it exists in cars. If the array cars
    // does not contain a Car with the same licensePlate, print “Do not have the
    // car.” If the Car is an electric car, print “Your parking fee is $5.” If the
    // Car is a regular Car, print “Your parking fee is $15.”
    // Assumption: by removing, you can simply set that element to null in the cars
    // array. You are not required to shift the remainder of the array forward by
    // one spot.
    public void leave(String licensePlate) {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null && cars[i].getLicensePlate().equals(licensePlate)) {
                if (cars[i] instanceof ElectricCar) {
                    System.out.println("Your parking fee is $5.");
                } else {
                    System.out.println("Your parking fee is $15.");
                }
                cars[i] = null;
                return;
            }
        }
        System.out.println("Do not have the car.");

    }

    // This method returns the total number of cars that are currently parked in
    // this parking lot.
    public int totalCars() {
        int numCars = 0;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) {
                numCars++;
            }
        }
        return numCars;
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        int numCars = totalCars();
        strBuilder.append(String.format("Parking lot at %s has %d cars and %d available spots.\n", this.getAddress(),
                numCars, cars.length - numCars));
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) {
                strBuilder.append(String.format("Spot %d: %s\n", i+1, cars[i].getLicensePlate()));
            } else {
                strBuilder.append(String.format("Spot %d: Empty\n", i+1));
            }
        }
        return strBuilder.toString();
    }

}