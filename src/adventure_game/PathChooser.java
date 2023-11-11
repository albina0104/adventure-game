package adventure_game;

import java.util.ArrayList;

public class PathChooser {
    private static final ArrayList<Choice> choices = new ArrayList<>();

    static {
        choices.add(new Choice(
                "check what you can do here",
                () -> {
                    System.out.println("You have plenty things to do in the room!");
                    // need to choose from list of choices in the room
                }
        ));
        choices.add(new Choice(
                "go to another room",
                () -> {
                    System.out.println("Which room would you like to go to?");
                    // need to choose from list of rooms
                }
        ));
    }

    public static ArrayList<Choice> getChoices() {
        return choices;
    }

    public static void printChoices() {
        ChoiceHelper.printChoices(choices);
    }

    public static Choice chooseAction() {
        return ChoiceHelper.chooseAction(choices);
    }
}
