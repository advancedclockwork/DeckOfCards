/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Games;

import deckofcards.Card;
import java.util.ArrayList;

/**
 *
 * @author owen
 */
public class Hand {
    protected ArrayList<Card> hand;
    
    public void addCard(Card card){
        hand.add(card);
    }
    
    public String toString(){
        String cards = "";
        for(int i = 0; i < hand.size(); i++){
            cards += "card " + i + ": " + hand.get(i).getName() + " of " + hand.get(i).getSuit() + '\n';
        }
        return cards;
    }
}
