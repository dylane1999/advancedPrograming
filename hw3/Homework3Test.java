import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Homework3Test {

  public static void test_order_toString_dinein(){
        boolean isTakeout = false;
        String server = "Abby";
        Integer numGuests = 5;
        Integer numItems = 4;
        Order order = new Order(server, numGuests, isTakeout, numItems);
        // add items to order
        Food hamburger = new Food("Hamburger", 9.99, 500, false, 0);
        Food chickenCurry = new Food("Chicken Curry", 12.99, 500, false, 3);
        Drink coke = new Drink("Coke", 1.99, 150, false);
        Drink gnt = new Drink("Gin Tonic", 12.99, 150, true);
        order.addItem(hamburger);
        order.addItem(chickenCurry);
        order.addItem(coke);
        order.addItem(gnt);
        String expectedString = """
        No. of Guests: 5
        Server: Abby
        Dine-in
        
        Item	       Price
        (F)Hamburger         $9.99
        (F)Chicken Curry         $12.99
        (D)Coke         $1.99
        (D)Gin Tonic         $12.99
        
        Subtotal         $37.96
        Tip          $5.69
        Total Due            $43.65""";

        String actualString = order.toString();
        assertEquals(expectedString, actualString);
    }



    public static void test_order_toString_nonFoodOrDrinkItem() {
        boolean isTakeout = false;
        String server = "Abby";
        Integer numGuests = 5;
        Integer numItems = 4;
        Order order = new Order(server, numGuests, isTakeout, numItems);
        // add items to order
        Drink coke = new Drink("Coke", 1.99, 150, false);
        Item bday = new Item("Birthday Song", 100, 0);
        order.addItem(coke);
        order.addItem(bday);
        String expectedString = """
        No. of Guests: 5
        Server: Abby
        Dine-in
        
        Item	       Price
        (D)Coke         $1.99
        Birthday Song         $100.00
        
        Subtotal         $101.99
        Tip          $15.30
        Total Due            $117.29""";

        String actualString = order.toString();
        assertEquals(expectedString, actualString);
    }

    public static void test_order_toString_takeout() {
        boolean isTakeout = true;
        String server = "Abby";
        Integer numGuests = 5;
        Integer numItems = 4;
        Order order = new Order(server, numGuests, isTakeout, numItems);
        // add items to order
        Food hamburger = new Food("Hamburger", 9.99, 500, false, 0);
        Food chickenCurry = new Food("Chicken Curry", 12.99, 500, false, 3);
        Drink coke = new Drink("Coke", 1.99, 150, false);
        Drink gnt = new Drink("Gin Tonic", 12.99, 150, true);
        order.addItem(hamburger);
        order.addItem(chickenCurry);
        order.addItem(coke);
        order.addItem(gnt);
        String expectedString = """
        No. of Guests: 5
        Server: Abby
        Take-out
        
        Item	       Price
        (F)Hamburger         $9.99
        (F)Chicken Curry         $12.99
        (D)Coke         $1.99
        (D)Gin Tonic         $12.99
        
        Subtotal         $37.96
        Total Due            $37.96""";

        String actualString = order.toString();
        assertEquals(expectedString, actualString);
    }

    // Order addItem
    public static void test_order_addItem_successfulAdd() {
        boolean isTakeout = true;
        String server = "Abby";
        Integer numGuests = 5;
        Integer numItems = 4;
        Order order = new Order(server, numGuests, isTakeout, numItems);
        // add items to order
        Food hamburger = new Food("Hamburger", 9.99, 500, false, 0);
        boolean wasAdded = order.addItem(hamburger);
        assertTrue(wasAdded);
        assertEquals(hamburger, order.getOrderList()[0]);
    }

    public static void test_order_addItem_fullList() {
        boolean isTakeout = true;
        String server = "Abby";
        Integer numGuests = 5;
        Integer numItems = 4;
        Order order = new Order(server, numGuests, isTakeout, numItems);
        // add items to order
        Food hamburger = new Food("Hamburger", 9.99, 500, false, 0);
        Food chickenCurry = new Food("Chicken Curry", 12.99, 500, false, 3);
        Drink coke = new Drink("Coke", 1.99, 150, false);
        Drink gnt = new Drink("Gin Tonic", 12.99, 150, true);
        order.addItem(hamburger);
        order.addItem(chickenCurry);
        order.addItem(coke);
        order.addItem(gnt);
        boolean wasAdded = order.addItem(hamburger);
        assertFalse(wasAdded);
        }

    // Order remove item

    public static void test_order_removeItem_successfulRemoval() {
        boolean isTakeout = true;
        String server = "Abby";
        Integer numGuests = 5;
        Integer numItems = 4;
        Order order = new Order(server, numGuests, isTakeout, numItems);
        // add items to order
        Food hamburger = new Food("Hamburger", 9.99, 500, false, 0);
        boolean wasAdded = order.addItem(hamburger);
        assertTrue(wasAdded);
        boolean wasRemoved = order.removeItem(hamburger);
        assertTrue(wasRemoved);
        assertEquals(null, order.getOrderList()[0]);
    }

    public static void test_order_removeItem_itemNotFound() {
        boolean isTakeout = true;
        String server = "Abby";
        Integer numGuests = 5;
        Integer numItems = 4;
        Order order = new Order(server, numGuests, isTakeout, numItems);
        // add items to order
        Food hamburger = new Food("Hamburger", 9.99, 500, false, 0);
        boolean wasRemoved = order.removeItem(hamburger);
        assertFalse(wasRemoved);
    }

    public static void test_order_printWeightWatcherItems_noItems() {
        boolean isTakeout = true;
        String server = "Abby";
        Integer numGuests = 5;
        Integer numItems = 4;
        Order order = new Order(server, numGuests, isTakeout, numItems);
        // add items to order
        Food hamburger = new Food("Hamburger", 9.99, 5700, false, 0);
        Food chickenCurry = new Food("Chicken Curry", 12.99, 700, false, 3);
        Drink coke = new Drink("Coke", 1.99, 1750, false);
        Drink gnt = new Drink("Gin Tonic", 12.99, 1750, true);
        order.addItem(hamburger);
        order.addItem(chickenCurry);
        order.addItem(coke);
        order.addItem(gnt);
        String expectedWeightWatchers = "Items with calories 500 or below:\n";
        String weightWatchers = order.printWeightWatcherItems();
        assertEquals(expectedWeightWatchers, weightWatchers);

    }

    public static void test_order_printWeightWatcherItems_successfulPrint() {
        boolean isTakeout = true;
        String server = "Abby";
        Integer numGuests = 5;
        Integer numItems = 4;
        Order order = new Order(server, numGuests, isTakeout, numItems);
        // add items to order
        Food hamburger = new Food("Hamburger", 9.99, 5700, false, 0);
        Food chickenCurry = new Food("Chicken Curry", 12.99, 10, false, 3);
        Drink coke = new Drink("Coke", 1.99, 1750, false);
        Drink gnt = new Drink("Gin Tonic", 12.99, 10, true);
        order.addItem(hamburger);
        order.addItem(chickenCurry);
        order.addItem(coke);
        order.addItem(gnt);
        String expectedWeightWatchers   ="""
        Items with calories 500 or below:
                Chicken Curry
                Gin Tonic\n""";
        String weightWatchers = order.printWeightWatcherItems();
        assertEquals(expectedWeightWatchers, weightWatchers);
    }



    public static void main(String[] args) {
        test_order_toString_dinein();
        test_order_toString_nonFoodOrDrinkItem();
        test_order_toString_takeout();
        test_order_addItem_successfulAdd();
        test_order_removeItem_successfulRemoval();
        test_order_addItem_fullList();
        test_order_printWeightWatcherItems_noItems();
        test_order_printWeightWatcherItems_successfulPrint();
        System.out.println("----- TESTS COMPLETE -----");

    }
    

}
