package adventure_game;

import java.util.function.Consumer;

public abstract class Room extends Choice {

    public abstract String getDescription();

    abstract void printChoices();

    abstract Choice chooseAction();
}
