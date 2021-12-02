/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author Ahmed
 */
public class Card {
    private int suit; // 0 1 2 3
    private int rank; //   0 1 2 3 4 5 6 7 8 9 10 11 12
    private int value; // 1 2 3 4 5 6 7 8 9 10 10 10 10

    public Card(int suit, int rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }
    
    Card(Card card){
        this.suit = card.suit;
        this.rank = card.rank;
        this.value = card.value;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
  
    
}
