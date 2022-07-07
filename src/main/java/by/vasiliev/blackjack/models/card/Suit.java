package by.vasiliev.blackjack.models.card;

import lombok.Getter;

@Getter
public enum Suit {
    CLUBS("CLUBS"),
    DIAMONDS("DIAMONDS"),
    HEARTS("HEARTS"),
    SPADES("SPADES");


    private final String name;

    Suit(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }
}