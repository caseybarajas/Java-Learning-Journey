import java.util.ArrayList;
import java.util.List;

public class Team {
    public static final String[] NAMES = {
        "Casey", "Sam", "Jack", "Aidan", "Tyler", "James", "Hollywood", "Jade",
        "Emma", "Liam", "Olivia", "Noah", "Ava", "Ethan", "Sophia", "Mason",
        "Isabella", "Lucas", "Mia", "Charlotte", "Benjamin", "Amelia", "Harper",
        "Alexander", "Evelyn", "Michael", "Abigail", "Ella", "Daniel", "Lily",
        "Henry", "Chloe", "Jackson", "Zoe", "Sebastian", "Grace", "Aiden", "Emily",
        "Matthew", "Sofia", "Logan", "Avery", "David", "Scarlett", "Joseph", "Victoria",
        "Gabriel", "Madison", "Sarah", "Carter", "Penelope", "Dylan", "Hannah", "Oliver",
        "Bella", "Elijah", "Brooklyn"
    };
    private String teamName;
    private List<Player> players;

    // Constructor
    public Team(String teamName, List<Player> startingPlayers) {
        this.teamName = teamName;
        this.players = new ArrayList<>(startingPlayers);
    }

    // Method to add a player to the team
    public void addPlayer(Player player) {
        players.add(player);
    }

    // Method to remove a player from the team
    public void removePlayer(String tagId) {
        players.removeIf(player -> player.getTagId().equals(tagId));
    }

    // Method to get a player by tag ID
    public Player getPlayer(String tagId) {
        return players.stream()
                      .filter(player -> player.getTagId().equals(tagId))
                      .findFirst()
                      .orElse(null);
    }

    // Method to edit a player's name by tag ID
    public void editPlayerName(String tagId, String newName) {
        Player player = getPlayer(tagId);
        if (player != null) {
            player.setName(newName);
        } else {
            System.out.println("Player with tag ID " + tagId + " not found.");
        }
    }

    // Method to edit a player's tag ID
    public void editPlayerTagId(String oldTagId, String newTagId) {
        if (isTagIdExists(newTagId)) {
            System.out.println("Tag ID " + newTagId + " already exists.");
            return;
        }
        Player player = getPlayer(oldTagId);
        if (player != null) {
            player.setTagId(newTagId);
        } else {
            System.out.println("Player with tag ID " + oldTagId + " not found.");
        }
    }

    private boolean isTagIdExists(String tagId) {
        return players.stream().anyMatch(player -> player.getTagId().equals(tagId));
    }

    // Method to edit a player's accuracy rate
    public void editPlayerAccuracyRate(String tagId, double newAccuracyRate) {
        Player player = getPlayer(tagId);
        if (player != null) {
            player.setAccuracyRate(newAccuracyRate);
        } else {
            System.out.println("Player with tag ID " + tagId + " not found.");
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Team: ").append(teamName).append("\n");
        sb.append(String.format("%-15s %-15s %-15s\n", "Name", "Tag ID", "Accuracy Rate"));
        for (Player player : players) {
            sb.append(String.format("%-15s %-15s %-15s\n",
                                    player.getName(),
                                    player.getTagId(),
                                    String.format("%.2f%%", player.getAccuracyRate() * 100)));
        }
        return sb.toString();
    }

    // Getters and Setters
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<Player> getPlayers() {
        return players;
    }
}

