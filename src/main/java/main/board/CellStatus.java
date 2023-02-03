package main.board;

import java.util.HashMap;
import java.util.Map;

public enum CellStatus {
    EMPTY ('~'),
    FOG_OF_WAR ('~'),
    TAKEN ('O'),
    HIT ('X'),
    MISS ('M');

    private final char status;

    CellStatus(char status) {
        this.status = status;
    }

    private static final Map<Character, CellStatus> BY_STATUS = new HashMap<>();

    static {
        for (CellStatus c : values()) {
            BY_STATUS.put(c.status, c);
        }
    }

    public char getStatus() {
        return status;
    }

    public static CellStatus valueOfStatus(Character status) {
        return BY_STATUS.get(status);
    }
}
