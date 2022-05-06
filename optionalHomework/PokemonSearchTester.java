import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PokemonSearchTester {

    public static void test_searchById_happyPath(PokemonSearch pokemonSearch) {
        Pokemon expectedPokemon = new Pokemon(1, "Bulbasaur", Arrays.asList("Grass", "Poison"), 128, 118, 111, 20.0,
                10.0, 25, Arrays.asList("Vine Whip", "Tackle"),
                Arrays.asList("Seed Bomb", "Sludge Bomb", "Power Whip"));
        Pokemon actualPokemon = pokemonSearch.searchById(expectedPokemon.getDex());
        assertTrue(expectedPokemon.equals(actualPokemon));
    }

    public static void test_searchById_nonexistantId(PokemonSearch pokemonSearch) {
        Pokemon expPokemon = pokemonSearch.searchById(0);
        assertNull(expPokemon);
    }

    public static void test_searchByName_happyPath(PokemonSearch pokemonSearch) {
        Pokemon expectedPokemon = new Pokemon(1, "Bulbasaur", Arrays.asList("Grass", "Poison"), 128, 118, 111, 20.0,
                10.0, 25, Arrays.asList("Vine Whip", "Tackle"),
                Arrays.asList("Seed Bomb", "Sludge Bomb", "Power Whip"));
        Pokemon actualPokemon = pokemonSearch.searchByName(expectedPokemon.getName());
        assertTrue(expectedPokemon.equals(actualPokemon));
    }

    public static void test_searchByName_nonexistantName(PokemonSearch pokemonSearch) {
        Pokemon expPokemon = pokemonSearch.searchByName("chicken little");
        assertNull(expPokemon);
    }

    public static void test_searchByType_happyPath(PokemonSearch pokemonSearch) {
        Pokemon expectedPokemon = new Pokemon(1, "Bulbasaur", Arrays.asList("Grass", "Poison"), 128, 118, 111, 20.0,
                10.0, 25, Arrays.asList("Vine Whip", "Tackle"),
                Arrays.asList("Seed Bomb", "Sludge Bomb", "Power Whip"));
        List<Pokemon> pokemonList = pokemonSearch.searchByType(expectedPokemon.getTypes().get(0));
        assertTrue(pokemonList.contains(expectedPokemon));
    }

    public static void test_searchByType_nonexistantType(PokemonSearch pokemonSearch) {
        List<Pokemon> pokemonList = pokemonSearch.searchByType("chicken");
        assertTrue(pokemonList.isEmpty());
    }

    public static void test_searchByStats_happyPath(PokemonSearch pokemonSearch) {
        Pokemon expectedPokemon = new Pokemon(1, "Bulbasaur", Arrays.asList("Grass", "Poison"), 128, 118, 111, 20.0,
                10.0, 25, Arrays.asList("Vine Whip", "Tackle"),
                Arrays.asList("Seed Bomb", "Sludge Bomb", "Power Whip"));
        List<Pokemon> pokemonList = pokemonSearch.searchByStats("catchRate", "==", 20.0);
        assertTrue(pokemonList.contains(expectedPokemon));
    }

    public static void test_searchByStats_negativeStat(PokemonSearch pokemonSearch) {
        List<Pokemon> pokemonList = pokemonSearch.searchByStats("catchRate", "==", -20.0);
        assertTrue(pokemonList.isEmpty());
    }

    public static void test_searchByquickMove_happyPath(PokemonSearch pokemonSearch) {
        Pokemon expectedPokemon = new Pokemon(1, "Bulbasaur", Arrays.asList("Grass", "Poison"), 128, 118, 111, 20.0,
                10.0, 25, Arrays.asList("Vine Whip", "Tackle"),
                Arrays.asList("Seed Bomb", "Sludge Bomb", "Power Whip"));
        List<Pokemon> pokemonList = pokemonSearch.searchByQuickMove("Vine Whip");
        assertTrue(pokemonList.contains(expectedPokemon));
    }

    public static void test_searchByquickMove_nonexistantMove(PokemonSearch pokemonSearch) {
        List<Pokemon> pokemonList = pokemonSearch.searchByQuickMove("fake move");
        assertTrue(pokemonList.isEmpty());
    }

    public static void test_searchBySpecialMove_happyPath(PokemonSearch pokemonSearch) {
        Pokemon expectedPokemon = new Pokemon(1, "Bulbasaur", Arrays.asList("Grass", "Poison"), 128, 118, 111, 20.0,
                10.0, 25, Arrays.asList("Vine Whip", "Tackle"),
                Arrays.asList("Seed Bomb", "Sludge Bomb", "Power Whip"));
        List<Pokemon> pokemonList = pokemonSearch.searchBySpecialMove("Power Whip");
        assertTrue(pokemonList.contains(expectedPokemon));
    }

    public static void test_searchBySpecialMove_nonexistantMove(PokemonSearch pokemonSearch) {
        List<Pokemon> pokemonList = pokemonSearch.searchBySpecialMove("fake move");
        assertTrue(pokemonList.isEmpty());
    }

    public static void test_candiesToEvolve_happyPath(PokemonSearch pokemonSearch) {
        Pokemon expectedPokemon = new Pokemon(1, "Bulbasaur", Arrays.asList("Grass", "Poison"), 128, 118, 111, 20.0,
                10.0, 25, Arrays.asList("Vine Whip", "Tackle"),
                Arrays.asList("Seed Bomb", "Sludge Bomb", "Power Whip"));
        int candiesToEvolve = pokemonSearch.candiesForEvolving(expectedPokemon.getName());
        assertEquals(expectedPokemon.getCandy(), candiesToEvolve);
    }

    public static void test_candiesToEvolve_nonexistantPokemon(PokemonSearch pokemonSearch) {
        // throw error when pokemon name does not exist
        assertThrows(IllegalArgumentException.class, () -> pokemonSearch.candiesForEvolving("FAKE"));
    }

    public static void main(String[] args) throws ParseException, IOException {
        JSONParser parser = new JSONParser();
        ContainerFactory containerFactory = new ContainerFactory() {
            @Override
            public Map createObjectContainer() {
                return new HashMap<>();
            }

            @Override
            public List creatArrayContainer() {
                return new ArrayList<>();
            }
        };
        String json = Files.readString(Paths.get("./data.json"));
        List<Map> map = (List<Map>) parser.parse(json, containerFactory);
        List<Pokemon> allPokemon = new ArrayList<>();
        for (Map jsonPokemon : map) {
            Integer dex = Integer.parseInt(String.valueOf(jsonPokemon.get("dex")));
            String name = (String) jsonPokemon.get("name");
            Double fleeRate = Double.parseDouble(String.valueOf(jsonPokemon.get("fleeRate")).replace("%", ""));
            Double catchRate;
            if (jsonPokemon.get("catchRate") == null) {
                catchRate = null;
            } else {
                catchRate = Double.parseDouble(String.valueOf(jsonPokemon.get("catchRate")).replace("%", ""));
            }
            Integer attack = Integer.parseInt(String.valueOf(jsonPokemon.get("attack")));
            Integer defense = Integer.parseInt(String.valueOf(jsonPokemon.get("defense")));
            Integer HP = Integer.parseInt(String.valueOf(jsonPokemon.get("HP")));
            Integer candy;
            if(jsonPokemon.get("candy") == null){
                candy = null;
            }
            else{
                candy = Integer.parseInt(String.valueOf(jsonPokemon.get("candy")));
            }
            List<String> chargedMoves = (List<String>) jsonPokemon.get("chargeMoves");
            List<String> fastMoves = (List<String>) jsonPokemon.get("fastMoves");
            List<String> types = (List<String>) jsonPokemon.get("types");
            Pokemon newPokemon = new Pokemon(dex, name, types, attack, defense, HP, catchRate, fleeRate, candy,
                    fastMoves, chargedMoves);
            allPokemon.add(newPokemon);
        }

        // create class to test search methods
        PokemonSearch pokemonSearch = new PokemonSearch(allPokemon);

        // test searchById
        test_searchById_happyPath(pokemonSearch);
        test_searchById_nonexistantId(pokemonSearch);

        // test searchByName
        test_searchByName_happyPath(pokemonSearch);
        test_searchByName_nonexistantName(pokemonSearch);

        // test searchByType
        test_searchByType_happyPath(pokemonSearch);
        test_searchByType_nonexistantType(pokemonSearch);

        // test searchByStats
        test_searchByStats_happyPath(pokemonSearch);
        test_searchByStats_negativeStat(pokemonSearch);

        // test searchByQuickMove
        test_searchByquickMove_happyPath(pokemonSearch);
        test_searchByquickMove_nonexistantMove(pokemonSearch);

        // test searchBySpecialMove
        test_searchBySpecialMove_happyPath(pokemonSearch);
        test_searchBySpecialMove_nonexistantMove(pokemonSearch);

        // test candiesForEvolving
        test_candiesToEvolve_happyPath(pokemonSearch);
        test_candiesToEvolve_nonexistantPokemon(pokemonSearch);

        System.out.println("------ TESTS COMPLETE ------");

    }

}
