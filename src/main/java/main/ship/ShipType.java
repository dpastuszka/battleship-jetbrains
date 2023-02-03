package main.ship;

public enum ShipType {

    AIRCRAFT_CARRIER(5, "Aircraft Carrier"),
    BATTLESHIP(4, "Battleship"),
    SUBMARINE(3, "Submarine"),
    CRUISER(3, "Cruiser"),
    DESTROYER(2, "Destroyer");

    private final int  size;
    private final String name;

    ShipType(int size, String name) {
        this.name = name;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public static ShipType getValue (String name) {
        for(ShipType shipType : ShipType.values()) {
            if (shipType.name == name) {
                return shipType;
            }
        }
        return null;
    }
}
