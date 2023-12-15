/*
* Casey Barajas
* Game.java
* This class represents a game with methods to start and play a match, simulate a match with random events, substitute players, and calculate the win probability of a team.
*/

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private String[] fictionalTeams = {"The Roid Ragers", "The Laser Lords", "The Thunderbolts", "The Steel Titans", "The Shadow Strikers", "The Laser Lords", "The Laser Beams", "The Laser Sharks", "The Laser Dragons", "The Laser Wolves", "The Laser Tigers", "The Laser Lions", "The Laser Bears", "The Laser Eagles", "The Laser Falcons", "The Laser Hawks", "The Laser Owls", "The Laser Ravens", "The Laser Vultures", "The Laser Scorpions", "The Laser Spiders", "The Laser Snakes", "The Laser Wolves", "The Laser Sharks", "The Laser Dragons", "The Laser Tigers", "The Laser Lions", "The Laser Bears", "The Laser Eagles", "The Laser Falcons", "The Laser Hawks", "The Laser Owls", "The Laser Ravens", "The Laser Vultures", "The Laser Scorpions", "The Laser Spiders", "The Laser Snakes", "The Laser Wolves", "The Laser Sharks", "The Laser Dragons", "The Laser Tigers", "The Laser Lions", "The Laser Bears", "The Laser Eagles", "The Laser Falcons", "The Laser Hawks", "The Laser Owls", "The Laser Ravens", "The Laser Vultures", "The Laser Scorpions", "The Laser Spiders", "The Laser Snakes"};
    private Random random = new Random();

    // Method to start and play a match
    public void playMatch(Team userTeam) {
        Scanner scanner = new Scanner(System.in);
        String opponent = fictionalTeams[random.nextInt(fictionalTeams.length)];

        System.out.println("\nYour team, " + userTeam.getTeamName() + ", is playing against " + opponent + ".");
        System.out.println("Would you like to substitute any players? (yes/no) \n");
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("yes")) {
            substitutePlayer(userTeam, scanner);
        }

        simulateMatch(userTeam, opponent);

        double userWinProbability = calculateWinProbability(userTeam);
        double opponentWinProbability = random.nextDouble();
    
        String result = userWinProbability > opponentWinProbability ? "won" : "lost";
        System.out.println("Match result: You " + result + " the match against " + opponent + "!\n");
    
        if (result.equals("won")) {
            userTeam.incrementWins();
            userTeam.addMoney(100); // Add 100 money for a win
        } else {
            userTeam.incrementLosses();
        }
    }

    // Method to simulate a match with random events
    private void simulateMatch(Team userTeam, String opponent) {
        List<Player> players = userTeam.getPlayers();
        String[] events = {
            " shot at an opponent.\n",
            " dodged an incoming attack.\n",
            " got hit by an opponent.\n",
            " healed a teammate.\n",
            " repaired the team's equipment.\n",
            " scouted the opponent's position.\n",
            " blocked an incoming attack.\n",
            " set up a defensive perimeter.\n",
            " spotted a weakness in the opponent's defense.\n",
            " took a strategic position.\n",
            " provided cover for a teammate.\n",
            " distracted an opponent.\n",
            " made a critical hit on an opponent.\n",
            " missed a shot at an opponent.\n",
            " was hit by friendly fire.\n",
            " successfully retreated from a dangerous situation.\n",
            " was caught off guard by an opponent.\n",
            " made a daring charge at the opponent.\n",
            " took a heavy hit but kept going.\n",
            " managed to disarm an opponent.\n",
            " made a tactical retreat.\n",
            " held the line against an opponent's charge.\n",
            " cried \n",
            " knocked a kid over \n",
            " got hit by a car \n",
            " did a flip \n",
            " pulled out their sidearm \n",
            " got shot in the chest \n",
            " got shot in the head \n",
            " got shot in the leg \n",
            " got shot in the arm \n",
            " got shot in the foot \n",
            " got shot in the hand \n",
            " got shot in the shoulder \n",
            " got shot in the stomach \n",
            " got shot in the back \n",
            " got shot in the neck \n",
            " accidentally tripped over their own feet.\n",
            " got tangled in their own shoelaces.\n",
            " started breakdancing instead of fighting.\n",
            " challenged the opponent to a dance-off.\n",
            " started singing karaoke during the match.\n",
            " got distracted by a butterfly.\n",
            " tried to use a banana as a weapon.\n",
            " mistook a teammate for an opponent and attacked them.\n",
            " started a conga line with the opponents.\n",
            " brought a rubber chicken to the match.\n",
            " started juggling instead of playing.\n",
            " accidentally threw their weapon in the wrong direction.\n",
            " got their shoelaces tied together by an opponent.\n",
            " started doing yoga poses in the middle of the match.\n",
            " tried to negotiate a truce with the opponents.\n",
            " got distracted by their own reflection.\n",
            " started playing air guitar instead of fighting.\n",
            " mistook a referee for an opponent and attacked them.\n",
            " brought a water gun and short circuted an opponent. \n",
            " started doing magic tricks instead of playing.\n",
            " accidentally hit themselves with their own weapon.\n",
            " got their pants pulled down by an opponent.\n",
            " started playing rock-paper-scissors with the opponents.\n",
            " mistook a spectator for an opponent and attacked them.\n",
            " brought a rubber duck to the match.\n",
            " started doing cartwheels instead of fighting.\n",
            " accidentally threw a pie at their own teammate.\n"
        };

        for (int i = 0; i < 15; i++) {
            Player player = players.get(random.nextInt(players.size()));
            String event = events[random.nextInt(events.length)];

            // Check if the event is applicable to the player's type
            if ((player.getType().equals("Medic") && event.contains("healed")) ||
                (player.getType().equals("Engineer") && event.contains("repaired")) ||
                (player.getType().equals("Scout") && event.contains("scouted")) ||
                (player.getType().equals("Tank") && event.contains("blocked")) ||
                (!event.contains("healed") && !event.contains("repaired") && !event.contains("scouted") && !event.contains("blocked"))) {
                System.out.println(player.getName() + event);
                try {
                    Thread.sleep(2000); // Wait for 2 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                i--; // Retry the event if it's not applicable to the player's type
            }
        }
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
        Player playerIn = new Player("New Player", tagIdIn, random.nextDouble(), "DefaultType"); 
        team.getPlayers().remove(playerOut);
        team.getPlayers().add(playerIn);

        System.out.println("Substitution complete. " + playerOut.getName() + " was substituted with " + playerIn.getName() + ".\n");
    }

    private double calculateWinProbability(Team team) {
        double winProbability = 0.0;
        boolean hasMedic = false;
        for (Player player : team.getPlayers()) {
            double playerEffect = player.getAccuracyRate();
            switch (player.getType()) {
                case "Medic":
                    hasMedic = true;
                    break;
                case "Sniper":
                    playerEffect *= 1.2; // Sniper players have 20% more effect
                    break;
                case "Tank":
                    playerEffect *= 0.8; // Tank players have 20% less effect
                    break;
                case "Scout":
                    playerEffect *= 1.1; // Scout players have 10% more effect
                    break;
                case "Engineer":
                    playerEffect *= 0.9; // Engineer players have 10% less effect
                    break;
            }
            winProbability += playerEffect;
        }
        winProbability /= team.getPlayers().size();
        if (hasMedic) {
            winProbability *= 1.1; // Increase win probability by 10% if the team has a medic
        }
        return winProbability;
    }

    public void playGame(Team team1, Team team2) {
        double team1WinProbability = calculateWinProbability(team1);
        double team2WinProbability = calculateWinProbability(team2);

        if (team1WinProbability > team2WinProbability) {
            team1.incrementWins();
            team2.incrementLosses();
        } else if (team1WinProbability < team2WinProbability) {
            team1.incrementLosses();
            team2.incrementWins();
        }
    }
}
