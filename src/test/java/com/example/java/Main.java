package com.example.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    WebDriver webDriver;

    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Sumanth\\.cache\\selenium\\chromedriver\\win64\\119.0.6045.105\\chromedriver.exe");

        webDriver = new ChromeDriver();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        // Press Opt+Enter with your caret at the highlighted text to see how IntelliJ suggests to fixing it.
        Main mObj = new Main();
        mObj.setUp();

        //Exercise 1
        CheckersGame checkersPage = new CheckersGame(mObj.webDriver);
        checkersPage.navigate();
        checkersPage.makeMoves(5);
        System.out.println("End of exercise1");
        Thread.sleep(5000);

        //Exercise 2
        DeckOfCards deckOfCards = new DeckOfCards(mObj.webDriver);
        deckOfCards.navigate();

        Deck shuffledDeck = Utils.shuffleDeck();

        System.out.println("Shuffled Deck id is " + shuffledDeck.deck_id);

        DrawResponse drawResponse = Utils.drawCards(shuffledDeck.deck_id, 6);

        System.out.println("Draw Response size is " + drawResponse.cards.size());

        List<Integer> player1Cards = new ArrayList<>();
        List<Integer> player2Cards = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            int cardValue;
            if( drawResponse.cards.get(i).value.equals("KING") || drawResponse.cards.get(i).value.equals( "QUEEN") || drawResponse.cards.get(i).value.equals( "JACK")){
                cardValue = 10;
            }
            else if(drawResponse.cards.get(i).value.equals( "ACE")) {
                cardValue =11;
            }
            else {
                cardValue = Integer.parseInt(drawResponse.cards.get(i).value);
            }

            if (i / 2 == 0) {
                player1Cards.add(cardValue);
            } else {
                player2Cards.add(cardValue);
            }
        }

        for(int i: player1Cards){
            System.out.println("Player1 card:" + i);
        }

        for(int i: player2Cards){
            System.out.println("Player2 card:" + i);
        }

        player1Cards.sort(Comparator.reverseOrder());
        player2Cards.sort(Comparator.reverseOrder());

        int p1Count = player1Cards.get(0) + player1Cards.get(1);
        int p2Count = player2Cards.get(0) + player2Cards.get(1);

        System.out.println("Player 1 total:" + p1Count);

        System.out.println("Player 2 total:" + p2Count);

        if(p1Count == 21){
            System.out.println("Player 1 has black jack");
        }

        if(p2Count == 21){
            System.out.println("Player 2 has black jack");
        }
    }
}