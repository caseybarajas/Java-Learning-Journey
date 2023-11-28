/*
* 10/23/23
* Casey Barajas
* Firebender
* Bender
* Represents a Firebender with specific moves and attack logic. Extends the Bender class.
*/

public class Firebender extends Bender {

    public Firebender(String name) {
        super(name);
        this.specialMove = "Dragon's Breath";
    }

    @Override
    public String[] moveList() {
        return new String[] {"Fireball", "Flame Kick", "Blazing Arc", "Heat Wave"};
    }

    @Override
    public int attack(String move) {
        int damage = (int) (Math.random() * 10) + 1;  // Random base damage from 1 to 10

        switch (move.toLowerCase()) {
            case "fireball":
                damage += 8;
                break;
            case "flame kick":
                damage += 9;
                break;
            case "blazing arc":
                damage += 6;
                break;
            case "heat wave":
                damage += 7;
                break;
            default:
                System.out.println("Invalid move! Using default attack.");
                break;
        }

        return damage;
    }
}
