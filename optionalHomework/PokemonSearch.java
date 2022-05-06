import java.util.ArrayList;
import java.util.List;

public class PokemonSearch {

    List<Pokemon> allPokemon;

    public PokemonSearch(List<Pokemon> allPokemon) {
        this.allPokemon = allPokemon;
    }

    // Search by a Pokemon id, and return the Pokemon.
    public Pokemon searchById(int id) {
        for (Pokemon pokemon : allPokemon) {
            if (pokemon.getDex() == id) {
                return pokemon;
            }
        }
        return null;
    }

    // Search by a Pokemon name, and return the Pokemon. Name should be case
    // insensitive.
    public Pokemon searchByName(String name) {
        for (Pokemon pokemon : allPokemon) {
            if (pokemon.getName().equals(name)) {
                return pokemon;
            }
        }
        return null;
    }

    // Search by a specific type, and return all Pokemon with that type.
    public ArrayList<Pokemon> searchByType(String type) {
        ArrayList<Pokemon> pokemonList = new ArrayList<>();
        for (Pokemon pokemon : allPokemon) {
            if (pokemon.getTypes().contains(type)) {
                pokemonList.add(pokemon);
            }
        }
        return pokemonList;

    }

    // Search by a specific threshold of one of the stats, for example, Capture Rate
    // greater than 40%, and return all the Pokemon that satisfies the stats.
    public ArrayList<Pokemon> searchByStats(String stat, String operator, double percentage) {
        ArrayList<Pokemon> pokeList = new ArrayList<>();
        if (stat.equals("catchRate")) {
            if (operator.equals(">")) {
                for (Pokemon pokemon : allPokemon) {
                    if (pokemon.getCatchRate() != null && percentage > pokemon.getCatchRate()) {
                        pokeList.add(pokemon);
                    }
                }
            } 
            else if (operator.equals("<=")) {
                for (Pokemon pokemon : allPokemon) {
                    if (pokemon.getCatchRate() != null && percentage <= pokemon.getCatchRate()) {
                        pokeList.add(pokemon);
                    }
                }
            }
            else if (operator.equals(">=")) {
                for (Pokemon pokemon : allPokemon) {
                    if (pokemon.getCatchRate() != null && percentage >= pokemon.getCatchRate()) {
                        pokeList.add(pokemon);
                    }
                }
            }
            else if (operator.equals("<")) {
                for (Pokemon pokemon : allPokemon) {
                    if (pokemon.getCatchRate() != null && percentage < pokemon.getCatchRate()) {
                        pokeList.add(pokemon);
                    }
                }
            } else if (operator.equals("==")) {
                for (Pokemon pokemon : allPokemon) {
                    if (pokemon.getCatchRate() != null && percentage == pokemon.getCatchRate()) {
                        pokeList.add(pokemon);
                    }

                }
            }

        } else if (stat.equals("fleeRate")) {
            if (operator.equals(">")) {
                for (Pokemon pokemon : allPokemon) {
                    if (percentage > pokemon.getFleeRate()) {
                        pokeList.add(pokemon);
                    }
                }
                
            }  else if (operator.equals("<=")) {
                for (Pokemon pokemon : allPokemon) {
                    if (percentage <= pokemon.getFleeRate()) {
                        pokeList.add(pokemon);
                    }
                }
            }
            else if (operator.equals(">=")) {
                for (Pokemon pokemon : allPokemon) {
                    if (percentage >= pokemon.getCatchRate()) {
                        pokeList.add(pokemon);
                    }
                }
            }else if (operator.equals("<")) {
                for (Pokemon pokemon : allPokemon) {
                    if (percentage < pokemon.getFleeRate()) {
                        pokeList.add(pokemon);
                    }
                }
            } else if (operator.equals("==")) {
                for (Pokemon pokemon : allPokemon) {
                    if (percentage == pokemon.getFleeRate()) {
                        pokeList.add(pokemon);
                    }

                }
            }

        } else if (stat.equals("attack")) {

            if (operator.equals(">")) {
                for (Pokemon pokemon : allPokemon) {
                    if (percentage > pokemon.getAttack()) {
                        pokeList.add(pokemon);
                    }
                }
            } else if (operator.equals("<")) {
                for (Pokemon pokemon : allPokemon) {
                    if (percentage < pokemon.getAttack()) {
                        pokeList.add(pokemon);
                    }
                }
            } 
            else if (operator.equals("<=")) {
                for (Pokemon pokemon : allPokemon) {
                    if (percentage <= pokemon.getAttack()) {
                        pokeList.add(pokemon);
                    }
                }
            }
            else if (operator.equals(">=")) {
                for (Pokemon pokemon : allPokemon) {
                    if (percentage >= pokemon.getAttack()) {
                        pokeList.add(pokemon);
                    }
                }
            }else if (operator.equals("==")) {
                for (Pokemon pokemon : allPokemon) {
                    if (percentage == pokemon.getAttack()) {
                        pokeList.add(pokemon);
                    }

                }
            }

        } else if (stat.equals("defense")) {
            if (operator.equals(">")) {
                for (Pokemon pokemon : allPokemon) {
                    if (percentage > pokemon.getDefense()) {
                        pokeList.add(pokemon);
                    }
                }
            } else if (operator.equals("<")) {
                for (Pokemon pokemon : allPokemon) {
                    if (percentage < pokemon.getDefense()) {
                        pokeList.add(pokemon);
                    }
                }
            } else if (operator.equals("<=")) {
                for (Pokemon pokemon : allPokemon) {
                    if (percentage <= pokemon.getDefense()) {
                        pokeList.add(pokemon);
                    }
                }
            }
            else if (operator.equals(">=")) {
                for (Pokemon pokemon : allPokemon) {
                    if (percentage >= pokemon.getDefense()) {
                        pokeList.add(pokemon);
                    }
                }
            }else if (operator.equals("==")) {
                for (Pokemon pokemon : allPokemon) {
                    if (percentage == pokemon.getDefense()) {
                        pokeList.add(pokemon);
                    }
                }
            }
        } else if (stat.equals("candy")) {
            if (operator.equals(">")) {
                for (Pokemon pokemon : allPokemon) {
                    if (pokemon.getCandy() != null && percentage > pokemon.getCandy()) {
                        pokeList.add(pokemon);
                    }
                }
            } else if (operator.equals("<")) {
                for (Pokemon pokemon : allPokemon) {
                    if (pokemon.getCandy() != null && percentage < pokemon.getCandy()) {
                        pokeList.add(pokemon);
                    }
                }
            } else if (operator.equals("<=")) {
                for (Pokemon pokemon : allPokemon) {
                    if (pokemon.getCandy() != null && percentage <= pokemon.getCandy()) {
                        pokeList.add(pokemon);
                    }
                }
            }
            else if (operator.equals(">=")) {
                for (Pokemon pokemon : allPokemon) {
                    if (pokemon.getCandy() != null && percentage >= pokemon.getCandy()) {
                        pokeList.add(pokemon);
                    }
                }
            }else if (operator.equals("==")) {
                for (Pokemon pokemon : allPokemon) {
                    if (pokemon.getCandy() != null && percentage == pokemon.getCandy()) {
                        pokeList.add(pokemon);
                    }

                }
            }

        }
        return pokeList;
    }

    // Search by a specific quick move, and return all Pokemon that knows the move.
    public ArrayList<Pokemon> searchByQuickMove(String move) {
        ArrayList<Pokemon> pokeList = new ArrayList<>();
        for (Pokemon pokemon : allPokemon) {
            if (pokemon.getFastMoves().contains(move)) {
                pokeList.add(pokemon);
            }
        }
        return pokeList;
    }

    // Search by a specific special move, and return all Pokemon that knows the
    // move.
    public ArrayList<Pokemon> searchBySpecialMove(String move) {
        ArrayList<Pokemon> pokeList = new ArrayList<>();
        for (Pokemon pokemon : allPokemon) {
            if (pokemon.getChargedMoves().contains(move)) {
                pokeList.add(pokemon);
            }
        }
        return pokeList;
    }

    // Search by a Pokemon name, and return the number of candies it will take to
    // evolve if this Pokemon can be evolved. Otherwise, return -1.
    public int candiesForEvolving(String name) {
        for (Pokemon pokemon : allPokemon) {
            if (pokemon.getName().equals(name)) {
                if (pokemon.getCandy() != null) {
                    return pokemon.getCandy();
                }
            }
        }
        return -1;
    }

}
