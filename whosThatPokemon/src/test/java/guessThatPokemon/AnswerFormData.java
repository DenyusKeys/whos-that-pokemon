package guessThatPokemon;

public class AnswerFormData {

    private String name;

    public AnswerFormData(String name) {
        this.name = name;
    }

    public AnswerFormData(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
