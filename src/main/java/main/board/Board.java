package main.board;

import main.game.Player;
import main.ship.Ship;
import java.util.Objects;

public class Board {

     private final int MAP_WIDTH = 10;
     private final int MAP_HEIGHT = 10;
     private final String BORDER = "---------------------";
     private Cell[][] map = new Cell[MAP_WIDTH][MAP_HEIGHT];

    public Cell[][] getMap() {
        return map;
    }

    public void generateMap() {
        for (int row = 0; row < MAP_HEIGHT; row++) {
            for (int col = 0; col < MAP_WIDTH; col++) {
                    map[row][col] = new Cell(row, col, CellStatus.EMPTY, null);
            }
        }
    }

    public void printMap (Cell[][] map) {
        char firstChar = 'A';
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for (int row = 0; row < MAP_HEIGHT; row++) {
            System.out.print(firstChar + " ");
            firstChar++;
            for (int col = 0; col < MAP_WIDTH; col++) {
                System.out.print(map[row][col].getCellStatus().getStatus() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void assignShipToCell (int row, int col, Ship ship) {
        map[row][col].setCellStatus(CellStatus.TAKEN);
        map[row][col].setTakenBy(ship);
    }

    public boolean checkCollision (int[][] coordinates){
        int beginX = coordinates[0][0];
        int beginY = coordinates[0][1];
        int endX = coordinates[1][0];
        int endY = coordinates[1][1];
        boolean doesCollide = false;

        try {
            for (int x = beginX - 1; x <= endX + 1; x++) {
                for (int y = beginY - 1; y <= endY + 1; y++) {
                    if (map[x][y].getCellStatus().equals(CellStatus.TAKEN)) {
                        doesCollide = true;
                        break;
                    }
                }
            }

        } catch (ArrayIndexOutOfBoundsException ignored) {

        }

    return doesCollide;
    }

    public void printMapHiddenBehindFog (Cell[][] map) {
        char firstChar = 'A';
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for (int row = 0; row < MAP_HEIGHT; row++) {
            System.out.print(firstChar + " ");
            firstChar++;
            for (int col = 0; col < MAP_WIDTH; col++) {
                CellStatus status = map[row][col].getCellStatus();

                if (Objects.requireNonNull(status) == CellStatus.TAKEN) {
                    System.out.print("~ ");
                } else {
                    System.out.print(status.getStatus() + " ");
                }
            }
            System.out.println();
        }
    }

    public void printGameMap (Player shootingPlayer, Player playerBeingShot) {
        Cell[][] mapOfShootingPlayer = shootingPlayer.getBoard().getMap();
        Cell[][] mapOfPlayerBeingShot = playerBeingShot.getBoard().getMap();

        this.printMapHiddenBehindFog(mapOfPlayerBeingShot);
        System.out.println(BORDER);
        this.printMap(mapOfShootingPlayer);
    }
}
