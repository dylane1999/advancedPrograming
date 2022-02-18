import java.util.Objects;

public class Owner {

    public String name;
    public Integer age;
    private String license;

    // public String getLicense()

    // This method returns the last four digits of this Owner’s license. You may
    // assume that licenses always have at least four digits.

    // public void setLicense(String license)

    // This method takes a String license and sets it to this Owner’s license.

    // public String toString()

    // // This method returns a formatted String. If the Owner’s age is less than 15
    // (excluding 15), return this String “You are not eligible to own a car.” If
    // this Owner’s age is between 15 to 18 (including 15, excluding 18), return the
    // name of this Owner with a * after the name. If this Owner’s age is over 18
    // (including 18), return the name of this Owner.

    public Owner(String name, Integer age, String license) {
        this.name = name;
        this.age = age;
        this.license = license;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLicense() {
        return this.license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Owner name(String name) {
        setName(name);
        return this;
    }

    public Owner age(Integer age) {
        setAge(age);
        return this;
    }

    public Owner license(String license) {
        setLicense(license);
        return this;
    }

    // This method returns a formatted String. If the Owner’s age is less than 15
    // (excluding 15), return this String “You are not eligible to own a car.” If
    // this Owner’s age is between 15 to 18 (including 15, excluding 18), return the
    // name of this Owner with a * after the name. If this Owner’s age is over 18
    // (including 18), return the name of this Owner.
    @Override
    public String toString() {
        if (this.getAge() < 15) {
            return "You are not eligible to own a car.";
        } else if (this.getAge() < 18) {
            return this.getName() + "*";

        }
        return getName();
    }

}
