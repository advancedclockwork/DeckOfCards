/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Games.Texas;

import Games.Hand;
import deckofcards.Card;
import java.util.ArrayList;

/**
 *
 * @author owen
 */
public class TexasHand extends Hand {
    
    public TexasHand(){
        hand = new ArrayList();
    }
    
    public ArrayList<Card> getCards(){
        return hand;
    }
    
}
