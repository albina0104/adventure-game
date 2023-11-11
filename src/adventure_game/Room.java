package adventure_game;

public abstract class Room {

    public abstract String getName();

    abstract void printAvailableActionsInRoom();

    abstract int chooseAction();
}
