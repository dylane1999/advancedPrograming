import static org.junit.jupiter.api.Assertions.assertEquals;

public class HW4Test {

    public static void test_owner_underageOwner() {
        Owner underageOwner = new Owner("dan", 4, "uadhfi3");
        String expected = "You are not eligible to own a car.";
        String actual = underageOwner.toString();
        assertEquals(expected, actual);
    }

    public static void test_owner_teenPermitOwner() {
        Owner underageOwner = new Owner("dan", 17, "uadhfi3");
        String expected = "dan*";
        String actual = underageOwner.toString();
        assertEquals(expected, actual);
    }

    public static void test_owner_validOwner() {
        Owner owner = new Owner("dan", 44, "uadhfi3");
        String expected = "dan";
        String actual = owner.toString();
        assertEquals(expected, actual);
    }

    public static void test_car_validOwnerWithTeen() {
        Owner cindy = new Owner("Cindy", 44, "uadhfi3");
        Owner betty = new Owner("Betty", 44, "uadhfi3");
        Owner elijah = new Owner("Elijah", 16, "uadhfi3");
        Car car = new Car("Toyota", "color", "ABCE718", 3);
        car.addOwner(cindy);
        car.addOwner(betty);
        car.addOwner(elijah);
        String expected = "Toyota (ABCE718) : [Cindy, Betty, Elijah*]";
        String actual = car.toString();
        assertEquals(expected, actual);
    }

    public static void test_car_invalidTeen() {
        Owner elijah = new Owner("Elijah", 16, "uadhfi3");
        Car car = new Car("Toyota", "color", "ABCE718", 3);
        car.addOwner(elijah);
        String expected = "Toyota (ABCE718) : [null, null, null]";
        String actual = car.toString();
        assertEquals(expected, actual);
    }

    public static void test_car_noneToAdd() {
        Owner cindy = new Owner("Cindy", 44, "uadhfi3");
        Owner betty = new Owner("Betty", 44, "uadhfi3");
        Car car = new Car("Toyota", "color", "ABCE718", 1);
        car.addOwner(cindy);
        car.addOwner(betty);
        String expected = "Toyota (ABCE718) : [Cindy]";
        String actual = car.toString();
        assertEquals(expected, actual);
    }

    public static void test_car_tooYoung() {
        Owner cindy = new Owner("Cindy", 4, "uadhfi3");
        Car car = new Car("Toyota", "color", "ABCE718", 1);
        car.addOwner(cindy);
        String expected = "Toyota (ABCE718) : [null]";
        String actual = car.toString();
        assertEquals(expected, actual);
    }

    public static void test_electric_car_validOwnerWithTeen() {
        Owner cindy = new Owner("Cindy", 44, "uadhfi3");
        Owner betty = new Owner("Betty", 44, "uadhfi3");
        Owner elijah = new Owner("Elijah", 16, "uadhfi3");
        Car car = new ElectricCar("Toyota", "color", "ABCE718", 3);
        car.addOwner(cindy);
        car.addOwner(betty);
        car.addOwner(elijah);
        String expected = "[EV - 100.00] Toyota (ABCE718) : [Cindy, Betty, Elijah*]";
        String actual = car.toString();
        assertEquals(expected, actual);
    }

    public static void test_parkingLot_totalCars_noCars() {
        ParkingLot parkingLot = new ParkingLot("123 Bacon St.", 2);
        int actual = parkingLot.totalCars();
        assertEquals(0, actual);

    }

    public static void test_parkingLot_totalCars_cars() {
        Car car = new Car("Toyota", "color", "ABCE718", 1);
        Car ecar = new ElectricCar("Toyota", "color", "ABCE718", 3);
        ParkingLot parkingLot = new ParkingLot("123 Bacon St.", 2);
        parkingLot.park(car);
        parkingLot.park(ecar);
        int actual = parkingLot.totalCars();
        assertEquals(2, actual);
    }

    public static void test_parkingLot_toString_someEmptySpots() {
        Car car = new Car("Toyota", "color", "ABCE718", 1);
        ParkingLot parkingLot = new ParkingLot("123 Bacon St.", 2);
        parkingLot.park(car);
        String actual = parkingLot.toString();
        String expected = """
        Parking lot at 123 Bacon St. has 1 cars and 1 available spots.
        Spot 1: ABCE718
        Spot 2: Empty
        """;
        assertEquals(expected, actual);
    }

