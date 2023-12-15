import java.util.Scanner;

public class Kenny {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Kenny Battle!");
        
        int kennyHealth = 100;
        int playerHealth = 100;
        
        while (kennyHealth > 0 && playerHealth > 0) {
            System.out.println("Kenny's health: " + kennyHealth);
            System.out.println("Your health: " + playerHealth);
            System.out.println("Choose your move:");
            System.out.println("1. Attack");
            System.out.println("2. Defend");
            System.out.println("3. Heal");
            System.out.println("4. Magic");
            
            int move = scanner.nextInt();
            
            if (move == 1) {
                int damage = (int) (Math.random() * 20) + 10;
                kennyHealth -= damage;
                System.out.println("You attacked Kenny and dealt " + damage + " damage!");
            } else if (move == 2) {
                int block = (int) (Math.random() * 10) + 5;
                playerHealth += block;
                System.out.println("You defended and gained " + block + " health!");
            } else if (move == 3) {
                int heal = (int) (Math.random() * 15) + 10;
                playerHealth += heal;
                System.out.println("You healed yourself and gained " + heal + " health!");
            } else if (move == 4) {
                System.out.println("Choose a magic spell:");
                System.out.println("1. Fireball");
                System.out.println("2. Lightning Bolt");
                System.out.println("3. Ice Shard");
                System.out.println("4. Poison Nova");
                System.out.println("5. Arcane Blast");
                
                int spell = scanner.nextInt();
                
                int spellDamage = 0;
                String spellName = "";
                
                if (spell == 1) {
                    spellDamage = (int) (Math.random() * 25) + 15;
                    spellName = "Fireball";
                } else if (spell == 2) {
                    spellDamage = (int) (Math.random() * 30) + 20;
                    spellName = "Lightning Bolt";
                } else if (spell == 3) {
                    spellDamage = (int) (Math.random() * 35) + 25;
                    spellName = "Ice Shard";
                } else if (spell == 4) {
                    spellDamage = (int) (Math.random() * 40) + 30;
                    spellName = "Poison Nova";
                } else if (spell == 5) {
                    spellDamage = (int) (Math.random() * 45) + 35;
                    spellName = "Arcane Blast";
                } else {
                    System.out.println("Invalid spell! Try again.");
                    continue;
                }
                
                kennyHealth -= spellDamage;
                System.out.println("You cast " + spellName + " and dealt " + spellDamage + " damage!");
            } else {
                System.out.println("Invalid move! Try again.");
                continue;
            }
            
            int kennyMove = (int) (Math.random() * 3) + 1;
            
            if (kennyMove == 1) {
                int damage = (int) (Math.random() * 15) + 5;
                playerHealth -= damage;
                System.out.println("Kenny attacked you and dealt " + damage + " damage!");
            } else if (kennyMove == 2) {
                int block = (int) (Math.random() * 10) + 5;
                kennyHealth += block;
                System.out.println("Kenny defended and gained " + block + " health!");
            } else if (kennyMove == 3) {
                int heal = (int) (Math.random() * 15) + 10;
                kennyHealth += heal;
                System.out.println("Kenny healed himself and gained " + heal + " health!");
            }
        }
        
        if (kennyHealth <= 0) {
            System.out.println("Congratulations! You defeated Kenny!");
        } else {
            System.out.println("Game over! Kenny defeated you!");
        }
        
        scanner.close();
    }
}
