public class Item {

    // name of the item
    private String name;

    // price of an item
    private Float price;

    // number of calories in an item
    private Integer calories;

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Float getPrice() {
        return price;
    }
    
    public void setPrice(Float price) {
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
        return String.format("%s (%d calories)", this.getName(), this.getCalories());
    }


    public Item(String name, Float price, Integer calories){
        setName(name);
        setPrice(price);
        setCalories(calories);
    }


}
