/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Games.Blackjack;

import deckofcards.Deck;

/**
 *
 * @author owen
 */
public class Blackjack {
    private static final int maxHandSize = 21;
    private Deck deck;
    private BlackJackHand playerHand;
    private BlackJackHand dealerHand;
    
    public Blackjack(){
        deck = new Deck();
        deck.shuffleDeck(10);
        playerHand = new BlackJackHand();
        dealerHand = new BlackJackHand();
    }
    
    public void deal(){
        playerHand.addCard(deck.draw());
        playerHand.addCard(deck.draw());
        dealerHand.addCard(deck.draw());
        dealerHand.addCard(deck.draw());
    }
    
    public void dealerHit(){
        dealerHand.addCard(deck.draw());
    }
    
    public void playerHit(){
        playerHand.addCard(deck.draw());
    }
    
    public int getPlayerTotal(){
        return playerHand.getScore();
    }
    
    public int getDealerTotal(){
        return dealerHand.getScore();
    }
    
    public String getPlayerCards(){
        return playerHand.toString();
    }
    
    public String getDealerCards(){
        return dealerHand.toString();
    }
}
