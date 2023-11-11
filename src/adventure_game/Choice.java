package adventure_game;

public class Choice {

    private final String description;
    private final Runnable action;

    public Choice(String description, Runnable action) {
        this.description = description;
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public void doAction() {
        action.run();
    }
}
