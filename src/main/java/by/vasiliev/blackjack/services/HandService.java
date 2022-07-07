package by.vasiliev.blackjack.services;

import by.vasiliev.blackjack.exceptions.ApiRequestException;
import by.vasiliev.blackjack.models.Player;

public interface HandService {
    void hit(Player player, int handId) throws ApiRequestException;
    void doubleDown(Player player, int handId) throws ApiRequestException;
    void split(Player player, int handId) throws ApiRequestException;
    void surrender(Player player, int handId) throws ApiRequestException;
    void stand(Player player, int handId) throws ApiRequestException;

}
