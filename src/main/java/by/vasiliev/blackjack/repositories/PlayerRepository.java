package by.vasiliev.blackjack.repositories;

import by.vasiliev.blackjack.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Repository
public interface PlayerRepository /*extends JpaRepository<Player,Integer> */ {
   void save(Player player);
   List<Player> findAll();
   Optional<Player> findById(int playerId);

}