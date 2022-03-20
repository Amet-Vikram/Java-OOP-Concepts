package com.bridgelabz.oop.deckofcards;

public class Player {

    int cardCount;
    Card[] playerHand = new Card[cardCount];

    Player(int cardCount){
        this.cardCount = cardCount;
    }

}
