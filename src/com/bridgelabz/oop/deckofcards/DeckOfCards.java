package com.bridgelabz.oop.deckofcards;

import java.util.ArrayList;
import java.util.Random;

public class DeckOfCards {
    String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    String[] ranks = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    ArrayList<Card> deck = new ArrayList<>();
    int[][] playerHand;
    Random random = new Random();

    DeckOfCards(){
        populateDeck();
    }

    void printDeck() {
        for (Card j : deck) {
            System.out.println(cardName(j.suit, j.rank));
        }
    }

    void populateDeck(){
        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 0; rank < 13; rank++) {
                deck.add(index, new Card(suit, rank));
                index++;
            }
        }
    }

    String cardName(int suit, int rank){
        return ranks[rank] + " of " + suits[suit];
    }

    void printCard(int index) {
        Card card = deck.get(index);
        System.out.println(cardName(card.suit, card.rank));
    }

    void deal(int playerCount, int cardCount){
        playerHand = new int[playerCount][cardCount];
        for (int i = 0; i < playerCount ; i++){
            System.out.println("Player " + (i+1) + " got: \n");
            for (int j = 0; j < cardCount; j++) {
                int randomCard = random.nextInt(deck.size());
                printCard(randomCard);
                playerHand[i][j] = randomCard;
                deck.remove(randomCard);
            }
            System.out.println("\n =================== \n");
        }

    }

    public static void main(String[] args) {
        DeckOfCards dc = new DeckOfCards();
        dc.deal(4,9);
    }

}
