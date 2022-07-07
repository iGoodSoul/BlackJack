package by.vasiliev.blackjack.models;

import by.vasiliev.blackjack.models.card.Card;
import by.vasiliev.blackjack.models.card.CardType;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;


public final class Deck {


    private final Stack<Card> cards;


    public Deck() {
        this.cards = new Stack<>();
        for (int i = 0; i < 6; i++) {
            Arrays.stream(CardType.values()).forEach(c -> cards.add(new Card(c)));
            Collections.shuffle(cards);
        }
    }


    public Card getCard() {
        return this.cards.pop();
    }


    public int getNumberOfCards() {
        return cards.size();
    }

}