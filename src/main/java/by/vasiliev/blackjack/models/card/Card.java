package by.vasiliev.blackjack.models.card;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;


public final class Card implements Serializable {

    @Enumerated(EnumType.STRING)
    private final CardType name;

    @Autowired
    public Card(CardType name) {
        this.name = name;
    }

    public CardType getName() {
        return name;
    }

    public int getRank() {
        return name.getRank().getCardRank();
    }

    public boolean isAce(){
        return name.getRank().getCardRank() == 11;
    }
}