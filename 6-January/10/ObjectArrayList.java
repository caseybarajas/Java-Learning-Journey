/*
 * Casey Barajas
 * 01/10/2020
 * This program creates a Joke class and uses it to create a list of jokes.
 */

import java.util.ArrayList;

class Joke {
    private String punchline;
    String setup;
    int laughScore;

    Joke(String setup, String punchline, int laughScore) {
        this.setup = setup;
        this.punchline = punchline;
        this.laughScore = laughScore;
    }

    String getPunchline() {
        return this.punchline;
    }

    void setLaughScore(int newScore) {
        this.laughScore = newScore;
    }

    @Override
    public String toString() {
        return "Joke: " + setup + " Punchline: " + punchline + " Laugh Score: " + laughScore;
    }
}

public class ObjectArrayList {
    public static void main(String[] args) {
        ArrayList<Joke> jokeList = new ArrayList<>();

        jokeList.add(new Joke("Why don't scientists trust atoms?", "Because they make up everything!", 8));
        jokeList.add(new Joke("Why did the scarecrow win an award?", "Because he was outstanding in his field!", 7));
        jokeList.add(new Joke("Why don't some fish play piano?", "Because you can't tuna fish!", 6));
        jokeList.add(new Joke("Why did the bicycle fall over?", "Because it was two tired!", 9));
        jokeList.add(new Joke("What do you call fake spaghetti?", "An impasta!", 7));

        System.out.println(jokeList);
        System.out.println("Size of jokeList: " + jokeList.size());
        System.out.println(""); // Spacing

        Joke newJoke = new Joke("Why don't we tell secrets on a farm?", "Because the potatoes have eyes, the corn has ears, and the beans stalk.", 10);
        jokeList.set(0, newJoke);

        System.out.println(jokeList.get(2)); // Printing the "tuna fish" joke
        System.out.println(""); // Spacing

        System.out.println("Is the 'tuna fish' joke in the list? " + jokeList.contains(jokeList.get(2)));
        jokeList.remove(jokeList.get(2));
        System.out.println(""); // Spacing

        System.out.println(jokeList);
        System.out.println("Size of jokeList: " + jokeList.size());
        System.out.println(""); // Spacing

        for (Joke joke : jokeList) {
            joke.setLaughScore(10); // Everyone's a winner!
        }

        System.out.println("Is jokeList empty? " + jokeList.isEmpty());
        System.out.println(""); // Spacing

        jokeList.clear();

        System.out.println(jokeList);
        System.out.println("Size of jokeList: " + jokeList.size());
        System.out.println("Is jokeList empty? " + jokeList.isEmpty());
    }
}