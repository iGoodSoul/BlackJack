package by.vasiliev.blackjack.services;

import by.vasiliev.blackjack.exceptions.ApiRequestException;
import by.vasiliev.blackjack.models.Player;
import by.vasiliev.blackjack.models.dto.PlayerDTO;

import java.util.List;

public interface PlayerService {
    Player createNewPlayer(PlayerDTO player);

    List<Player> getAllPlayers();

    Player placeBet(int playerId, double playerBet) throws ApiRequestException;

    Player addBalanceToPlayer(int playerId, int playerBalanceToAdd) throws ApiRequestException;

    Player seatPlayer(int playerId, int playerSeat) throws ApiRequestException;

    Player hit(int playerId, int handId) throws ApiRequestException;

    Player doubleDown(int playerId, int handId) throws ApiRequestException;

    Player stand (int playerId, int handId) throws ApiRequestException;

    Player split (int playerId, int handId) throws ApiRequestException;

    Player surrender (int playerId, int handId) throws ApiRequestException;

}
