public class Food extends Item {

    private boolean isVegan;

    private Integer spicyLevel;

    public Integer getSpicyLevel() {
        return spicyLevel;
    }

    public void setSpicyLevel(Integer spicyLevel) {
        this.spicyLevel = spicyLevel;
    }

    public boolean getIsVegan() {
        return isVegan;
    }

    public void setIsVegan(boolean isVegan) {
        this.isVegan = isVegan;
    }

    public Food(String name, double price, Integer calories, boolean isVegan, Integer spicyLevel) {
        super(name, price, calories);
        setIsVegan(isVegan);
        setSpicyLevel(spicyLevel);
    }

    @Override
    public String toString() {
        String foodString = super.toString();
        return String.format("%s\n%s   Spicy:", foodString, getVeganString(), getSpicyString());
    }

    private String getVeganString(){
        if (getIsVegan()) {
            return "Vegan Friendly";
        }
        return "Not Vegan Friendly";
    }

    private String getSpicyString(){
        if (getSpicyLevel() >= 1) {
            String spiceStars = "";
            for (int i = 0; i < getSpicyLevel(); i++) {
                spiceStars += "*";
            }
            return spiceStars;
        }
        return "not spicy";
    }

}
