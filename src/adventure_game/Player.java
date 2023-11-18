package adventure_game;

import java.util.EnumMap;

public final class Player {
    private static final int MIN_SCORE = 0;
    private static final int MAX_SCORE = 100;
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
        stats.put(Stats.health, keepScoreInsideBounds(healthScore));
    }

    public int getHungerScore() {
        return stats.get(Stats.hunger);
    }

    public void setHungerScore(int hungerScore) {
        stats.put(Stats.hunger, keepScoreInsideBounds(hungerScore));
    }

    public int getSleepScore() {
        return stats.get(Stats.sleep);
    }

    public void setSleepScore(int sleepScore) {
        stats.put(Stats.sleep, keepScoreInsideBounds(sleepScore));
    }

    private int keepScoreInsideBounds(final int score) {
        if (score < MIN_SCORE) return MIN_SCORE;
        if (score > MAX_SCORE) return MAX_SCORE;
        return score;
    }

    public Room getLocation() {
        return location;
    }

    public void setLocation(Room location) {
        this.location = location;
        printCurrentLocation();
    }
}
