package adventure_game;

import java.util.ArrayList;
import java.util.Scanner;

public class ChoiceHelper {
    public static void printChoices(ArrayList<Choice> choices) {
        for (int i = 0; i < choices.size(); i++) {
            Choice choice = choices.get(i);
            System.out.println((i + 1) + " - " + choice.getDescription());
        }
    }

    public static void printRooms(ArrayList<Room> rooms) {
        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i);
            System.out.println((i + 1) + " - " + room.getName());
        }
    }

    public static Choice chooseAction(ArrayList<Choice> choices) {
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

    public static Room chooseRoom(ArrayList<Room> rooms) {
        Scanner scanner = new Scanner(System.in);
        int roomId;

        System.out.print("Please enter the number you choose: ");

        do {
            roomId = scanner.nextInt();
            roomId--;
            if (isInvalidChoice(rooms, roomId)) {
                System.out.print("Your choice is invalid. Please choose again: ");
            }
        } while (isInvalidChoice(rooms, roomId));

        return rooms.get(roomId);
    }

    private static boolean isInvalidChoice(ArrayList<?> choices, int choiceId) {
        return choiceId < 0 || choiceId >= choices.size();
    }
}
