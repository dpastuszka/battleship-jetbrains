package main.game;

import main.Utilities;
import main.board.Board;
import main.ship.Navy;

public class Player {

    public Player(String name) {
        this.name = name;
    }

    private final String name;
    private Board board = new Board();
    private Navy navy = new Navy();

    public String getName() {
        return name;
    }

    public Navy getNavy() {
        return navy;
    }

    public Board getBoard() {
        return board;
    }

    public void initialize() {
        board.generateMap();
        System.out.printf("%s, place your ships on the game field\n\n", this.name);
        board.printMap(board.getMap());
        navy.deployPlayerShips(board);
        Utilities.promptEnterKey();
    }
}
