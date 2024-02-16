public class Board {
    private char[][] board;
    private final int size = 3; // TicTacToe board size

    public Board() {
        board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = (char) ('1' + i * size + j);
            }
        }
    }

    public boolean setSymbol(int spot, char symbol) {
        int row = (spot - 1) / size;
        int col = (spot - 1) % size;
        if (board[row][col] != 'X' && board[row][col] != 'O') {
            board[row][col] = symbol;
            return true;
        }
        return false;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
                if (j < size - 1) System.out.print("| ");
            }
            System.out.println();
            if (i < size - 1) System.out.println("---------");
        }
    }

    public boolean checkForWin() {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < size; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) return true;
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) return true;
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) return true;
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) return true;
        return false;
    }

    public boolean checkForTie() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (board[i][j] != 'X' && board[i][j] != 'O')
                    return false;
        return true;
    }
}
