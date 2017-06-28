/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deckofcards;

/**
 *
 * @author owen
 */
public class Card {
    private final String suit;
    private final String name;
    private final int number;
    private boolean up = false;
    public Card(String suit, String name, int number){
        this.suit = suit;
        this.name = name;
        this.number = number;
    }
    public void flip(){
        if (up == true){
            up = false;
        }
        else{
            up = true;
        }
    }
    public String getSuit(){
        return suit;
    }
    public String getName(){
        return name;
    }
    public int getNumber(){
        return number;
    }
    
    public void printCard(){
        System.out.println(number + ": " +name + " of " + suit);
    }
}
