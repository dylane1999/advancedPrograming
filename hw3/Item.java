import java.text.DecimalFormat;

public class Item {

    private DecimalFormat df = new DecimalFormat("#.00");


    // name of the item
    private String name;

    // price of an item
    private double price;

    // number of calories in an item
    private Integer calories;

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s (%d calories)		%s\n", this.getName(), this.getCalories(), df.format(getPrice()));
    }


    public Item(String name, double price, Integer calories){
        setName(name);
        setPrice(price);
        setCalories(calories);
    }


}
