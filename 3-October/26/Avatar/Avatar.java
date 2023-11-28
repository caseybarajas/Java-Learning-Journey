/*
* 10/23/23
* Casey Barajas
* Avatar
* The main game loop where a player chooses a bender type and battles against a randomly chosen enemy bender.
*/

import java.util.Random;
import java.util.Scanner;

public class Avatar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your bender type (Air, Water, Fire, Earth): ");
        String choice = scanner.nextLine();

        Bender player = null;
        switch (choice.toLowerCase()) {
            case "air":
                player = new Airbender("You");
                break;
            case "water":
                player = new Waterbender("You");
                break;
            case "fire":
                player = new Firebender("You");
                break;
            case "earth":
                player = new Earthbender("You");
                break;
            default:
                System.out.println("Invalid choice. Exiting...");
                return;
        }

        String[] enemies = {"air", "water", "fire", "earth"};
        String enemyType = enemies[new Random().nextInt(enemies.length)];
        System.out.println("Your enemy is a " + enemyType + " bender!");
        Bender enemy = null;
        switch (enemyType) {
            case "air":
                enemy = new Airbender("Enemy");
                break;
            case "water":
                enemy = new Waterbender("Enemy");
                break;
            case "fire":
                enemy = new Firebender("Enemy");
                break;
            case "earth":
                enemy = new Earthbender("Enemy");
                break;
        }

        while (player.getHP() > 0 && enemy.getHP() > 0) {
            System.out.println(player.getName() + " HP: " + player.getHP());
            System.out.println(enemy.getName() + " HP: " + enemy.getHP());

            System.out.println("Choose your attack:");
            String[] moves = player.moveList();
            for (int i = 0; i < moves.length; i++) {
                char letter = (char) ('a' + i);
                System.out.println(letter + ". " + moves[i]);
            }
            String attackChoiceLetter = scanner.nextLine();
            int index = attackChoiceLetter.charAt(0) - 'a';
            if (index >= 0 && index < moves.length) {
                int damage = player.attack(moves[index]);
                enemy.decreaseHP(damage);
            } else {
                System.out.println("Invalid choice! You missed your turn.");
            }

            if (enemy.getHP() <= 25 && !enemy.specialMoveUsed) {
                player.decreaseHP(25);
                System.out.println(enemy.getName() + " used their special move: " + enemy.specialMove + "!");
                enemy.specialMoveUsed = true;
            } else {
                String enemyAttack = enemy.compMove();
                int enemyDamage = enemy.attack(enemyAttack);
                player.decreaseHP(enemyDamage);
            }

            if (player.getHP() <= 25 && !player.specialMoveUsed) {
                enemy.decreaseHP(25);
                System.out.println(player.getName() + " used their special move: " + player.specialMove + "!");
                player.specialMoveUsed = true;
            }

            if (player.getHP() <= 0) {
                System.out.println("You lost!");
            } else if (enemy.getHP() <= 0) {
                System.out.println("You won!");
            }
        }
    }
}
