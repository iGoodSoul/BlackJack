package by.vasiliev.blackjack.services;


import by.vasiliev.blackjack.models.Dealer;
import by.vasiliev.blackjack.models.Hand;
import by.vasiliev.blackjack.models.Player;
import by.vasiliev.blackjack.models.card.Card;
import by.vasiliev.blackjack.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
    public class DealerServiceImpl implements DealerService {


        @Autowired
        Dealer dealer;

        @Autowired
        PlayerService playerService;

        @Autowired
        PlayerRepository playerRepository;


        @Override
        public Map<String, Hand> deal() {
            List<Player> activePlayers = playerService.getAllPlayers();
            Map<String,Hand> playerHands = new HashMap<>();
            dealPlayers(activePlayers, playerHands);


            return playerHands;
        }


        private void dealDealer(Map<String, Hand> playerHands) {
            if(dealer.getDealersHand().getCardsInHand().isEmpty()) {
                Card dealtCard = dealer.draw();
                dealer.getDealersHand().addCard(dealtCard);
                playerHands.put("Dealer", dealer.getDealersHand());
                dealer.getDealersHand().evaluateHand();
            }
        }


        private void dealPlayers(List<Player> activePlayers, Map<String, Hand> playerHands) {
            for (int i = 0; i < 2; i++) {
                for (Player player : activePlayers) {
                    Card dealtCard = dealer.draw();
                    if (player.getHands().isEmpty()) {
                        Hand playerHand = new Hand();
                        playerHand.setHandBet(player.getBet());
                        playerHand.addCard(dealtCard);
                        player.getHands().add(playerHand);
                    } else {
                        player.getHands().get(0).addCard(dealtCard);
                    }
                    player.getHands().get(0).evaluateHand();
                    playerHands.put(player.getName(), player.getHands().get(0));
                    playerRepository.save(player);
                }
                dealDealer(playerHands);
            }
        }

        @Override
        public Hand hitDealer() {
            while(dealer.mustDraw()){
                Card dealtCard = dealer.draw();
                dealer.getDealersHand().addCard(dealtCard);
                dealer.getDealersHand().evaluateHand();
            }

            return dealer.getDealersHand();
        }



        public int getNumberOfCards() {
            return dealer.getDeck().getNumberOfCards();
        }
    }

