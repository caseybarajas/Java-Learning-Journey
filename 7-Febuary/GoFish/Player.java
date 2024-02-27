/*
 * Casey Barajas
 * Player.java
 * 01/20/24
 */

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> hand = new ArrayList<>();
    private int pairsCount = 0;

    public void drawCard(Card card) {
        hand.add(card);
        checkForPair();
    }

    public void checkForPair() {
        List<Card> toRemove = new ArrayList<>();
        for (Card card1 : hand) {
            for (Card card2 : hand) {
                if (card1 != card2 && card1.equals(card2)) {
                    pairsCount++;
                    toRemove.add(card1);
                    toRemove.add(card2);
                    break;
                }
            }
            if (!toRemove.isEmpty()) {
                break;
            }
        }
        hand.removeAll(toRemove);
    }

    public int getPairsCount() {
        return pairsCount;
    }

    public boolean isHandEmpty() {
        return hand.isEmpty();
    }

    public List<Card> getHand() {
        return hand;
    }
}
