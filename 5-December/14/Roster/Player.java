public class Player {
    private String name;
    private String tagId;
    private double accuracyRate;

    // Constructor
    public Player(String name, String tagId, double accuracyRate) {
        this.name = name;
        this.tagId = tagId;
        this.accuracyRate = accuracyRate;
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

    // toString method for displaying player information
    @Override
    public String toString() {
        return String.format("Name: %-15s | Tag ID: %-10s | Accuracy Rate: %.2f%%",
                             name, tagId, accuracyRate * 100);
    }    
}
