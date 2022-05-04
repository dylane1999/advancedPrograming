import java.util.ArrayList;
import java.util.List;

public class PokemonSearch {

    List<Pokemon> allPokemon;

    public PokemonSearch(List<Pokemon> allPokemon) {
        this.allPokemon = allPokemon;
    }

    // Search by a Pokemon id, and return the Pokemon.
    public Pokemon searchById(int id) {
        return null;
    }

    // Search by a Pokemon name, and return the Pokemon. Name should be case
    // insensitive.
    public Pokemon searchByName(String name) {
        return null;
    }

    // Search by a specific type, and return all Pokemon with that type.
    public ArrayList<Pokemon> searchByType(String type) {
        return null;

    }

    // Search by a specific threshold of one of the stats, for example, Capture Rate
    // greater than 40%, and return all the Pokemon that satisfies the stats.
    public ArrayList<Pokemon> searchByStats(String stat, String operator, double percentage) {
        return null;
    }

    // Search by a specific quick move, and return all Pokemon that knows the move.
    public ArrayList<Pokemon> searchByQuickMove(String move) {
        return null;
    }

    // Search by a specific special move, and return all Pokemon that knows the
    // move.
    public ArrayList<Pokemon> searchBySpecialMove(String move) {
        return null;
    }

    // Search by a Pokemon name, and return the number of candies it will take to
    // evolve if this Pokemon can be evolved. Otherwise, return -1.
    public int candiesForEvolving(String name) {
        return 0;
    }

}
