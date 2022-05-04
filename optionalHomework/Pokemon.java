import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

public class Pokemon implements JSONAware {

    private String dex;
    private String name;
    private List<String> types;
    private Integer attack;
    private Integer defense;
    private Integer HP;
    private String catchRate;
    private String fleeRate;
    private Integer candy;
    private List<String> fastMoves;
    private List<String> chargedMoves;

    public Pokemon(String dex, String name, List<String> types, Integer attack, Integer defense, Integer HP,
            String catchRate, String fleeRate, Integer candy, List<String> fastMoves, List<String> chargedMoves) {
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

    public String getDex() {
        return this.dex;
    }

    public void setDex(String dex) {
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

    public String getCatchRate() {
        return this.catchRate;
    }

    public void setCatchRate(String catchRate) {
        this.catchRate = catchRate;
    }

    public String getFleeRate() {
        return this.fleeRate;
    }

    public void setFleeRate(String fleeRate) {
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
    public String toJSONString() {
        final JSONObject json = new JSONObject();
        json.put("dex", this.getDex());
        return json.toJSONString();

    }

}
