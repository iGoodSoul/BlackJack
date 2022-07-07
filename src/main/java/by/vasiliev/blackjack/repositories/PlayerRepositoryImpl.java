package by.vasiliev.blackjack.repositories;

import by.vasiliev.blackjack.models.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerRepositoryImpl implements PlayerRepository {

    private final List<Player> players = new ArrayList<>();

    @Override
    public void save(Player player) {
        players.add(player);
    }

    @Override
    public List<Player> findAll() {
        return players;
    }

    @Override
    public Optional<Player> findById(int playerId) {
        for (Player player : players) {
            if (playerId == player.getPlayerId()) {
                return Optional.of(player);
            }
        }
        return Optional.empty();
    }
}
