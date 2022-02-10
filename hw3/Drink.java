public class Drink extends Item {

    private boolean isAlcoholic;

    public boolean getIsAlcoholic() {
        return isAlcoholic;
    }

    public void setAlcoholic(boolean isAlcoholic) {
        this.isAlcoholic = isAlcoholic;
    }

    public Drink(String name, Double price, Integer calories, boolean isAlcoholic) {
        super(name, price, calories);
        setAlcoholic(isAlcoholic);
    }

    @Override
    public String toString() {
        String drinkString = super.toString();
        if (getIsAlcoholic()) {
            drinkString += "*Contains Alcohol";
        }
        return drinkString;
    }

}
