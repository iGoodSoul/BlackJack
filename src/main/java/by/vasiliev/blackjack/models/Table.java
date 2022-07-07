package by.vasiliev.blackjack.models;


import by.vasiliev.blackjack.exceptions.ApiRequestException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Table {

    private final ArrayList<Seat> playerSeats;

    private static final int MAX_BLACKJACK_SEATS = 5;

    public Table() {
        ArrayList<Seat> seats = new ArrayList<>();
        for (int i = 0; i < MAX_BLACKJACK_SEATS; i++) {
            Seat seat = new Seat(i+1,false);
            seats.add(seat);
        }
        this.playerSeats = seats;
    }

    public String sitPlayer(int seatNumber, Player player) throws ApiRequestException {
        if(this.playerSeats.get(seatNumber).isTaken()){
            throw  new ApiRequestException("This seat is already taken");
        }else {
            this.playerSeats.get(seatNumber).sitPlayer(player);
            player.setSeatNumber(seatNumber);
            playerSeats.get(seatNumber).setTaken(true);
            return "Player " + player.getName() + " has been seated successfully";
        }
    }

    public List<Seat> getPlayerSeats() {
        return playerSeats;
    }
}