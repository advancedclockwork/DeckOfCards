/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Games.Texas;

import deckofcards.Card;
import deckofcards.Deck;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author owen
 */
public class Texas {
    private final Deck deck;
    private final TexasHand playerHand;
    private final Card[] board;
    
    public Texas(){
        deck = new Deck();
        deck.shuffleDeck(10);
        playerHand = new TexasHand();
        board = new Card[5];
    }
    
    public void deal(){
        playerHand.addCard(deck.draw());
        playerHand.addCard(deck.draw());
    }
    
    public void flop(){
        board[0] = deck.draw();
        board[1] = deck.draw();
        board[2] = deck.draw();
    }
    
    public void turn(){
        board[3] = deck.draw();
    }
    
    public void river(){
        board[4] = deck.draw();
    }
    
    public Card[] getBoard(){
        return board;
    }
    
    public void printBoard(){
        ArrayList<Card> temp = new ArrayList<>(playerHand.getCards());
        temp.addAll(Arrays.asList(board));
        for(int i = 0; i < temp.size(); i++){
            if(temp.get(i) != null){
                temp.get(i).printCard();
            }
            else{
                break;
            }
        }
        System.out.println("");
    }
    
    public String checkHand(){
        int spades = 0, hearts = 0, clubs = 0, diamonds = 0;
        int[] cards = new int[13];
        ArrayList<Card> temp = new ArrayList<>(playerHand.getCards());
        temp.addAll(Arrays.asList(board));
        for(int i = 0; i < temp.size(); i++){
            Card tempCard = temp.get(i);
            cards[tempCard.getNumber()-1]++;
            
            tempCard.printCard();
            switch (tempCard.getSuit()) {
                case "Spades":
                    spades++;
                    break;
                case "Hearts":
                    hearts++;
                    break;
                case "Clubs":
                    clubs++;
                    break;
                case "Diamonds":
                    diamonds++;
                    break;
                default:
                    break;
            }
        }
        int highCard = 0;
        int two = 0;
        int three = 0;
        int four = 0;
                
        for(int i = 0; i < cards.length - 5; i++){
            if (cards[i] != 0){
                for(int j = i; j< i+5; j++){
                    if(cards[j] == 0){
                        highCard = 0;
                        break;
                    }
                    else{
                        highCard = cards[j];
                    }
                }
            }
        }
        for(int i = 0; i < cards.length; i++){
            if(cards[i] == 2){
                two++;
            }
            if(cards[i] == 3){
                three++;
            }
            if(cards[i] == 4){
                four++;
            }
        }
        String toPrint = "";
        for(int i = 0;i<cards.length;i++){
            toPrint += i + ": " + cards[i] + ", "; 
        }
        if(spades >= 5 || hearts >= 5 || diamonds >= 5 || clubs >= 5 && highCard == 12){
            return "Royal Flush";
        }
        if(spades >= 5 || hearts >= 5 || diamonds >= 5 || clubs >= 5 && highCard != 0){
            return "Straight Flush";
        }
        if(four > 0){
            return "Four of a kind";
        }
        if(three > 0 && two > 0){
            return "Full House";
        }
        if(spades >= 5 || hearts >= 5 || diamonds >= 5 || clubs >= 5){
            return "Flush";
        }
        if(highCard != 0){
            return "Straight";
        }
        if(three > 0){
            return "Three of a kind";
        }
        if(two > 0){
            if(two > 1){
                return "Two Pair";
            }
            else{
                return "Pair";
            }
        }
        return "nothing";
    }
}
