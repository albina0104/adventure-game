package adventure_game;

import java.util.function.Consumer;

public class ActionChoice extends Choice {
    private final String description;
    private final Consumer<Player> action;

    public ActionChoice(String description, Consumer<Player> action) {
        this.description = description;
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public void doAction(Player player) {
        action.accept(player);
    }
}
