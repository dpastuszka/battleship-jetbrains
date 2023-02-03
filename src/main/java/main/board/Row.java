package main.board;

public enum Row {

    A(0), B(1), C(2), D(3), E(4), F(5), G(6), H( 7), I(8), J(9);

    private final int rowNumber;

    Row(int i) {
        this.rowNumber = i;
    }

    public int getRowNumber() {
        return rowNumber;
    }
}
