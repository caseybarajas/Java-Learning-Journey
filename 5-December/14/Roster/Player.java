/*
* Casey Barajas
* Player.java
* This class represents a player in the game with properties such as name, tag ID, accuracy rate, and type. It also includes methods to get and set these properties.
*/

public class Player {
    private String name;
    private String tagId;
    private double accuracyRate;
    private String type;

    // Constructor
    public Player(String name, String tagId, double accuracyRate, String type) {
        this.name = name;
        this.tagId = tagId;
        this.accuracyRate = accuracyRate;
        this.type = type;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public double getAccuracyRate() {
        return accuracyRate;
    }

    public void setAccuracyRate(double accuracyRate) {
        this.accuracyRate = accuracyRate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("Name: %-10s | Tag ID: %-6s | Accuracy: %-7.2f%% | Type: %-10s",
                             name, tagId, accuracyRate * 100, type);
    }
}