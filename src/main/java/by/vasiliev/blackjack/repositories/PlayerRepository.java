package by.vasiliev.blackjack.repositories;

import by.vasiliev.blackjack.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface PlayerRepository extends JpaRepository<Player,Integer> {
    @Override
    List<Player> findAll();
}