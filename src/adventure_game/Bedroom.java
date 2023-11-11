package adventure_game;

public class Bedroom extends Room {

    private static final String name = "bedroom";

    @Override
    public String getName() {
        return name;
    }

    @Override
    void printAvailableActionsInRoom() {

    }

    @Override
    int chooseAction() {
        return 0;
    }
}
