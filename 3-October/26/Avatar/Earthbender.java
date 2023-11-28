/*
* 10/23/23
* Casey Barajas
* Earthbender
* Bender
* Represents an Earthbender with specific moves and attack logic. Extends the Bender class.
*/

public class Earthbender extends Bender {

    public Earthbender(String name) {
        super(name);
        this.specialMove = "Earthquake";
    }

    @Override
    public String[] moveList() {
        return new String[] {"Rock Throw", "Earth Wall", "Ground Smash", "Stone Fist"};
    }

    @Override
    public int attack(String move) {
        int damage = (int) (Math.random() * 10) + 1;  // Random base damage from 1 to 10

        switch (move.toLowerCase()) {
            case "rock throw":
                damage += 7;
                break;
            case "earth wall":
                // This is a defensive move, so it reduces incoming damage instead of increasing your own
                damage = 0;
                System.out.println("You used Earth Wall! Defense increased for the next attack!");
                break;
            case "ground smash":
                damage += 9;
                break;
            case "stone fist":
                damage += 8;
                break;
            default:
                System.out.println("Invalid move! Using default attack.");
                break;
        }

        return damage;
    }
}
