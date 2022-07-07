package by.vasiliev.blackjack.models;

public class Seat {
    private Player player;

    private final int seatNumber;

    private boolean isTaken;

    public Seat(int seatNumber, boolean isTaken) {
        this.seatNumber = seatNumber;
        this.isTaken = isTaken;
    }

    public Player getPlayer() {
        return player;
    }

    public void sitPlayer(Player player) {
        this.player = player;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }
}
