package main;

import main.game.Game;
import main.game.Player;

public class Main {

    public static void main(String[] args) {
        Player player1 = new Player("main.game.Player 1");
        Player player2 = new Player("main.game.Player 2");

        player1.initialize();
        player2.initialize();

        Game game = new Game();
        game.startGame(player1, player2);
    }
}
