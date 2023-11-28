/*
* 10/23/23
* Casey Barajas
* Bender
* N/A (This is the parent class)
* Represents a generic bender with basic attributes like health points, special move, and name. Also provides methods for attacking and defending.
*/

import java.util.Random;

public class Bender {
    private int HP;
    public String specialMove;
    public String name;
    public boolean specialMoveUsed = false;

    public Bender(String name) {
        this.name = name;
        this.HP = 100; // Default HP for all benders
    }

    public String[] moveList() {
        // This method will be overridden in subclasses
        return new String[]{};
    }

    public int getHP() {
        return this.HP;
    }

    public void decreaseHP(int damage) {
        this.HP -= damage;
        if (this.HP < 0) {
            this.HP = 0;
        }
    }

    public int attack(String move) {
        // This method will be overridden in subclasses
        return 0;
    }

    public String compMove() {
        String[] moves = this.moveList();
        return moves[new Random().nextInt(moves.length)];
    }

    public String getName() {
        return this.name;
    }
}
