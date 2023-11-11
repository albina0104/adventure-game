package adventure_game;

import java.util.ArrayList;
import java.util.Scanner;

public class PathChooser {
    private static final ArrayList<Choice> choices = new ArrayList<>();

    static {
        choices.add(new Choice(
                "check what you can do here",
                () -> {
                    System.out.println("You have plenty things to do in the room!");
                }
        ));
        choices.add(new Choice(
                "go to another room",
                () -> {
                    System.out.println("Which room would you like to go to?");
                }
        ));
    }

    public static ArrayList<Choice> getChoices() {
        return choices;
    }

    public static void printChoices() {
        for (int i = 0; i < choices.size(); i++) {
            Choice choice = choices.get(i);
            System.out.println((i + 1) + " - " + choice.getDescription());
        }
    }

    public static Choice chooseAction() {
        Scanner scanner = new Scanner(System.in);
        int choiceId;

        System.out.print("Please enter the number you choose: ");

        do {
            choiceId = scanner.nextInt();
            choiceId--;
            if (isInvalidChoice(choiceId)) {
                System.out.print("Your choice is invalid. Please choose again: ");
            }
        } while (isInvalidChoice(choiceId));

        return choices.get(choiceId);
    }

    private static boolean isInvalidChoice(int choiceId) {
        return choiceId < 0 || choiceId >= choices.size();
    }

}
