package by.vasiliev.blackjack.models.card;



public enum Rank {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10),
    ACE(11);


    private final int cardRank;

    Rank(int cardRank) {
        this.cardRank = cardRank;
    }

    public int getCardRank() {
        return cardRank;
    }
}