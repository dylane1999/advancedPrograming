import java.util.List;
import java.util.Objects;

public class Pokemon {

    private Integer dex;
    private String name;
    private List<String> types;
    private Integer attack;
    private Integer defense;
    private Integer HP;
    private Double catchRate;
    private Double fleeRate;
    private Integer candy;
    private List<String> fastMoves;
    private List<String> chargedMoves;

    public Pokemon(Integer dex, String name, List<String> types, Integer attack, Integer defense, Integer HP,
            Double catchRate, Double fleeRate, Integer candy, List<String> fastMoves, List<String> chargedMoves) {
        this.dex = dex;
        this.name = name;
        this.types = types;
        this.attack = attack;
        this.defense = defense;
        this.HP = HP;
        this.catchRate = catchRate;
        this.fleeRate = fleeRate;
        this.candy = candy;
        this.fastMoves = fastMoves;
        this.chargedMoves = chargedMoves;
    }

    public Integer getDex() {
        return this.dex;
    }

    public void setDex(Integer dex) {
        this.dex = dex;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTypes() {
        return this.types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public Integer getAttack() {
        return this.attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefense() {
        return this.defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public Integer getHP() {
        return this.HP;
    }

    public void setHP(Integer HP) {
        this.HP = HP;
    }

    public Double getCatchRate() {
        return this.catchRate;
    }

    public void setCatchRate(Double catchRate) {
        this.catchRate = catchRate;
    }

    public Double getFleeRate() {
        return this.fleeRate;
    }

    public void setFleeRate(Double fleeRate) {
        this.fleeRate = fleeRate;
    }

    public Integer getCandy() {
        return this.candy;
    }

    public void setCandy(Integer candy) {
        this.candy = candy;
    }

    public List<String> getFastMoves() {
        return this.fastMoves;
    }

    public void setFastMoves(List<String> fastMoves) {
        this.fastMoves = fastMoves;
    }

    public List<String> getChargedMoves() {
        return this.chargedMoves;
    }

    public void setChargedMoves(List<String> chargedMoves) {
        this.chargedMoves = chargedMoves;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pokemon)) {
            return false;
        }
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(dex, pokemon.dex) && Objects.equals(name, pokemon.name)
                && Objects.equals(types, pokemon.types) && Objects.equals(attack, pokemon.attack)
                && Objects.equals(defense, pokemon.defense) && Objects.equals(HP, pokemon.HP)
                && Objects.equals(catchRate, pokemon.catchRate) && Objects.equals(fleeRate, pokemon.fleeRate)
                && Objects.equals(candy, pokemon.candy) && Objects.equals(fastMoves, pokemon.fastMoves)
                && Objects.equals(chargedMoves, pokemon.chargedMoves);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dex, name, types, attack, defense, HP, catchRate, fleeRate, candy, fastMoves, chargedMoves);
    }

}
