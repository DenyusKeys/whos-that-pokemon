package guessThatPokemon;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

public class Pokemon {

    private String name;
    private String image;
    private String guess;
    private int score;



    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public Pokemon(String name, String image, String guess, int score){
        this.name = name;
        this.image = image;
        this.guess = guess;
        this.score = score;
    }

    public Pokemon(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public Pokemon() {

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    Pokemon getPokemon() throws JsonProcessingException {
        // Number generator for random pokemon
        Random random = new Random();
        int x = random.nextInt(151);  // 0 - 150
        System.out.println("Random number " + x);

        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();
        String pokeURL = "https://pokeapi.co/api/v2/pokemon?limit=151&offset=0";
        ResponseEntity<String> response = restTemplate.getForEntity(pokeURL, String.class);
        System.out.println(response.getStatusCode());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());


        String nameResult = root.get("results").get(x).get("name").toString();  // Gets the name of the pokemon from results.
        String name = nameResult.substring(1, Integer.valueOf(nameResult.length()-1)); // Removes the "" from the pokemon name to be used with the next url


        RestTemplate restTemplate1 = new RestTemplate();
        String pokeURL1 = "https://pokeapi.co/api/v2/pokemon/" + name; // Uses the name from the original call to add to the url for the next api call
        ResponseEntity<String> response1 = restTemplate1.getForEntity(pokeURL1, String.class);
        ObjectMapper mapper1 = new ObjectMapper();
        JsonNode root1 = mapper1.readTree(response1.getBody()); // This response body is the complete list of data for a specific pokemon

        String i = root1.get("sprites").get("other").get("official-artwork").get("front_default").toString(); // Gets sprite url from pokemon data
        String imageName = i.substring(1, Integer.valueOf(i.length()-1)); //removes "" from sprite link

        Pokemon newPokemon = new Pokemon(name, imageName);

        //System.out.println(newPokemon.getName() + " " + newPokemon.getImage());
        return newPokemon;
    }

    public boolean checkAnswer(String guess){
        if(guess.equals(this.name)){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", guess='" + guess + '\'' +
                ", score=" + score +
                '}';
    }
}
