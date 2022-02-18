import java.util.Arrays;
import java.util.List;

public class Car {

    // make, which stores the make of this Car. Make this public.
    // color, which stores the color of this Car. Make this public.
    // licensePlate, which stores the license plate of this Car. Make this public.
    // owners, which stores an array of Owners of this Car. Make this public.
    public String make;
    public String color;
    public String licensePlate;
    public Owner[] owners;

    public Car(String make, String color, String licensePlate, Integer numOwners) {
        this.make = make;
        this.color = color;
        this.licensePlate = licensePlate;
        this.owners = new Owner[numOwners];
    }

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLicensePlate() {
        return this.licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Owner[] getOwners() {
        return this.owners;
    }

    public void setOwners(Owner[] owners) {
        this.owners = owners;
    }

    public Car make(String make) {
        setMake(make);
        return this;
    }

    public Car color(String color) {
        setColor(color);
        return this;
    }

    public Car licensePlate(String licensePlate) {
        setLicensePlate(licensePlate);
        return this;
    }

    // This method returns true if there is at least 1 adult owner of this Car. An
    // adult owner is someone who is at least 18 years old (including 18).

    public boolean hasAdultOwner() {
        for (Owner owner : owners) {
            if (owner.age >= 18) {
                return true;
            }
        }
        return false;
    }

    // This method takes an Owner as parameter, and adds owner to the current list
    // of Owners of this Car.

    // You may only add a teenage owner to the Car if there is at least 1 adult
    // owner. You may not add any owner that is under 15.

    // If the owner is less than 15 years old (excluding 15), print "You are not
    // eligible to own a car."

    // If the car currently has no adult owner and you are trying to add a teenage
    // owner, print "You can only add a teenage driver if there is an adult owner on
    // file."

    // If the owners array is full, do nothing.

    // Otherwise, add the owner to the owners array.
    public void addOwner(Owner owner) {
        if (owner.getAge() < 15) {
            System.out.println("You are not eligible to own a car.");
            return;
        }
        boolean anyOfAgeOwners = getAnyOfAgeOwners();
        if (owner.getAge() < 18 && !anyOfAgeOwners) {
            System.out.println("You can only add a teenage driver if there is an adult owner on file.");
            return;
        }

        for (int i = 0; i < owners.length; i++) {
            if (owners[i] == null) {
                owners[i] = owner;
                return;
            }
        }

    }

    private boolean getAnyOfAgeOwners() {
        for (Owner currentOwner : owners) {
            if (currentOwner != null && currentOwner.getAge() >= 18) {
                return true;
            }
        }
        return false;

    }

    // This method returns a formatted String.
    // Here is an example:
    // Toyota (ABCE718) : [Cindy, Betty, Elijah*]
    @Override
    public String toString() {
        return String.format("%s (%s) : %s", this.getMake(), this.getLicensePlate(), Arrays.toString(this.getOwners()));
    }

}
