package adventure_game;

public abstract class Room extends Choice {

    public abstract String getDescription();

    abstract void printChoices();

    abstract Choice chooseAction();
}
