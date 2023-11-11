package adventure_game;

public class AdventureGameMain {

    public static void main(String[] args) {
        Player player = new Player();

        player.printStats();
        player.printCurrentLocation();
        player.chooseAction();
    }
}
