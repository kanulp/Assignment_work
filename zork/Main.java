public class Main {
    public static void main(String[] args) {

        Game game = new Game();
        Player player = game.createPlayer();
        game.printPlayer(player);
        game.playGame(player);
    }
}
