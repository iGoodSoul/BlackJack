package by.vasiliev.blackjack.models;

import by.vasiliev.blackjack.models.card.Card;
import org.springframework.stereotype.Component;


@Component
public class Dealer {


    private final Deck deck;


    private Hand dealersHand;

    private boolean mustDraw = true;

    public Dealer() {
        this.deck = new Deck();
        this.dealersHand = new Hand();
    }


    public Card draw(){
        return deck.getCard();

    }

    public Deck getDeck() {
        return deck;
    }

    public Hand getDealersHand() {
        return dealersHand;
    }

    public void setDealersHand(Hand dealersHand) {
        this.dealersHand = dealersHand;
    }

    public boolean mustDraw() {
        String dealerHand = dealersHand.getHandValue();
        if(dealerHand.equals("7/17") || dealerHand.equals("8/18") || dealerHand.equals("9/19")  || dealerHand.equals("10/20")){
            mustDraw = false;
        }else if(dealerHand.length() == 2){
            int handValue = Integer.parseInt(dealerHand);
            if(handValue>= 17 && handValue<= 21){
                mustDraw = false;
            }
        }else if(dealerHand.contains("Bust") || dealerHand.contains("BlackJack")){
            mustDraw = false;
        }

        return mustDraw;
    }
}