    public static void test_parkingLot_park_checkElectricPriority() {
        Car car = new Car("Toyota", "color", "ABCE718", 1);
        Car ecar = new ElectricCar("eToyota", "color", "BDHHKS4", 3);
        ParkingLot parkingLot = new ParkingLot("123 Bacon St.", 6);
        parkingLot.park(car);
        parkingLot.park(ecar);
        String actual = parkingLot.toString();
        String expected = """
        Parking lot at 123 Bacon St. has 2 cars and 4 available spots.
        Spot 1: BDHHKS4
        Spot 2: Empty
        Spot 3: ABCE718
        Spot 4: Empty
        Spot 5: Empty
        Spot 6: Empty
        """;
        assertEquals(expected, actual);
    }

    public static void test_parkingLot_park_checkNonElectricPushedBack() {
        Car car = new Car("Toyota", "color", "ABCE718", 1);
        ParkingLot parkingLot = new ParkingLot("123 Bacon St.", 6);
        parkingLot.park(car);
        String actual = parkingLot.toString();
        String expected = """
        Parking lot at 123 Bacon St. has 1 cars and 5 available spots.
        Spot 1: Empty
        Spot 2: Empty
        Spot 3: ABCE718
        Spot 4: Empty
        Spot 5: Empty
        Spot 6: Empty
        """;
        assertEquals(expected, actual);
    }

    public static void test_parkingLot_park_fullLot() {
        Car car = new Car("Toyota", "color", "ABCE718", 1);
        Car ecar = new ElectricCar("eToyota", "color", "BDHHKS4", 3);
        ParkingLot parkingLot = new ParkingLot("123 Bacon St.", 1);
        parkingLot.park(car);
        parkingLot.park(ecar);
        String actual = parkingLot.toString();
        String expected = """
        Parking lot at 123 Bacon St. has 1 cars and 0 available spots.
        Spot 1: ABCE718
        """;
        assertEquals(expected, actual);
    }

    public static void test_parkingLot_leave_noCar() {
        Car car = new Car("Toyota", "color", "ABCE718", 1);
        Car ecar = new ElectricCar("eToyota", "color", "BDHHKS4", 3);
        ParkingLot parkingLot = new ParkingLot("123 Bacon St.", 6);
        parkingLot.park(car);
        parkingLot.park(ecar);
        parkingLot.leave("UNKNOWN");
        String actual = parkingLot.toString();
        String expected = """
        Parking lot at 123 Bacon St. has 2 cars and 4 available spots.
        Spot 1: BDHHKS4
        Spot 2: Empty
        Spot 3: ABCE718
        Spot 4: Empty
        Spot 5: Empty
        Spot 6: Empty
        """;
        assertEquals(expected, actual);
    }

    public static void test_parkingLot_leave_manyCarsLeavingElectricAndNonElectric() {
        Car car = new Car("Toyota", "color", "ABCE718", 1);
        Car ecar = new ElectricCar("eToyota", "color", "BDHHKS4", 3);
        Car car2 = new Car("Toyota", "color", "FDFER$", 1);
        Car ecar2 = new ElectricCar("eToyota", "color", "HGKIGRGR", 3);
        ParkingLot parkingLot = new ParkingLot("123 Bacon St.", 6);
        parkingLot.park(car);
        parkingLot.park(ecar);
        parkingLot.park(car2);
        parkingLot.park(ecar2);
        parkingLot.leave("ABCE718");
        parkingLot.leave("BDHHKS4");
        parkingLot.leave("HGKIGRGR");
        parkingLot.leave("FDFER$");
        String actual = parkingLot.toString();
        String expected = """
        Parking lot at 123 Bacon St. has 0 cars and 6 available spots.
        Spot 1: Empty
        Spot 2: Empty
        Spot 3: Empty
        Spot 4: Empty
        Spot 5: Empty
        Spot 6: Empty
        """;
        assertEquals(expected, actual);
    }

    public static void main(String[] args) {
        test_owner_underageOwner();
        test_owner_teenPermitOwner();
        test_owner_validOwner();
        test_car_validOwnerWithTeen();
        test_car_invalidTeen();
        test_car_noneToAdd();
        test_car_tooYoung();
        test_electric_car_validOwnerWithTeen();
        test_parkingLot_totalCars_noCars();
        test_parkingLot_totalCars_cars();
        test_parkingLot_toString_someEmptySpots();
        test_parkingLot_park_checkElectricPriority();
        test_parkingLot_park_checkNonElectricPushedBack();
        test_parkingLot_park_fullLot();
        test_parkingLot_leave_noCar();
        test_parkingLot_leave_manyCarsLeavingElectricAndNonElectric();
        System.out.println("-----TESTS COMPLETE-----");

    }

}
