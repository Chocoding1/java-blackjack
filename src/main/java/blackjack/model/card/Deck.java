package blackjack.model.card;

import blackjack.model.user.User;
import blackjack.model.user.Users;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Deck {

    private static final int INIT_CARDS_START_INDEX = 0;
    private static final int INIT_CARDS_END_INDEX = 2;

    private final Queue<Card> deck = new LinkedList<>();

    public Deck() {
        initDeck();
    }

    public void drawInitCards(Users users) {
        for (User user : users.getUsers()) {
            drawTwoCard(user);
        }
    }

    public void drawOneCard(User user) {
        if (deck.peek() == null) {
            initDeck();
        }
        user.draw(deck.poll());
    }

    private void initDeck() {
        List<Card> cards = Arrays.stream(Rank.values())
                .flatMap(this::createCardsByRank)
                .collect(Collectors.toCollection(ArrayList::new));
        Collections.shuffle(cards);
        this.deck.addAll(cards);
    }

    private Stream<Card> createCardsByRank(Rank rank) {
        return Arrays.stream(Suit.values())
                .map(suit -> new Card(rank, suit));
    }

    private void drawTwoCard(User user) {
        for (int i = INIT_CARDS_START_INDEX; i < INIT_CARDS_END_INDEX; i++) {
            drawOneCard(user);
        }
    }
}
