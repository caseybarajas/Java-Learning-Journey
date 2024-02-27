/*
 * Casey Barajas
 * 01/20/24
 * 
 * This program is a game of Go Fish.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Fish {
    private List<Card> deck = new ArrayList<>();
    private Player player = new Player();
    private Player computer = new Player();
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    public Fish() {
        initializeDeck();
        shuffleDeck();
        dealInitialCards();
    }

    private void initializeDeck() {
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(new Card(rank, suit));
            }
        }
    }

    private void shuffleDeck() {
        Collections.shuffle(deck);
    }

    private void dealInitialCards() {
        for (int i = 0; i < 7; i++) {
            player.drawCard(deck.remove(0));
            computer.drawCard(deck.remove(0));
        }
    }

    private void playGame() {
        System.out.println("\nStarting Go Fish!");
        while (!deck.isEmpty() && !player.isHandEmpty() && !computer.isHandEmpty()) {
            playerTurn();
            computerTurn();
        }

        System.out.println("\nGame over! You made " + player.getPairsCount() + " pairs. Computer made " + computer.getPairsCount() + " pairs.");
    }

    private void playerTurn() {
        System.out.println("\nYour hand: " + player.getHand());
        System.out.print("\nWhich card do you want to ask for? ");
        String askedRank = scanner.nextLine();

        if (askComputer(askedRank)) {
            System.out.println("\nYou got a card from the computer!");
        } else {
            System.out.println("\nGo Fish!");
            if (!deck.isEmpty()) {
                player.drawCard(deck.remove(0));
            }
        }
    }

    private boolean askComputer(String rank) {
        for (Card card : computer.getHand()) {
            if (card.getRank().equals(rank)) {
                player.drawCard(card);
                computer.getHand().remove(card); // Fix: Remove the card from the computer's hand
                return true;
            }
        }
        return false;
    }

    private void computerTurn() {
        try {
            String askedRank = getRandomRankFromHand(computer);
            System.out.println("\nComputer wants: " + askedRank);
            Thread.sleep(1000);

            if (askPlayer(askedRank)) {
                System.out.println("\nComputer got a card from you!");
            } else {
                System.out.println("\nComputer goes fishing!");
                if (!deck.isEmpty()) {
                    computer.drawCard(deck.remove(0));
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private boolean askPlayer(String rank) {
        for (Card card : player.getHand()) {
            if (card.getRank().equals(rank)) {
                computer.drawCard(card);
                player.getHand().remove(card); // Fix: Remove the card from the player's hand
                return true;
            }
        }
        return false;
    }

    private String getRandomRankFromHand(Player player) {
        List<Card> hand = player.getHand();
        int randomIndex = random.nextInt(hand.size());
        return hand.get(randomIndex).getRank();
    }

    public static void main(String[] args) {
        Fish game = new Fish();
        game.playGame();
    }
}