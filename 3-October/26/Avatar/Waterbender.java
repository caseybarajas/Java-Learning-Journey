/*
* 10/23/23
* Casey Barajas
* Waterbender
* Bender
* Represents a Waterbender with specific moves and attack logic. Extends the Bender class.
*/

public class Waterbender extends Bender {

    public Waterbender(String name) {
        super(name);
        this.specialMove = "Tidal Wave";
    }

    @Override
    public String[] moveList() {
        return new String[] {"Water Whip", "Water Shield", "Ice Spike", "Tidal Push"};
    }

    @Override
    public int attack(String move) {
        int damage = (int) (Math.random() * 10) + 1;  // Random base damage from 1 to 10

        switch (move.toLowerCase()) {
            case "water whip":
                damage += 6;
                break;
            case "water shield":
                // This is a defensive move, so it reduces incoming damage instead of increasing your own
                damage = 0;
                System.out.println("You used Water Shield! Defense increased for the next attack!");
                break;
            case "ice spike":
                damage += 9;
                break;
            case "tidal push":
                damage += 7;
                break;
            default:
                System.out.println("Invalid move! Using default attack.");
                break;
        }

        return damage;
    }
}
