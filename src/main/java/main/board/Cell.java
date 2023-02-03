package main.board;

import main.ship.Ship;

public class Cell {

    private CellStatus cellStatus;
    private Ship takenBy;

    public Cell(int positionX, int positionY, CellStatus cellStatus, Ship takenBy) {
        this.cellStatus = cellStatus;
        this.takenBy = takenBy;
    }

    public CellStatus getCellStatus() {
        return cellStatus;
    }

    public void setCellStatus(CellStatus cellStatus) {
        this.cellStatus = cellStatus;
    }

    public Ship getTakenBy() {
        return takenBy;
    }

    public void setTakenBy(Ship takenBy) {
        this.takenBy = takenBy;
    }
}
