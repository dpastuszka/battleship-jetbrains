package main.game;

import main.Utilities;
import main.board.Board;
import main.board.Cell;
import main.board.CellStatus;
import main.ship.Navy;
import main.ship.Ship;

import java.util.Map;

public class Game {

    GameStatus status = GameStatus.RUNNING;

    public void startGame(Player player1, Player player2) {
        System.out.println("The game starts!");

        while (status == GameStatus.RUNNING) {

            if (status == GameStatus.RUNNING) {
                round(player1, player2);
            }
            if (status == GameStatus.RUNNING) {
                round(player2, player1);
            }
        }
    }

    public void shootAt (Player player) {
        Board board = player.getBoard();
        Navy navy = player.getNavy();

        int[][] shootAt = Utilities.parseShootCoordinates();
        int pointX = shootAt[0][0];
        int pointY = shootAt[0][1];

        Cell[][] map = board.getMap();
        Cell target = map[pointX][pointY];
        CellStatus targetStatus = target.getCellStatus();
        String communicate = null;

        switch (targetStatus) {
            case TAKEN -> {
                target.setCellStatus(CellStatus.HIT);
                Map<String, Ship> playerShipList = navy.getPlayerShipList();
                Ship targetShip = target.getTakenBy();
                int targetHP = target.getTakenBy().getHitPoints();

                if (targetHP > 1) {
                    communicate = Communicate.HIT.getCommunicate();
                    targetShip.setHitPoints(targetHP - 1);
                } else if (targetHP == 1) {
                    playerShipList.remove(targetShip.getShipType().getName());
                    if (playerShipList.isEmpty()) {
                        communicate = Communicate.WON.getCommunicate(); ;
                    } else {
                        communicate = Communicate.SUNK.getCommunicate();
                    }
                } else {
                    communicate = Communicate.HIT.getCommunicate();
                }

                board.printMapHiddenBehindFog(board.getMap());
                System.out.println(communicate);
            }
            case EMPTY -> {
                target.setCellStatus(CellStatus.MISS);
                board.printMapHiddenBehindFog(board.getMap());
                communicate = Communicate.MISS.getCommunicate();
            }
        }
        System.out.println(communicate);
    }

    private void round (Player shootingPlayer, Player playerBeingShot) {
        shootingPlayer.getBoard().printGameMap(shootingPlayer, playerBeingShot);
        String shootingPlayerName = shootingPlayer.getName();
        System.out.printf("%s, it's your turn:\n", shootingPlayerName);

        this.shootAt(playerBeingShot);
        if (playerBeingShot.getNavy().getPlayerShipList().isEmpty()) {
            status = GameStatus.ENDED;
        }
        if (status != GameStatus.ENDED){
            Utilities.promptEnterKey();
        }
    }
}
