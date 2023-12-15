import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private String[] fictionalTeams = {"Cobras", "Dragons", "Eagles", "Hawks"};
    private Random random = new Random();

    // Method to start and play a match
    public void playMatch(Team userTeam) {
        Scanner scanner = new Scanner(System.in);
        String opponent = fictionalTeams[random.nextInt(fictionalTeams.length)];

        System.out.println("\nYour team, " + userTeam.getTeamName() + ", is playing against " + opponent + ".");
        System.out.println("Would you like to substitute any players? (yes/no)");
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("yes")) {
            substitutePlayer(userTeam, scanner);
        }

        double userWinProbability = calculateWinProbability(userTeam);
        double opponentWinProbability = random.nextDouble();

        String result = userWinProbability > opponentWinProbability ? "won" : "lost";
        System.out.println("Match result: You " + result + " the match against " + opponent + "!\n");
    }

    // Method to substitute players
    private void substitutePlayer(Team team, Scanner scanner) {
        List<Player> players = team.getPlayers();

        System.out.println("Current Team: ");
        players.forEach(player -> System.out.println("- " + player));

        System.out.print("Enter tag ID of player to substitute out: ");
        String tagIdOut = scanner.nextLine();
        Player playerOut = team.getPlayer(tagIdOut);

        if (playerOut == null) {
            System.out.println("Player not found in the team.");
            return;
        }

        System.out.print("Enter tag ID of player to substitute in: ");
        String tagIdIn = scanner.nextLine();
        Player playerIn = new Player("New Player", tagIdIn, random.nextDouble()); // Example of adding a new player
        team.getPlayers().remove(playerOut);
        team.getPlayers().add(playerIn);

        System.out.println("Substitution complete. " + playerOut.getName() + " was substituted with " + playerIn.getName() + ".\n");
    }

    // Method to calculate win probability based on team's average accuracy rate
    private double calculateWinProbability(Team team) {
        return team.getPlayers().stream()
                   .mapToDouble(Player::getAccuracyRate)
                   .average()
                   .orElse(0.5); // Default to 0.5 if no players are present
    }
}
