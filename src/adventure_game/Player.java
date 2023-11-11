package adventure_game;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Scanner;

public final class Player {
    private final EnumMap<Stats, Integer> stats = new EnumMap<>(Stats.class);
    private Room location;
    private static final ArrayList<Choice> choices = new ArrayList<>();

    public Player() {
        stats.put(Stats.health, 100);
        stats.put(Stats.hunger, 0);
        stats.put(Stats.sleep, 100);
        location = new Bedroom();

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

    public void printStats() {
        System.out.println("-----Player's stats-----");
        for (EnumMap.Entry<Stats, Integer> stat : stats.entrySet()) {
            System.out.println(stat.getKey() + ": " + stat.getValue());
        }
    }

    public void printCurrentLocation() {
        System.out.println("You are now in the " + location.getName() + ".");
    }

    public void chooseAction() {
        System.out.println("----What would you like to do?----");

        for (int i = 0; i < choices.size(); i++) {
            Choice choice = choices.get(i);
            System.out.println((i + 1) + " - " + choice.getDescription());
        }

        System.out.print("Please enter the number you choose: ");

        Scanner scanner = new Scanner(System.in);
        int choiceId;
        do {
            choiceId = scanner.nextInt();
            choiceId--;
            // TO DO: create isValidChoice(), check and display error message if not valid
        } while (choiceId < 0 || choiceId >= choices.size()); // (!isValidChoice)
        // also, all choice logic should be moved to another class

        System.out.println("Your choice is: " + (choiceId+1) + " - " + choices.get(choiceId).getDescription());
        choices.get(choiceId).doAction();
        System.out.println("Game over");
    }


    public void chooseRoom() {

    }

    public void chooseActionInRoom() {

    }

//    public int getHealthScore() {
//        return healthScore;
//    }
//
//    public void setHealthScore(int healthScore) {
//        this.healthScore = healthScore;
//    }
//
//    public int getHungerScore() {
//        return hungerScore;
//    }
//
//    public void setHungerScore(int hungerScore) {
//        this.hungerScore = hungerScore;
//    }
//
//    public int getSleepScore() {
//        return sleepScore;
//    }
//
//    public void setSleepScore(int sleepScore) {
//        this.sleepScore = sleepScore;
//    }

    public Room getLocation() {
        return location;
    }

    public void setLocation(Room location) {
        this.location = location;
    }
}
