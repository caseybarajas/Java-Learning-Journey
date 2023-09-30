/*
 * Casey Barajas
 * The Game of Nim Project
 * Computer class
 * 9/27/23
 * 
 * This class represents the computer opponent in the game. It decides 
 * how many pieces to remove on its turn based on the current game state 
 * and whether cheat mode is enabled. In cheat mode, it uses a strategy 
 * to ensure its victory.
 */


public class Computer implements GameParticipant {
    private String name = "Computer";
    private boolean isCheatComputer;

    public Computer(boolean isCheatComputer) {
        this.isCheatComputer = isCheatComputer;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int takeTurn(int pieces) {
        int maxPieces = pieces / 2;
        if (isCheatComputer) {
            // Strategy to always win
            int targetSize = 1;
            while (targetSize * 2 < pieces) {
                targetSize *= 2;
            }
            int piecesToRemove = pieces - targetSize;
            if (piecesToRemove > 0 && piecesToRemove <= maxPieces) {
                return piecesToRemove;
            } else {
                // If unable to force a win in this turn, remove one piece
                return 1;
            }
        } else {
            // Regular strategy
            if ((pieces & (pieces - 1)) == 0) {
                return 1;
            } else {
                int targetSize = Integer.highestOneBit(pieces - 1);
                return pieces - targetSize;
            }
        }
    }
}
