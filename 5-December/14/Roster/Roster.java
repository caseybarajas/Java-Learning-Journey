/*
 * Casey Barajas
 * Roster.java
 * This class manages the roster of players. It includes methods to create a draft pool of players, display menu options, add a player to a team, edit player info, and display player info.
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Roster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Enter your Laser Tag team name ---");
        String teamName = scanner.nextLine();

        List<Player> draftPool = createDraftPool();
        System.out.println("\n--- Draft Pool: Choose 3 players for your team ---");
        for (int i = 0; i < draftPool.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, draftPool.get(i));
        }

        List<Player> selectedPlayers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.println("\nSelect player number " + (i + 1) + ":");
            int choice = scanner.nextInt();
            selectedPlayers.add(draftPool.get(choice - 1));
        }
        scanner.nextLine(); // Consume newline

        Team team = new Team(teamName, selectedPlayers);
        Game game = new Game(); // Instance of Game class

        boolean exit = false;
        while (!exit) {
            displayMenuOptions();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline left-over

                switch (choice) {
                    case 1:
                        addPlayerToTeam(team, scanner);
                        break;
                    case 2:
                        editPlayerInfo(team, scanner);
                        break;
                    case 3:
                        displayPlayerInfo(team, scanner);
                        break;
                    case 4:
                        System.out.println("\n" + team);
                        break;
                    case 5:
                        game.playMatch(team); // Play a match
                        break;
                    case 6:
                        viewStats(team);
                        break;
                        case 7:
                        buyEquipment(team, scanner);
                        break;
                    case 8:
                        hireCoaches(team, scanner);
                        break;
                    case 9:
                        upgradeFacilities(team, scanner);
                        break;
                    case 10:
                        healInjuredPlayers(team, scanner);
                        break;
                    case 11:
                        conductTrainingSessions(team, scanner);
                        break;
                    case 12:
                        getSponsorships(team, scanner);
                        break;
                    case 13:
                        System.out.println("Exiting the program...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        scanner.close();
        System.out.println("\n--- Program ended ---");
    }

    private static List<Player> createDraftPool() {
        List<Player> draftPool = new ArrayList<>();
        Random random = new Random();
        String[] types = {"Sniper", "Tank", "Scout", "Medic", "Engineer"};

        for (int i = 0; i < 9; i++) {
            int nameIndex = random.nextInt(Team.NAMES.length); // Use NAMES array from Team class
            String name = Team.NAMES[nameIndex];
            String tagId = "#" + (1000 + random.nextInt(9000));
            double accuracyRate = random.nextDouble();
            String type = types[random.nextInt(types.length)]; // Randomly select a type
            draftPool.add(new Player(name, tagId, accuracyRate, type));
        }
        return draftPool;
    }


    private static void displayMenuOptions() {
        System.out.println("\nMenu Options:");
        System.out.println("1.   Add Player");
        System.out.println("2.   Edit Player Information");
        System.out.println("3.   Display Player Information");
        System.out.println("4.   Display Team Information");
        System.out.println("5.   Play a Match");
        System.out.println("6.   View Stats");
        System.out.println("7.   Buy Equipment");
        System.out.println("8.   Hire Coaches");
        System.out.println("9.   Upgrade Facilities");
        System.out.println("10.  Heal Injured Players");
        System.out.println("11.  Conduct Training Sessions");
        System.out.println("12.  Get Sponsorships");
        System.out.println("13.  Exit");
        System.out.print("\nEnter your choice: ");
    }


    private static void addPlayerToTeam(Team team, Scanner scanner) {
        System.out.println("Enter player name:");
        String name = scanner.nextLine();

        System.out.println("Enter player tag ID:");
        String tagId = scanner.nextLine();
        if (!tagId.startsWith("#")) {
            tagId = "#" + tagId;
        }

        System.out.println("Enter player accuracy rate (0.0 - 1.0):");
        double accuracyRate;
        while (true) {
            accuracyRate = scanner.nextDouble();
            if (accuracyRate >= 0.0 && accuracyRate <= 1.0) {
                break;
            }
            System.out.println("Invalid accuracy rate. Please enter a value between 0.0 and 1.0:");
        }
        scanner.nextLine();  // Consume newline left-over

        System.out.println("Enter player type: (Sniper, Tank, Scout, Medic, Engineer)");
        String type = scanner.nextLine();

        Player newPlayer = new Player(name, tagId, accuracyRate, type);
        if (team.getMoney() >= 50) { // Check if the team has enough money
            team.subtractMoney(50); // Subtract 50 money for adding a player
            team.addPlayer(newPlayer);
            System.out.println("Player added successfully.");
        } else {
            System.out.println("Not enough money to add a player.");
        }
    }


    private static void editPlayerInfo(Team team, Scanner scanner) {
        System.out.println("\n--- Current Team Players ---");
        System.out.println(team);

        System.out.print("Enter player's tag ID to edit: (Include the # symbol)");
        String tagId = scanner.nextLine();

        Player player = team.getPlayer(tagId);
        if (player == null) {
            System.out.println("Player with tag ID " + tagId + " not found.");
            return;
        }

        System.out.println("Editing Player: " + player);
        System.out.println("1. Edit Name");
        System.out.println("2. Edit Tag ID");
        System.out.println("3. Edit Accuracy Rate");
        System.out.println("4. Edit Type");
        System.out.println("5. Use Steroids");
        System.out.print("Choose the attribute to edit: ");

        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume the leftover newline

        switch (choice) {
            case 1:
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                team.editPlayerName(tagId, newName);
                break;
            case 2:
                System.out.print("Enter new tag ID: ");
                String newTagId = scanner.nextLine();
                team.editPlayerTagId(tagId, newTagId);
                break;
            case 3:
                System.out.print("Enter new accuracy rate (0.0 - 1.0): ");
                double newAccuracyRate = scanner.nextDouble();
                scanner.nextLine();  // Consume the leftover newline
                if (team.getMoney() >= 10) { // Check if the team has enough money
                    team.subtractMoney(10); // Subtract 10 money for changing accuracy
                    team.editPlayerAccuracyRate(tagId, newAccuracyRate);
                } else {
                    System.out.println("Not enough money to change accuracy rate.");
                }
                break;
            case 4:
                System.out.print("Enter new type: (Sniper, Tank, Scout, Medic, Engineer)");
                String newType = scanner.nextLine();
                team.editPlayerType(tagId, newType);
                break;
            case 5:
                if (team.getMoney() >= 20) { // Check if the team has enough money
                    team.subtractMoney(20); // Subtract 20 money for using steroids
                    player.setAccuracyRate(1.0);
                    System.out.println("Player's accuracy rate has been set to 1.0.");
                } 
                else {
                    System.out.println("Not enough money to use steroids.");
                }
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }


    private static void displayPlayerInfo(Team team, Scanner scanner) {
        System.out.print("Enter player's tag ID: (Include the # symbol)\n");
        String tagId = scanner.nextLine();
        Player player = team.getPlayer(tagId);
        if (player != null) {
            System.out.println("Player Information:");
            System.out.println(player); 
        } else {
            System.out.println("Player with tag ID " + tagId + " not found. \n");
        }
    }

    private static void viewStats(Team team) {
        System.out.println("Wins: " + team.getWins());
        System.out.println("Losses: " + team.getLosses());
        System.out.println("Money: " + team.getMoney());
    }

    private static void buyEquipment(Team team, Scanner scanner) {
        System.out.println("Enter player's tag ID:");
        String tagId = scanner.nextLine();
        Player player = team.getPlayer(tagId);
        if (player != null) {
            System.out.println("Enter type of equipment to buy:");
            String equipment = scanner.nextLine();
            if (team.getMoney() >= 250) {  // Assuming EQUIPMENT_COST is a constant
                team.subtractMoney(250);
                player.addEquipment(equipment);
                System.out.println("Bought " + equipment + " for player " + tagId);
            } else {
                System.out.println("Not enough money to buy equipment.");
            }
        } else {
            System.out.println("Player not found.");
        }
    }

    private static void hireCoaches(Team team, Scanner scanner) {
        if (team.getMoney() >= 500) {  // Assuming COACH_COST is a constant
            System.out.println("Enter coach's name:");
            String coach = scanner.nextLine();
            team.subtractMoney(500);
            team.hireCoach(coach);
            System.out.println("Hired coach " + coach);
        } else {
            System.out.println("Not enough money to hire a coach.");
        }
    }

    private static void upgradeFacilities(Team team, Scanner scanner) {
        if (team.getMoney() >= 750) {  // Assuming FACILITIES_UPGRADE_COST is a constant
            System.out.println("Enter new facilities level:");
            String facilities = scanner.nextLine();
            team.subtractMoney(750);
            team.upgradeFacilities(facilities);
            System.out.println("Upgraded facilities to " + facilities);
        } else {
            System.out.println("Not enough money to upgrade facilities.");
        }
    }

    private static void healInjuredPlayers(Team team, Scanner scanner) {
        System.out.println("Enter player's tag ID:");
        String tagId = scanner.nextLine();
        Player player = team.getPlayer(tagId);
        if (player != null) {
            if (team.getMoney() >= 250) {  // Assuming HEALING_COST is a constant
                team.subtractMoney(250);
                player.heal();
                System.out.println("Healed player " + tagId);
            } else {
                System.out.println("Not enough money to heal player.");
            }
        } else {
            System.out.println("Player not found.");
        }
    }

    private static void conductTrainingSessions(Team team, Scanner scanner) {
        if (team.getMoney() >= 150) {  // Assuming TRAINING_COST is a constant
            team.subtractMoney(150);
            team.conductTrainingSession();
            System.out.println("Conducted training session.");
        } else {
            System.out.println("Not enough money to conduct training session.");
        }
    }

    private static void getSponsorships(Team team, Scanner scanner) {
        if (!team.getSponsorshipStatus()) {
            System.out.println("Enter sponsor's name:");
            String sponsor = scanner.nextLine();
            team.getSponsorship(sponsor);  // Pass the sponsor's name to the getSponsorship method
            System.out.println("Got sponsorship from " + sponsor);
        } else {
            System.out.println("Already have a sponsorship.");
        }
    }

}
