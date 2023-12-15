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
                        exit = true;
                        break;
                    default:
                        System.out.println("\nInvalid choice. Please try again.");
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
        System.out.println("1. Add Player");
        System.out.println("2. Edit Player Information");
        System.out.println("3. Display Player Information");
        System.out.println("4. Display Team Information");
        System.out.println("5. Play a Match");
        System.out.println("6. View Stats"); // New option
        System.out.println("7. Exit");
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
        team.addPlayer(newPlayer);
        System.out.println("Player added successfully.");
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
                team.editPlayerAccuracyRate(tagId, newAccuracyRate);
                break;
            case 4:
                System.out.print("Enter new type: (Sniper, Tank, Scout, Medic, Engineer)");
                String newType = scanner.nextLine();
                team.editPlayerType(tagId, newType);
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
    }

}
