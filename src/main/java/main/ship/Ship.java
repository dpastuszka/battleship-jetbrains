package main.ship;

import main.board.Board;
import main.board.Cell;

public class Ship {

    private final ShipType shipType;
    private int beginX;
    private int beginY;
    private int endX;
    private int endY;
    private int hitPoints;
    private static Cell[] takenCells;


    public Ship(ShipType shipType, int hitPoints) {
        this.shipType = shipType;
        this.hitPoints = hitPoints;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void deployShip(int[][] coordinates, Ship ship, Board board) {
        String direction = coordinates[0][0] == coordinates[1][0] ? "horizontal" : "vertical";
        takenCells = new Cell[ship.hitPoints];
        Cell[][] map = board.getMap();
        int takenCellCounter = 0;

        if (direction.equals("horizontal")) {
            int row = coordinates[0][0];
            int colBegin = coordinates[0][1];
            int colEnd = coordinates[1][1];

            for (int col = colBegin; col <= colEnd; col++) {
                 board.assignShipToCell(row, col, ship);
                 takenCells[takenCellCounter] = map[row][col];
                 takenCellCounter++;

            }

        } else {
            int col = coordinates[0][1];
            int rowBegin = coordinates[0][0];
            int rowEnd = coordinates[1][0];

            for (int row = rowBegin; row <= rowEnd; row++) {
                board.assignShipToCell(row, col, ship);
                takenCells[takenCellCounter] = map[row][col];
                takenCellCounter++;
            }
        }
    }
}
