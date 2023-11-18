package adventure_game;

import java.util.ArrayList;
import java.util.Random;

public class Kitchen extends Room {

    private static final String name = "kitchen";
    private static final ArrayList<ActionChoice> choices = new ArrayList<>();

    static {
        choices.add(new ActionChoice(
                "eat",
                player -> {
                    System.out.println("Mmm, the food is so yummy!");
                    player.changeStats(5, 30, -10);
                    Random random = new Random();
                    int randomNumber = random.nextInt(4) + 1;
                    if (randomNumber == 1) {
                        System.out.println("Oops, you cut yourself with a knife!");
                        player.changeStats(-10, 0, 0);
                    }
                }
        ));
    }

    @Override
    public String getDescription() {
        return name;
    }

    @Override
    void printChoices() {
        ChoiceHelper.printChoices(choices);
    }

    @Override
    Choice chooseAction() {
        return ChoiceHelper.makeChoice(choices);
    }
}
