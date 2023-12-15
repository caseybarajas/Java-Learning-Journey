/*
* Casey Barajas
* Team.java
* This class represents a team in the game. It includes methods to add and remove players, get and edit player details, and display the team's information.
*/

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
        "Bella", "Elijah", "Brooklyn", "Kenny", "William", "Addison", "Luke", "Layla", "Jayden", 
        "Riley", "Isaac", "Natalie", "Owen", "Elizabeth", "Jack", "Aubrey", "Julian", "Lillian",
        "Wyatt", "Ellie", "Levi", "Stella", "John", "Hailey", "Grayson", "Kaylee", "Mateo",
        "Kinsley", "Lincoln", "Victoria", "Isaiah", "Camila", "Muhammad", "Hazel", "Eliana",
        "Aaron", "Nora", "Landon", "Luna", "Connor", "Scarlet", "Hunter", "Lucy", "Caleb",
        "Anna", "Ryan", "Maya", "Adrian", "Serenity", "Asher", "Audrey", "Nathan", "Brianna",
        "Christian", "Sarah", "Jaxon", "Aaliyah", "Zachary", "Gabriella", "Julia", "Leah",
        "Charles", "Allison", "Thomas", "Savannah", "Aaron", "Ariana", "Jeremiah", "Camilla",
        "Cameron", "Penelope", "Josiah", "Gabrielle", "Jonathan", "Claire", "Connor", "Arianna",
        "Jordan", "Madelyn", "Nicholas", "Madeline", "Elias", "Caroline", "Grace", "Adeline",
        "Robert", "Charlie", "Colton", "Eleanor", "Angel", "Peyton", "Brayden", "Samantha",
        "Jaxson", "Maya", "Ian", "Skylar", "Dominic", "Nevaeh", "Kevin", "Lucia", "Brandon",
        "Anna", "Tyler", "Violet", "Ayden", "Genesis", "Zayden", "Aurora", "Jason", "Emilia",
        "Bentley", "Melanie", "Adam", "Arianna", "Xavier", "Aubree", "Jose", "Ruby", "Parker",
        "Kennedy", "Carson", "Isla", "Nathaniel", "Naomi", "Kayden", "Taylor", "Blake", "Eva",
        "Ryder", "Natalia", "Nolan", "Faith", "Tristan", "Alexandra", "Luis", "Emery", "Brody",
        "Brielle", "Juan", "Bella", "Cole", "Claire", "Carlos", "Ivy", "Jace", "Liliana", "Jesus",
        "Jasmine", "Hayden", "Keira", "Carlos", "Josephine", "Jax", "Delilah", "Dominic", "Bailey",
        "Cole", "Jade", "Miles", "Ximena", "Micah", "Valentina", "Vincent", "Alexa", "Axel",
        "London", "Ashley", "Emerson", "Everly", "Silas", "Iris", "Eric", "Emerson", "Brantley",
        "Daisy", "Diego", "Lyla", "Leonardo", "Makayla", "Cayden", "Molly", "Waylon", "Reagan",
        "Roman", "Kylee", "Josiah", "Amaya", "Jesus", "Jocelyn", "Leon", "Eden", "Damian", "Andrea",
        "Ezekiel", "Valeria", "Braxton", "Arianna", "Camden", "Emilia", "Giovanni", "Piper", "Bryce",
        "Lil Mel", "Jayce", "Adalynn", "Bryson", "Mary", "Angel", "Margaret", "Roman", "Annabelle",
        "Evan", "Athena", "Maverick", "Arya", "Bryan", "Gabriela", "Adam", "Vanessa", "Santiago",
        "Aliyah", "Jordan", "Adalyn", "Riley", "Jordan", "Dylan", "Brinley", "Everett", "Carly",
        "Xander", "Kayla", "Ian", "Paige", "Jesus", "Summer", "Sean", "Mila", "Oscar", "Sienna",
        "Cody", "Leila", "Kenneth", "Destiny", "Jaden", "Alaina", "Joel", "Alana", "Colin", "Reese",
        "Leon", "Elise", "Felix", "Finley", "Kaleb", "Brooke", "Kyle", "Lila", "Kaden", "Diana",
        "Preston", "Juliana", "Bennett", "Amy", "Jayce", "Daniela", "Weston", "Valerie", "Patrick",
        "Adriana", "Steven", "Jordyn", "Lorenzo", "Catherine", "Marcus", "Lydia", "Edward", "Eliza",
        "Aidan", "Danielle", "Jesse", "Sierra", "Jeremy", "Adrianna", "Braylen", "Bianca", "Roman",
        "Alivia", "Mark", "Kate", "Caden", "Payton", "Everett", "Mckenzie", "Jorge", "Parker"
    };
    private String teamName;
    private List<Player> players;
    private int wins;
    private int losses;
    private int money;
    private List<String> coaches;
    private String facilities;
    private boolean trainingStatus;
    private boolean sponsorshipStatus;

    // Constructor
    public Team(String teamName, List<Player> startingPlayers) {
        this.teamName = teamName;
        this.players = new ArrayList<>(startingPlayers);
        this.coaches = new ArrayList<>();
        this.facilities = "Basic";
        this.trainingStatus = false;
        this.sponsorshipStatus = false;
    }

    // Method to add a player to the team
    public void addPlayer(Player player) {
        players.add(player);
    }

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

    // Method to check facalties
    public void checkFacilities() {
        System.out.println("Facilities: " + facilities);
    }

    // Method to checktraining status
    public void checkTrainingStatus() {
        if (trainingStatus == true) {
            System.out.println("Training Status: Training in progress");
        } else {
            System.out.println("Training Status: No training in progress");
        }
    }
    
    // Method to check sponsorship status
    public boolean getSponsorshipStatus() {
        if (sponsorshipStatus == true) {
            return true;
        } else {
            return false;
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

    public void editPlayerType(String tagId, String newType) {
        Player player = getPlayer(tagId);
        if (player != null) {
            player.setType(newType);
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

    public void incrementWins() {
        this.wins++;
    }

    public void incrementLosses() {
        this.losses++;
    }

    public int getWins() {
        return this.wins;
    }

    public int getLosses() {
        return this.losses;
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int amount) {
        this.money += amount;
    }

    public void subtractMoney(int amount) {
        this.money -= amount;
    }

    public void hireCoach(String coach) {
        this.coaches.add(coach);
    }

    private String sponsor; // Add a sponsor field to the Team class

    public void upgradeFacilities(String facilities) {
        this.facilities = facilities;
    }

    public void conductTrainingSession() {
        this.trainingStatus = true;
    }

    public void getSponsorship(String sponsor) {
        this.sponsor = sponsor;
        this.sponsorshipStatus = true;
    }
}




