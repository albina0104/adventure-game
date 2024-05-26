package adventure_game;

import java.util.ArrayList;
import java.util.List;

public class Bedroom extends Room {

    private static final String name = "bedroom";
    private static final List<ActionChoice> choices = new ArrayList<>();

    static {
        choices.add(new ActionChoice(
                "sleep",
                player -> {
                    System.out.println("Sleeping is so good!");
                    player.changeStats(5, -10, 100);
                }
        ));
    }

    @Override
    public String getDescription() {
        return name;
    }

    @Override
    public void printChoices() {
        ChoiceHelper.printChoices(choices);
    }

    @Override
    public ActionChoice chooseAction() {
        return (ActionChoice) ChoiceHelper.makeChoice(choices);
    }
}
