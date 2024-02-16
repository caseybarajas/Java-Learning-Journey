/*
 * The Game class represents a game of Tic-Tac-Toe.
 * It allows two players to play against each other or against a computer opponent.
 * The game keeps track of the number of wins for each player and ties.
 * 
 * Casey Barajas
 * 02/16/2024
 * 
 */

import java.util.Scanner;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private int player1Wins = 0;
    private int player2Wins = 0;
    private int ties = 0;

    public Game() {
        board = new Board();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player 1, choose your symbol (X or O): ");
        char p1Symbol = scanner.next().toUpperCase().charAt(0);
        player1 = new Player(true, p1Symbol);

        System.out.println("Play against another user (u) or computer (c)?");
        char opponent = scanner.next().charAt(0);
        if (opponent == 'u') {
            char p2Symbol = (p1Symbol == 'X') ? 'O' : 'X';
            player2 = new Player(true, p2Symbol);
        } else {
            char compSymbol = (p1Symbol == 'X') ? 'O' : 'X';
            player2 = new Player(false, compSymbol);
        }
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        String playAgain = "y";
        while (playAgain.equals("y")) {
            board = new Board(); // Reset board for new game
            boolean isPlayer1Turn = true;
            boolean gameEnded = false;
            while (!gameEnded) {
                board.printBoard();
                if (isPlayer1Turn) {
                    player1.chooseSpot(board);
                    gameEnded = board.checkForWin() || board.checkForTie();
                    if (board.checkForWin()) {
                        player1Wins++;
                        System.out.println("Player 1 wins!");
                    }
                } else {
                    player2.chooseSpot(board);
                    gameEnded = board.checkForWin() || board.checkForTie();
                    if (board.checkForWin()) {
                        player2Wins++;
                        System.out.println("Player 2 wins!");
                    }
                }
                if (board.checkForTie() && !board.checkForWin()) {
                    ties++;
                    System.out.println("It's a tie!");
                }
                isPlayer1Turn = !isPlayer1Turn;
            }
            System.out.println("Play again? (y/n): ");
            playAgain = scanner.next();
        }
        System.out.println("Player 1 Wins: " + player1Wins + ", Player 2 Wins: " + player2Wins + ", Ties: " + ties);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.playGame();
    }
}
