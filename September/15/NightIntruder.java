/*
* Casey Barajas
* 9/7/23
* NightIntruder.java
* Projects
*/

import java.util.Scanner;
import java.util.Random;

public class NightIntruder {

    private Scanner scanner = new Scanner(System.in);
    private Random rand = new Random();
    private boolean canUseFireball = true;
    private boolean canUseHeal = true;
    private boolean canUseShield = true;
    private boolean canUseCharm = true;
    private String weapon;

    public static void main(String[] args) {
        NightIntruder game = new NightIntruder();
        game.playGame();
    }

    void playGame() {
        System.out.println("Welcome to the Night Intruder adventure game!");

        boolean playAgain = true;
        String result = "";
        while (playAgain) {
            System.out.println("\nA stormy night, you're alone in your ancient family mansion.");
            System.out.println("Suddenly, the electricity goes out. You hear a window breaking in the distance.");
            String choice = getInput("You wake up to noises at night. Do you (confront) the intruder or (escape)? ");
            
            if ("confront".equals(choice)) {
                result = swordScenario();
            } else if ("escape".equals(choice)) {
                result = escapeScenario();
            } else {
                System.out.println("Invalid choice. Please select confront or escape.");
                continue;
            }

            System.out.println(result);
            playAgain = "yes".equals(getInput("\nWould you like to play again? (yes/no): "));
        }

        System.out.println("\nThank you for playing!");
    }

