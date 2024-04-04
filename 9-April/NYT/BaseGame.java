public abstract class BaseGame implements Game {
    protected String name;
    protected int score;

    public BaseGame(String name) {
        this.name = name;
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
}