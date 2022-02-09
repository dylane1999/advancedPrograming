public class Drink extends Item {

    private boolean isAlcoholic;

    public boolean getIsAlcoholic() {
        // TODO Auto-generated method stub
        return isAlcoholic;
    }

    public void setAlcoholic(boolean isAlcoholic) {
        this.isAlcoholic = isAlcoholic;
    }

    public Drink(String name, Float price, Integer calories, boolean isAlcoholic) {
        super(name, price, calories);
        setAlcoholic(isAlcoholic);
    }

    @Override
    public String toString() {
        String drinkString = String.format("%s (%d calories)		%f", getName(), getCalories(), getPrice());
        if (getIsAlcoholic()) {
            drinkString += "\n*Contains Alcohol";
        }
        return drinkString;
    }

}
