/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.Scanner;

/**
 *
 * @author Ahmed
 */
public class BlackJack {

    /**
     * @param args the command line arguments
     */
    static Game game = new Game();
    public static void main(String[] args) {
        GUI gui = new GUI();
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        game.generateCard();   
        game.playersInformation();
        
       gui.runGUI( game.card, game.player[0].arrOfCard, 
               game.player[1].arrOfCard,
               game.player[2].arrOfCard,
               game.player[3].arrOfCard );

        int te, move = 2;
        for(int st = 1;st < 4; st++){
            
            System.out.println("Player num #0"+ st + " Your Score = "  + game.player[st - 1].getScore());
            System.out.println("1) hit.\n2) stand.");
            te = in.nextInt();
            if(te == 2){
                move = 2;
                continue;
            }
           game.player[st-1].arrOfCard[move] = game.drawCard();
            gui.updatePlayerHand(game.player[st-1].arrOfCard[move], st-1);
           game.player[st-1].setScore(game.player[st-1].arrOfCard[move].getValue());          
           game.update();
           
           move++;
           if(game.player[st-1].getScore() == 21){
                System.out.println("Black Jack");
                game.player[st-1].setCheckBlackJack(true);
                game.player[st-1].setCheckWin(true);
                move = 2;
                continue;
           }
           
           if(game.player[st-1].getScore()> 21){
                System.out.println("Bust and Your Score : " +  game.player[st-1].getScore());
                move = 2;
                continue;
           }
         
           st--;
       }
        
        move = 2;
        boolean k = false;
        int dealersc = game.player[3].getScore();
        
        if((game.player[0].getScore() > 21 && game.player[1].getScore() > 21 && game.player[2].getScore() > 21) ||
               (dealersc > game.player[0].getScore() && dealersc > game.player[1].getScore() && dealersc > game.player[2].getScore()) )
        {
            k = true;
           gui.updateDealerHand(game.player[3].arrOfCard[1], game.card,k);
            
        }
        else{
            while(true){
                game.player[3].arrOfCard[move] = game.drawCard();
                game.player[3].setScore(game.player[3].arrOfCard[move].getValue());
                gui.updateDealerHand(game.player[3].arrOfCard[move], game.card, k);
                if(game.player[3].getScore() > game.getMaxScore() && game.player[3].getScore() >= 21){
                    game.setMaxScore(game.player[3].getScore());
                    break;
                }               
                move++;
            }
        }
        game.setCheckConGame(false);
        game.update();
        System.out.println("Max Score = " + game.getMaxScore());
        game.WhoWin();
    }
}