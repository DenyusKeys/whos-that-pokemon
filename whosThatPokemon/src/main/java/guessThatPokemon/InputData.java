package guessThatPokemon;

public class InputData {

    private String answer;
    private String pokemonName;

    public InputData(String answer) {
        this.answer = answer;
    }

    public InputData() {
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
