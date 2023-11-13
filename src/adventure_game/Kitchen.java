package adventure_game;

import java.util.ArrayList;

public class Kitchen extends Room {

    private static final String name = "kitchen";
    private static final ArrayList<Choice> choices = new ArrayList<>();

    static {
        choices.add(new Choice(
                "eat",
                player -> {
                    System.out.println("Mmm, the food is so yummy!");
                }
        ));
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    void printChoices() {

    }

    @Override
    Choice chooseAction() {
        return ChoiceHelper.chooseAction(choices);
    }
}
