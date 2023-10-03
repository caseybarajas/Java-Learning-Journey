/*
 * Casey Barajas
 * The Game of Nim Project
 * GameParticipant interface
 * 9/27/23
 * 
 * This interface represents a participant in the Game of Nim. 
 * It defines the common methods that both human players and 
 * computer opponents must implement, ensuring a consistent 
 * approach to interacting with different types of game participants.
 */

public interface GameParticipant {
    String getName();
    int takeTurn(int pieces);
}
