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
public class Player {
    
    private final String Name;
    private int Score = 0;
    Card []arrOfCard = new Card[11];
   private boolean checkBlackJack = false;
   private boolean checkWin = false;
    Player(String name){
        this.Name = name;
    }

    public void setScore(int Score) {
        this.Score += Score;
    }

    public void setArrOfCard(Card[] arrOfCard) {
        this.arrOfCard = arrOfCard;
    }

    public void setCheckBlackJack(boolean checkBlackJack) {
        this.checkBlackJack = checkBlackJack;
    }

    public void setCheckWin(boolean checkWin) {
        this.checkWin = checkWin;
    }

    public String getName() {
        return Name;
    }

    public int getScore() {
        return Score;
    }

    public Card[] getArrOfCard() {
        return arrOfCard;
    }

    public boolean isCheckBlackJack() {
        return checkBlackJack;
    }

    public boolean isCheckWin() {
        return checkWin;
    }
    
}
