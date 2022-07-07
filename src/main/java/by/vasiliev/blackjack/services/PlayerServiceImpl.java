package by.vasiliev.blackjack.services;

import by.vasiliev.blackjack.exceptions.ApiRequestException;
import by.vasiliev.blackjack.models.Player;
import by.vasiliev.blackjack.models.Table;
import by.vasiliev.blackjack.models.dto.PlayerDTO;
import by.vasiliev.blackjack.repositories.PlayerRepository;
import by.vasiliev.blackjack.utilities.CustomModelMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PlayerServiceImpl implements PlayerService {


    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    HandService handService;

    @Autowired
    CustomModelMapper modelMapper;


    @Autowired
    Table table;

    public static final String PLAYER_NOT_FOUND = "Player with id: %s was not found";

    public static final String ACTION_NOT_ALLOWED = "Action with name: %s is not allowed";

    public static final String NOT_ENOUGH_BALANCE = "Player balance is not enough for player with id: %s";

    public static final String CANNOT_ADD_NEGATIVE_BALANCE = "Negative balance cannot be added: %s";


    @Override
    public Player createNewPlayer(PlayerDTO playerDTO) {
        Player player = modelMapper.convertFromPlayerDTO(playerDTO);
        playerRepository.save(player);

        return player;
    }


    public Player getPlayerById(int playerId) throws ApiRequestException {
        return isPlayerPresent(playerId);
    }



    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player placeBet(int playerId, double playerBet) throws ApiRequestException {
        Player player = isPlayerPresent(playerId);
        if(playerBet>player.getBalance()){
            throw new ApiRequestException(String.format(NOT_ENOUGH_BALANCE,playerId));
        }else{
            player.setBet(playerBet);
            player.setBalance(player.getBalance() - playerBet);
            playerRepository.save(player);
        }
        return player;
    }

    @Override
    public Player addBalanceToPlayer(int playerId, int playerBalanceToAdd) throws ApiRequestException {
        Player player = isPlayerPresent(playerId);
        if(playerBalanceToAdd<0){
            throw new ApiRequestException(String.format(CANNOT_ADD_NEGATIVE_BALANCE,playerBalanceToAdd));
        }else {
            player.setBalance(player.getBalance() + playerBalanceToAdd);
            playerRepository.save(player);
        }
        return player;
    }

    @Override
    public Player seatPlayer(int playerId, int playerSeat) throws ApiRequestException {
        Player player = isPlayerPresent(playerId);
        table.sitPlayer(playerSeat,player);
        playerRepository.save(player);
        return player;
    }

    @Override
    public Player hit(int playerId, int handId) throws ApiRequestException {
        Player player = isPlayerPresent(playerId);

        handService.hit(player,handId);
        playerRepository.save(player);
        return player;
    }

    @Override
    public Player doubleDown(int playerId, int handId) throws ApiRequestException {
        Player player = isPlayerPresent(playerId);

        handService.doubleDown(player,handId);
        playerRepository.save(player);

        return player;
    }

    @Override
    public Player stand(int playerId, int handId) throws ApiRequestException {
        Player player = isPlayerPresent(playerId);

        handService.stand(player,handId);
        playerRepository.save(player);

        return player;
    }

    @Override
    public Player split(int playerId, int handId) throws ApiRequestException {
        Player player = isPlayerPresent(playerId);
        handService.split(player,handId);
        playerRepository.save(player);

        return player;
    }

    @Override
    public Player surrender(int playerId, int handId) throws ApiRequestException {
        Player player = isPlayerPresent(playerId);
        handService.surrender(player,handId);
        playerRepository.save(player);

        return player;
    }

    private Player isPlayerPresent(int playerId) throws ApiRequestException {
        Optional<Player> playerToBet = playerRepository.findById(playerId);
        if(playerToBet.isPresent()){
            return playerToBet.get();
        }else{
            throw new ApiRequestException(String.format(PLAYER_NOT_FOUND,playerId));
        }

    }


    public Player executeAction(String action, int playerId, int handId) throws ApiRequestException {
        switch (action){
            case "hit" : return hit(playerId,handId);
            case "double" : return doubleDown(playerId,handId);
            case "split" : return split(playerId,handId);
            case "stand" : return stand(playerId,handId);
            case "surrender" : return surrender(playerId,handId);
            default: throw new ApiRequestException(String.format(ACTION_NOT_ALLOWED,action));
        }
    }
}