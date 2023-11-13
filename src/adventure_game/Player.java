package adventure_game;

import java.util.EnumMap;

public final class Player {
    private final EnumMap<Stats, Integer> stats = new EnumMap<>(Stats.class);
    private Room location;

    public Player() {
        stats.put(Stats.health, 100);
        stats.put(Stats.hunger, 0);
        stats.put(Stats.sleep, 100);
        location = new Bedroom();
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

        PathChooser.printChoices();
        Choice choice = PathChooser.chooseAction();
        choice.doAction(this);
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
