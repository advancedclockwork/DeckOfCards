/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deckofcards;

import Games.Blackjack.Blackjack;
import Games.Texas.Texas;

/**
 *
 * @author owen
 */
public class DeckOfCards {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Blackjack blackjack = new Blackjack();
        //blackjack.deal();
        //blackjack.dealerHit();
        //blackjack.playerHit();
        //System.out.println("player: " + blackjack.getPlayerTotal()+" dealer: "+ blackjack.getDealerTotal());
        //System.out.println(blackjack.getPlayerCards());
        //System.out.println(blackjack.getDealerCards());
        
        Texas texas = new Texas();
        texas.deal();
        texas.flop();
        texas.turn();
        texas.river();
        System.out.println(texas.checkHand());
        
    }
    
}
