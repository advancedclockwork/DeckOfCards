/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deckofcards;

import deckofcards.Card;
import java.util.Random;
import java.util.Stack;

/**
 *
 * @author owen
 */
public class Deck {
    private Stack<Card> deck;
    private Stack<Card> discard;
    private final static int deckSize = 52;
    private int cardsRemaining;
    public Deck(){
        deck = createDeck();
        discard = new Stack<Card>();
    }
    
    private Stack<Card> createDeck(){
        Stack<Card> temp = new Stack<Card>();
        for(int i = 0; i < deckSize; i++){
            String suit = "";
            String name = "";
            int number;
            switch (i/13){
                case 0: 
                    suit = "Spades";
                    break;
                case 1: 
                    suit = "Hearts";
                    break;
                case 2: 
                    suit = "Clubs";
                    break;
                case 3: 
                    suit = "Diamonds";
                    break;
                default:
                    break;
            }
            switch (i%13){
                case 0:
                    name = "Ace";
                    break;
                case 1:
                    name = "Two";
                    break;
                case 2:
                    name = "Three";
                    break;
                case 3:
                    name = "Four";
                    break;
                case 4:
                    name = "Five";
                    break;
                case 5:
                    name = "Six";
                    break;
                case 6:
                    name = "Seven";
                    break;
                case 7:
                    name = "Eight";
                    break;
                case 8:
                    name = "Nine";
                    break;
                case 9:
                    name = "Ten";
                    break;
                case 10:
                    name = "Jack";
                    break;
                case 11:
                    name = "Queen";
                    break;
                case 12:
                    name = "King";
                    break;
                default:
                    break;
            }
            number = (i%13)+1;
            Card card = new Card(suit, name, number);
            temp.push(card);
        }
        cardsRemaining = deckSize;
        return temp;
    }
    
    public void shuffleDeck(int numberOfCuts){
        Stack<Card> cut1 = new Stack<Card>();
        Stack<Card> cut2 = new Stack<Card>();
        Random random = new Random();
        for(int j = 0; j < numberOfCuts; j++){
            for(int i = 0; i < cardsRemaining/2; i++){
                cut1.push(deck.pop());
            }
            while(!deck.empty()){
                cut2.push(deck.pop());
            }
            while(!cut1.empty() && !cut2.empty()){
                int next = random.nextInt()%2;
                if(next == 0){
                    deck.push(cut1.pop());
                }
                else{
                    deck.push(cut2.pop());
                }
            }
            while(!cut1.empty()){
                deck.push(cut1.pop());
            }
            while(!cut2.empty()){
                deck.push(cut2.pop());
            }
        }
    }
    
    public Card draw(){
        Card card = deck.peek();
        discard.push(deck.pop());
        cardsRemaining--;
        return card;
    }
    
    public int getCardsRemaining(){
        return cardsRemaining;
    }
    
    
    
}
