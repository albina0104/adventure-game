package adventure_game;

import java.util.ArrayList;

public class PathChooser {
    private static final ArrayList<ActionChoice> choices = new ArrayList<>();
    private static final ArrayList<Room> rooms = new ArrayList<>();

    static {
        choices.add(new ActionChoice(
                "check what you can do here",
                player -> {
                    System.out.println("You have plenty things to do in the room!");
                    // need to choose from list of choices in the room
                }
        ));
        choices.add(new ActionChoice(
                "go to another room",
                player -> {
                    System.out.println("---Which room would you like to go to?---");
                    printRooms();
                    player.setLocation(chooseRoom());
                    player.printCurrentLocation();
                }
        ));

        rooms.add(new Bedroom());
        rooms.add(new Kitchen());
    }

    public static ArrayList<ActionChoice> getChoices() {
        return choices;
    }

    public static void printChoices() {
        ChoiceHelper.printChoices(choices);
    }

    public static ActionChoice chooseAction() {
        return (ActionChoice) ChoiceHelper.makeChoice(choices);
    }


    private static void printRooms() {
        ChoiceHelper.printChoices(rooms);
    }
    private static Room chooseRoom() {
        return (Room) ChoiceHelper.makeChoice(rooms);
    }
}
