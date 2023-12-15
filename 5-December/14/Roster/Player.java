/*
* Casey Barajas
* Player.java
* This class represents a player in the game with properties such as name, tag ID, accuracy rate, and type. It also includes methods to get and set these properties.
*/

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private String tagId;
    private double accuracyRate;
    private String type;
    private List<String> equipment;
    private int healthStatus;

    // Constructor
    public Player(String name, String tagId, double accuracyRate, String type) {
        this.name = name;
        this.tagId = tagId;
        this.accuracyRate = accuracyRate;
        this.type = type;
        this.equipment = new ArrayList<>();
        this.healthStatus = 100;  // Assuming health status is a percentage
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAccuracyRate(double accuracyRate) {
        this.accuracyRate = accuracyRate;
    }

    public void addEquipment(String equipment) {
        this.equipment.add(equipment);
    }

    public void heal() {
        this.healthStatus = 100;
    }

    @Override
    public String toString() {
        return String.format("Name: %-10s | Tag ID: %-6s | Accuracy: %-7.2f%% | Type: %-10s",
                             name, tagId, accuracyRate * 100, type);
    }
}