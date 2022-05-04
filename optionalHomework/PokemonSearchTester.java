import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class PokemonSearchTester {

    public static void main(String[] args) throws ParseException, IOException {
        JSONParser parser = new JSONParser();
        File jsonFile = new File("./data.json");
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
        for (Map jsonPokemon : map) {
            // get all json attributes and make each one into a pokemon
        }
        return;

    }

}
