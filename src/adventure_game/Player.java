package adventure_game;

import java.util.EnumMap;

public final class Player {
    private final EnumMap<Stats, Integer> stats = new EnumMap<>(Stats.class);
    private Room location;

    public Player() {
        stats.put(Stats.health, 100);
        stats.put(Stats.hunger, 100);
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
        System.out.println("You are now in the " + location.getDescription() + ".");
    }

    public void chooseAction() {
        System.out.println("----What would you like to do?----");

        PathChooser.printChoices();
        ActionChoice choice = PathChooser.chooseAction();
        choice.doAction(this);
    }

    public int[] getStats() {
        return new int[]{ this.getHealthScore(), this.getHungerScore(), this.getSleepScore() };
    }

    public void changeStats(int healthChange, int hungerChange, int sleepChange) {
        this.setHealthScore(this.getHealthScore() + healthChange);
        this.setHungerScore(this.getHungerScore() + hungerChange);
        this.setSleepScore(this.getSleepScore() + sleepChange);
        printStats();
    }

    public int getHealthScore() {
        return stats.get(Stats.health);
    }

    public void setHealthScore(int healthScore) {
        stats.put(Stats.health, healthScore);
    }

    public int getHungerScore() {
        return stats.get(Stats.hunger);
    }

    public void setHungerScore(int hungerScore) {
        stats.put(Stats.hunger, hungerScore);
    }

    public int getSleepScore() {
        return stats.get(Stats.sleep);
    }

    public void setSleepScore(int sleepScore) {
        stats.put(Stats.sleep, sleepScore);
    }

    public Room getLocation() {
        return location;
    }

    public void setLocation(Room location) {
        this.location = location;
        printCurrentLocation();
    }
}
