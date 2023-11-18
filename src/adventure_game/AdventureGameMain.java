package adventure_game;

public class AdventureGameMain {

    public static void main(String[] args) {
        Player player = new Player();

        player.printStats();
        player.printCurrentLocation();

        do {
            player.chooseAction();
        } while (player.getHealthScore() >= 0);

        System.out.println("Game over! You are dead.");
    }
}
