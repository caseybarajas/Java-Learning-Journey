/*
* 10/23/23
* Casey Barajas
* Airbender
* Bender
* Represents an Airbender with specific moves and attack logic. Extends the Bender class.
*/

public class Airbender extends Bender {

    public Airbender(String name) {
        super(name);
        this.specialMove = "Air Cyclone";
    }

    @Override
    public String[] moveList() {
        return new String[] {"Air Swipe", "Air Punch", "Air Kick", "Air Ball"};
    }

    @Override
    public int attack(String move) {
        int damage = (int) (Math.random() * 10) + 1;  // Random base damage from 1 to 10

        switch (move.toLowerCase()) {
            case "air swipe":
                damage += 5;
                break;
            case "air punch":
                damage += 7;
                break;
            case "air kick":
                damage += 10;
                break;
            case "air ball":
                damage += 8;
                break;
            default:
                System.out.println("Invalid move! Using default attack.");
                break;
        }

        return damage;
    }
}
