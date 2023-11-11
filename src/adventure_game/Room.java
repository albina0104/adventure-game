package adventure_game;

public abstract class Room {

    public abstract String getName();

    abstract void printChoices();

    abstract Choice chooseAction();
}
