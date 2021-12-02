/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Ahmed
 */
public class Game {
    
    Player []player = new Player[4];
    Card []card = new Card[52];
    private boolean checkConGame = true;
    Random rand = new Random();
    private int randomChoice;
    private int maxScore = 0;
    
    public void generateCard(){       

        int k = 0;
        int index = 0;
      
    for(int i = 0; i < 4; i++){
            for(int j = 1; j <= 13; j++){
                if(j < 10){
                    card[index] = new Card(i, k, j);
                }
                else{
                    card[index] = new Card(i, k, 10);
                } 
                if(k == 12)
                    k = -1;
                k++;
                index++;
            }      
       }
}
   
    public Card drawCard(){
        
        
        randomChoice = rand.nextInt(52);
        Card cardChoiced;
        while(true){
            randomChoice = rand.nextInt(52);
            cardChoiced = card[randomChoice];
            if(cardChoiced != null)
                break;
        }
        card[randomChoice] = null;
        return cardChoiced;

    }
    String sname;
    public void playersInformation(){
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < 4; i++){
            
            System.out.println("Enter Your Name, Player #0"+ (i+1) +":");
            sname = in.next();
            player[i] = new Player(sname);
            player[i].arrOfCard[0]=drawCard();
            player[i].setScore(player[i].arrOfCard[0].getValue());
            player[i].arrOfCard[1]=drawCard();
            player[i].setScore(player[i].arrOfCard[1].getValue());
            
        }
        update();
    }
    
    public void update(){
        int a = player[0].getScore(),b = player[1].getScore(), c = player[2].getScore(), d = player[3].getScore();
        if(a > 21){
            a = 0;
        }
         if(b > 21){
            b = 0;
        }
          if(c > 21){
            c = 0;
        }
           if(d > 21){
            d = 0;
        }
            
        maxScore = Math.max(Math.max(a, b),  Math.max(c, d));
            
    }
    public void WhoWin(){
        int w = 0;
        int nw = 0;
        for(int i = 0; i < 4; i++){
            if(player[i].getScore() != maxScore) {
                continue;
            }
            else{
                player[i].setCheckWin(true);
                if(maxScore == 21){
                    player[i].setCheckBlackJack(true);
                }
                w = i;
                nw++;
            }
           
        }
        if(nw > 1)
            System.out.println("Push Case");
        else if(nw == 1){
            System.out.println("player number  #0" + (w+1) +
                    " is Won\nand his name is " + player[w].getName()
                    + " \nand his score is : " +player[w].getScore() + " \nMAXsCORE IS : " + maxScore);
        }
    }

    public int getMaxScore() {
        return maxScore;
    }
    
    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public boolean isCheckConGame() {
        return checkConGame;
    }

    public void setCheckConGame(boolean checkConGame) {
        this.checkConGame = checkConGame;
    }
    
    
    
}