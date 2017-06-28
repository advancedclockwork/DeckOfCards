/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Games.Blackjack;

import Games.Hand;
import deckofcards.Card;
import java.util.ArrayList;

/**
 *
 * @author owen
 */
public class BlackJackHand extends Hand {
    private int numberOfAces;
    private int score;
    
    public BlackJackHand(){
        hand = new ArrayList();
        numberOfAces = 0;
        score = 0;
    }
    
    @Override
    public void addCard(Card card){
        if(card.getName().equals("Ace")){
            numberOfAces++;
        }
        hand.add(card);
        totalScore();
    }
    
    public int getScore(){
        return score;
    }
    
    private void totalScore(){
        int temp = 0;
        for(int i = 0; i < hand.size(); i++){
            Card current = hand.get(i);
            if(current.getNumber() == 12 || current.getNumber() == 13){
                temp+=11;
            }
            else{
                temp+= current.getNumber();
            }
        }
        if(temp < 12 && numberOfAces > 0){
            temp += 10;
        }
        score = temp;
    }
}
