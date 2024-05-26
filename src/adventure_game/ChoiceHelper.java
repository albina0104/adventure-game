package adventure_game;

import java.util.List;
import java.util.Scanner;

public class ChoiceHelper {
    public static void printChoices(List<? extends Choice> choices) {
        for (int i = 0; i < choices.size(); i++) {
            Choice choice = choices.get(i);
            System.out.println((i + 1) + " - " + choice.getDescription());
        }
    }

    public static Choice makeChoice(List<? extends Choice> choices) {
        Scanner scanner = new Scanner(System.in);
        int choiceId;

        System.out.print("Please enter the number you choose: ");

        do {
            choiceId = scanner.nextInt();
            choiceId--;
            if (isInvalidChoice(choices, choiceId)) {
                System.out.print("Your choice is invalid. Please choose again: ");
            }
        } while (isInvalidChoice(choices, choiceId));

        return choices.get(choiceId);
    }

    private static boolean isInvalidChoice(List<?> choices, int choiceId) {
        return choiceId < 0 || choiceId >= choices.size();
    }
}