    private String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().toLowerCase();
    }

    private String swordScenario() {
        System.out.println("You've chosen to confront the intruder!");
        weapon = getInput("Select your weapon: (sword), (dagger), or (mace): ");
        boolean weaponIntact = true;

        System.out.println("You feel the weight of the " + weapon + " in your hand, ready for whatever comes next.");
        String choice = getInput("Do you (search) the house for the intruder or (wait)? ");

        if ("search".equals(choice)) {
            return combat("You bravely search the house. Suddenly, you're face to face with an intruder!", weaponIntact);
        } else if ("wait".equals(choice)) {
            System.out.println("You decide to wait in a strategic position, setting up a makeshift trap using household items.");
            return "After a tense hour, you hear footsteps approaching. It's the intruder! But he steps into your trap and is incapacitated. The police arrive soon after.";
        } else {
            return "In your indecision, the intruder escapes. At least you're safe.";
        }
    }

    private String escapeScenario() {
        System.out.println("You've chosen to escape!");
        System.out.println("You remember an old escape tunnel your grandparents mentioned, leading from the basement to the nearby woods.");
        String choice = getInput("Do you (run) out of the house, (hide) in the attic, or try to (signal) for help? ");

        if ("run".equals(choice)) {
            System.out.println("You dash through the mansion, heading to the basement.");
            return "Finding the entrance to the escape tunnel, you make your way through. After what feels like hours, you emerge in the woods and make your way to safety.";
        } else if ("hide".equals(choice)) {
            System.out.println("You quickly climb up to the attic and hide behind some old furniture.");
            return "You hear the intruder searching the house but they never make it to the attic. After a while, you hear sirens and the intruder is captured by the police.";
        } else if ("signal".equals(choice)) {
            System.out.println("You find a flashlight and start signaling from the window.");
            return "A neighbor notices the signal and calls the police. The intruder is captured and you're hailed as a hero in your town.";
        } else {
            return "While you're unsure of what to do, the intruder leaves. You breathe a sigh of relief.";
        }
    }

    private String combat(String message, boolean weaponIntact) {
        System.out.println(message);

        int playerHealth = 50;
        int intruderHealth = 50;

        while (playerHealth > 0 && intruderHealth > 0) {
            String combatChoice = getInput("\nDo you (attack), (defend), use (magic), or try to (flee)? ");

            int playerDamage = rand.nextInt(10);
            int intruderDamage = rand.nextInt(20);

            if ("attack".equals(combatChoice) && weaponIntact) {
                String hitLocation = getInput("Where do you aim your attack? (head), (body), or (legs)? ");
                switch (hitLocation) {
                    case "head":
                        playerDamage += rand.nextInt(20);
                        weaponIntact = rand.nextInt(100) > 20; // 20% chance the weapon breaks
                        break;
                    case "body":
                        playerDamage += rand.nextInt(15);
                        weaponIntact = rand.nextInt(100) > 10; // 10% chance the weapon breaks
                        break;
                    case "legs":
                        playerDamage += rand.nextInt(10);
                        weaponIntact = rand.nextInt(100) > 5; // 5% chance the weapon breaks
                        break;
                }

                if (!weaponIntact) {
                    System.out.println("Your " + weapon + " breaks during the attack!");
                }

                intruderHealth -= playerDamage;
                playerHealth -= intruderDamage;
                System.out.println("You deal " + playerDamage + " damage to the intruder! Intruder's health: " + intruderHealth);
                System.out.println("The intruder counterattacks! You take " + intruderDamage + " damage! Your health: " + playerHealth);
            } else if ("defend".equals(combatChoice)) {
                playerHealth -= (intruderDamage / 2);
                System.out.println("You defended! You take " + (intruderDamage / 2) + " damage! Your health: " + playerHealth);
            } else if ("magic".equals(combatChoice)) {
                String spell = getInput("Choose your spell: (fireball), (heal), (shield), or (charm)");
                if ("fireball".equals(spell) && canUseFireball) {
                    int fireballDamage = 15 + rand.nextInt(10);
                    intruderHealth -= fireballDamage;
                    canUseFireball = false;
                    System.out.println("You cast a fireball and deal " + fireballDamage + " damage! Intruder's health: " + intruderHealth);
                } else if ("heal".equals(spell) && canUseHeal) {
                    int healAmount = 10 + rand.nextInt(10);
                    playerHealth += healAmount;
                    canUseHeal = false;
                    System.out.println("You heal yourself for " + healAmount + " points! Your health: " + playerHealth);
                } else if ("shield".equals(spell) && canUseShield) {
                    int shieldAmount = 5 + rand.nextInt(5);
                    playerHealth += shieldAmount;
                    canUseShield = false;
                    System.out.println("You cast a protective shield, increasing your health by " + shieldAmount + " points! Your health: " + playerHealth);
                } else if ("charm".equals(spell) && canUseCharm) {
                    canUseCharm = false;
                    if (rand.nextInt(100) < 55) { // 55% chance
                        String marriageLocation = getInput("The charm spell works! The intruder proposes to you on the spot. Where do you choose to have the wedding? (beach, mountains, city, or backyard)?");
                        switch (marriageLocation) {
                            case "beach":
                                return "You both head to a tropical beach and have a wonderful wedding. The waves, the sun, and the love make it a perfect day.";
                            case "mountains":
                                return "You both climb to the top of a mountain and exchange vows overlooking a breathtaking view. It's serene and magical.";
                            case "city":
                                return "You both get married in the heart of the city with all the hustle and bustle. The energy is contagious, and it turns into a massive street party!";
                            default:
                                return "You both decide to have a simple backyard wedding surralounded by friends and family. It's intimate and heartwarming.";
                        }
                    } else {
                        System.out.println("Your charm spell fails. The fight continues.");
                    }
                } else {
                    System.out.println("Your chosen spell is on cooldown or invalid. Choose another action!");
                }
            } else if ("flee".equals(combatChoice)) {
                if (rand.nextInt(10) > 5) {
                    return "You successfully flee from the intruder, saving yourself. The next day, the local authorities capture the intruder.";
                } else {
                    System.out.println("You try to flee but the intruder catches you! The fight continues.");
                }
            } else {
                System.out.println("Invalid choice. The intruder attacks!");
                playerHealth -= intruderDamage;
                System.out.println("You take " + intruderDamage + " damage! Your health: " + playerHealth);
            }
        }

        if (playerHealth <= 0) {
            return "\nThe intruder was too strong. You are defeated. The town mourns your loss.";
        } else {
            return "\nYou have defeated the intruder! You are hailed as a hero in your town.";
        }
    }
}