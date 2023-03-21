package guessThatPokemon;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/pokemon")
public class pokemonGameController {

    Pokemon p = new Pokemon();  // Create an instance to reference for .getPokemon() method
    //InputData data = new InputData();


    @GetMapping("/play")
    public String play(Model model) throws JsonProcessingException {
        Pokemon pokemon = p.getPokemon();

        System.out.println(pokemon.getName() + "  " + pokemon.getImage());  // Check if returned name and image are correct

        //model.addAttribute("pokemon", pokemon);
        model.addAttribute("pokemonImage", pokemon.getImage());
        model.addAttribute("pokemon", pokemon);
        //model.addAttribute("score", pokemon.getScore());
        model.addAttribute("pokemonAnswer", pokemon.getGuess());
        //model.addAttribute("data", data);

            return "displayPokemon";
            //return"greeting";
        }

    @PostMapping("/play")
    public String checkPokemonSubmit(@ModelAttribute Pokemon pokemon, Model model) {

        model.addAttribute("pokemonImage", pokemon.getImage());
        model.addAttribute("pokemonName", pokemon.getName());
        model.addAttribute("pokemon", pokemon);
        model.addAttribute("pokemonAnswer", pokemon.getGuess());
        //return "redirect:/play";
        return"simpleResult";
    }


//    @PostMapping("/play")
//    public String checkPokemonSubmit(@ModelAttribute InputData data, @ModelAttribute Pokemon pokemon, Model model) {
//
//        System.out.println(data.getAnswer());
//        System.out.println(pokemon.getName());
//
//
//        model.addAttribute("pokemon", pokemon.getName());
//        model.addAttribute("data", data.getAnswer());
//        return "simpleResult";
//    }




    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "simpleForm";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("greeting", greeting);
        return "simpleResult";
    }

}
