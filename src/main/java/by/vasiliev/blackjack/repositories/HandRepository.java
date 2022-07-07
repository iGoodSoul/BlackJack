package by.vasiliev.blackjack.repositories;

import by.vasiliev.blackjack.models.Hand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface HandRepository extends JpaRepository<Hand, Integer> {
}

