package guessThatPokemon;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.UnsupportedEncodingException;
import java.net.*;

@SpringBootApplication
public class pokemonApplication {

	public static void main(String[] args) throws UnsupportedEncodingException, UnirestException, URISyntaxException, JsonProcessingException {

		SpringApplication.run(pokemonApplication.class, args);
	}
}

//		// Host url
//		String host = "https://movie-database-alternative.p.rapidapi.com/";
//		String charset = "UTF-8";
//		// Headers for a request
//		String x_rapidapi_host = "movie-database-alternative.p.rapidapi.com";
//		String x_rapidapi_key = "f7ac2b366fmsh894cac288a8569ep1fb674jsn151852d033af"; //Type here your key
//		// Params
//		String s = "Pulp";
//		// Format query for preventing encoding problems
//		String query = String.format("s=%s",
//				URLEncoder.encode(s, charset));
//
//
//		// Host, charset and headers vars should be the same
//		String i = "tt0110912";
//		// Format query for preventing encoding problems
//		query = String.format("i=%s",
//				URLEncoder.encode(i, charset));
//		// Json response
//		HttpResponse <JsonNode> response = Unirest.get(host + "?" + query)
//				.header("x-rapidapi-host", x_rapidapi_host)
//				.header("x-rapidapi-key", x_rapidapi_key)
//				.asJson();
//		//Prettifying
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		JsonParser jp = new JsonParser();
//		JsonElement je = jp.parse(response.getBody().toString());
//		JsonObject jsonObject = je.getAsJsonObject();
//		//String prettyJsonString = gson.toJson(je);
//		System.out.println(jsonObject.get("Metascore"));

		/////////////////////////////////////////////////////////////////////////////////////////////

//		// Host url
//		String host = "https://trivia-by-api-ninjas.p.rapidapi.com/v1/trivia";
//		String charset = "UTF-8";
//		// Headers for a request
//		String x_rapidapi_host = "trivia-by-api-ninjas.p.rapidapi.com";
//		String x_rapidapi_key = "f7ac2b366fmsh894cac288a8569ep1fb674jsn151852d033af"; //Type here your key
//		// Params
//		String s = "fooddrink";
//		// Format query for preventing encoding problems
//		String query = String.format("s=%s",
//				URLEncoder.encode(s, charset));
//
//
//		// Host, charset and headers vars should be the same
//		String i = "tt0110912";
//		// Format query for preventing encoding problems
//		query = String.format("i=%s",
//				URLEncoder.encode(i, charset));
//		// Json response
//		HttpResponse <JsonNode> response = Unirest.get(host + "?" + query)
//				.header("x-rapidapi-host", x_rapidapi_host)
//				.header("x-rapidapi-key", x_rapidapi_key)
//				.asJson();
//		//Prettifying
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		JsonParser jp = new JsonParser();
//		JsonElement je = jp.parse(response.getBody().toString());
//		//JsonObject jsonObject = je.getAsJsonObject();
//		JsonArray jsonArray = je.getAsJsonArray();
//		//String prettyJsonString = gson.toJson(je);
//		System.out.println(jsonArray.get(0));





//		// HTTPClient baeldung start GET
//		HttpRequest request = HttpRequest.newBuilder()
//				.uri(new URI("https://postman-echo.com/get"))
//				.GET()
//				.build();
//
//		//If your call needs headers
//		HttpRequest request2 = HttpRequest.newBuilder()
//				.uri(new URI("https://postman-echo.com/get"))
//				.headers("key1", "value1", "key2", "value2")
//				.GET()
//				.build();


//		// Number generator for random pokemon
//		Random random = new Random();
//		int x = random.nextInt(151);  // 0 - 150
//		System.out.println("Random number " + x);
//
//
//		// RestTemplate
//		RestTemplate restTemplate = new RestTemplate();
//		String pokeURL = "https://pokeapi.co/api/v2/pokemon?limit=151&offset=0";
//		ResponseEntity<String> response = restTemplate.getForEntity(pokeURL, String.class);
//		System.out.println(response.getStatusCode());
//		ObjectMapper mapper = new ObjectMapper();
//		JsonNode root = mapper.readTree(response.getBody());

//		System.out.println(response.getBody());      // Gets entire json response
//		System.out.println(root.get("results").get(1)); // Gets "results" and selects the result from the array
//		System.out.println(root.get("results").get(1).get("name"));		//  Gets the name from the array result
//		System.out.println(root.get("results").get(1).get("url"));		// Gets url from array result to use with finding it's sprite

//		System.out.println(response.getBody());      // Gets entire json response
//		System.out.println(root.get("results").get(x)); // Gets "results" and selects the result from the array
//		System.out.println(root.get("results").get(x).get("name"));		//  Gets the name from the array result
//		System.out.println(root.get("results").get(x).get("url"));		// Gets url from array result to use with finding it's sprite

//		String returnedURL = root.get("results").get(1).get("url").toString();
//		String nameResult = root.get("results").get(1).get("name").toString();  // Gets the name of the pokemon from results.
//		String name = nameResult.substring(1, Integer.valueOf(nameResult.length()-1)); // Removes the "" from the pokemon name to be used with the next url
//		System.out.println(name);  // Name prints without "".

//		String returnedURL = root.get("results").get(x).get("url").toString();
//		String nameResult = root.get("results").get(x).get("name").toString();  // Gets the name of the pokemon from results.
//		String name = nameResult.substring(1, Integer.valueOf(nameResult.length()-1)); // Removes the "" from the pokemon name to be used with the next url
//		System.out.println(name);  // Name prints without "".
//
//		RestTemplate restTemplate1 = new RestTemplate();
//		String pokeURL1 = "https://pokeapi.co/api/v2/pokemon/" + name; // Uses the name from the original call to add to the url for the next api call
//		ResponseEntity<String> response1 = restTemplate1.getForEntity(pokeURL1, String.class);
//		System.out.println(response1.getStatusCode());
//		ObjectMapper mapper1 = new ObjectMapper();
//		JsonNode root1 = mapper1.readTree(response1.getBody()); // This response body is the complete list of data for a specific pokemon
//		System.out.println(root1.get("sprites").get("other").get("official-artwork").get("front_default")); //filters thruogh data to get the sprite img link
//
//		String i = root1.get("sprites").get("other").get("official-artwork").get("front_default").toString();
//		String imageName = i.substring(1, Integer.valueOf(i.length()-1)); //removes "" from sprite link
//
//		Pokemon newPokemon = new Pokemon(name, imageName);
//
//		System.out.println(imageName);
//		System.out.println(newPokemon.getName() + " " + newPokemon.getImage());


		// displaying the sprite image







