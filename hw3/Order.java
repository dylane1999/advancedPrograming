import java.util.ArrayList;
import java.util.List;

public class Order {

    // server, which stores the name of the server
    // numOfGuests, which stores the number of guests in this Order
    // isTakeOut, which stores whether this Order is take out or dine in
    // orderList, which stores an array of Items in this Order

    // Here is an example of the server: “Abby”.
    // Here is an example of numOfGuests: 5
    // Here is an example of isTakeOut: true

    private String server;
    private Integer numOfGuests;
    private boolean isTakeOut;
    private Item[] orderList;

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public Integer getNumOfGuests() {
        return numOfGuests;
    }

    public void setNumOfGuests(Integer numOfGuests) {
        this.numOfGuests = numOfGuests;
    }

    public boolean getIsTakeout() {
        return this.isTakeOut;
    }

    public void setTakeOut(boolean isTakeOut) {
        this.isTakeOut = isTakeOut;
    }

    public Item[] getOrderList() {
        return orderList;
    }

    public void setOrderList(Item[] orderList) {
        this.orderList = orderList;
    }

    public Order(String server, Integer numOfGuests, boolean isTakeOut, Integer numItems) {
        setServer(server);
        setNumOfGuests(numOfGuests);
        setTakeOut(isTakeOut);
        this.orderList = new Item[numItems];
    }

    // This method takes an Item item as its parameter and adds the item to
    // orderList. Since orderList can only hold up to N items, your method can only
    // add to a not full orderList array. If the item is correctly added, return
    // true. Otherwise, return false.
    public boolean addItem(Item item) {
        for (int i = 0; i < orderList.length; i++) {
            if (orderList[i] == null) {
                orderList[i] = item;
                return true;
            }
        }
        return false;

    }

    // This method takes an Item item as its parameter and removes the item from
    // orderList if it exists in orderList. Only need to remove the first occurrence
    // of the item. If the item is correctly removed, return true. Otherwise, return
    // false.
    public boolean removeItem(Item item) {
        for (int i = 0; i < orderList.length; i++) {
            if (orderList[i].equals(item)) {
                orderList[i] = null;
                return true;
            }

        }
        return false;

    }

    // This method prints the items from the orderList that has a maximum of 500
    // calories (inclusive) in the following formatt:
    // Items with calories 500 or below:
    // Bread Basket
    // Coke
    // Hamburger
    // Manhattan
    public void printWeightWatcherItems() {
        String lowCalorieItems = "Items with calories 500 or below:\n";
        for (Item item : orderList) {
            if (item.getCalories() <= 500) {
                lowCalorieItems += String.format("       %s\n", item.getCalories());
            }
        }
        System.out.println(lowCalorieItems);
    }

    // This method splits the bill among the number of guests in this Order and
    // returns the amount owed per guest.
    public double splitBill() {
        return getTotalOwed() / getNumOfGuests();
    }

    private float getTotalOwed() {
        float totalOwed = 0;
        for (Item item : orderList) {
            totalOwed += item.getPrice();
        }
        return totalOwed;
    }

    // If this Order is a takeout, print “Take Out”. If this Order is not a take
    // out, print “Dine-in”.
    // If the item is a Food item, print (F) before the name. If the item is a Drink
    // item, print (D) before the name. If the item is neither a Food item nor a
    // Drink item, don’t add anything before the name.
    // If this Order is not a takeout order, add 15% of tip based on the subtotal.
    // No need to calculate taxes in this case. Otherwise, do not tip.
    @Override
    public String toString() {
        StringBuilder recipt = new StringBuilder();
        recipt.append("No. of Guests: ").append(getNumOfGuests()).append("\n");
        recipt.append("Server: ").append(getServer()).append("\n");
        if (isTakeOut) {
            recipt.append("Take-out").append("\n").append("\n");
        } else {
            recipt.append("Dine-in").append("\n").append("\n");
        }
        recipt.append("Item	       Price\n");
        for (Item item : orderList) {
            recipt.append(getItemAsString(item)).append("\n");
        }
        double totalOwed = getTotalOwed();
        recipt.append("Subtotal         ").append("$").append(totalOwed).append("\n");
        if (!isTakeOut) {
            recipt.append("Tip          ").append("$").append(totalOwed * .15).append("\n");
            totalOwed += (totalOwed * .15);

        }
        recipt.append("Total Due            ").append("$").append(totalOwed).append("\n");
        return recipt.toString();
    }

    private String getItemAsString(Item item) {
        if (item instanceof Food) {
            return String.format("(F)%s         $%f", item.getName(), item.getPrice());
        } else if (item instanceof Drink) {
            return String.format("(D)%s         $%f", item.getName(), item.getPrice());

        } else {
            return String.format("%s         $%f", item.getName(), item.getPrice());

        }
    }

}
