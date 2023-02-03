package main.ship;

import main.Utilities;
import main.board.Board;

import java.util.LinkedHashMap;
import java.util.Map;

public class Navy {

    public Map<String, Ship> getPlayerShipList() {
        return playerShipList;
    }

    private Map<String, Ship> playerShipList = new LinkedHashMap<>();

    public void deployPlayerShips(Board board) {
        for (ShipType shipType : ShipType.values()) {
            playerShipList.put(shipType.getName(), new Ship(shipType, shipType.getSize()));
        }

        for (Ship ship : playerShipList.values()) {
            int shipLength = ship.getHitPoints();
            String shipName = ship.getShipType().getName();
            System.out.printf("Enter the coordinates of the %s (%d cells):%n", shipName, shipLength);


            int[][] coordinates = Utilities.parseShipPlacementCoordinates(shipLength);
            boolean doesCollide = board.checkCollision(coordinates);
            while (doesCollide) {
                System.out.println("Error! Too close to another main.ship!");
                coordinates = Utilities.parseShipPlacementCoordinates(shipLength);
                doesCollide = board.checkCollision(coordinates);
            }
            ship.deployShip(coordinates, ship, board);
            board.printMap(board.getMap());
        }
    }
}
