package by.vasiliev.blackjack.services;

import by.vasiliev.blackjack.models.Hand;

import java.util.Map;



    public interface DealerService {

        Map<String, Hand> deal();

        Hand hitDealer();
    }

