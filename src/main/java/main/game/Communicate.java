package main.game;

public enum Communicate {

    HIT ("You hit a main.ship! Try again:"),
    MISS ("You missed!"),
    SUNK ("You sank a main.ship! Specify a new target:"),
    WON ("You sank the last main.ship. You won. Congratulations!");

    Communicate(String communicate) {
        this.communicate = communicate;
    }

    public String getCommunicate() {
        return communicate;
    }

    private String communicate;

}
