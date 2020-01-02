package domain.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domain.card.Card;

/**
 * 게임 딜러를 의미하는 객체
 */
public class Dealer {
    private final List<Card> cards = new ArrayList<>();

    public Dealer() {}

    public void addCard(Card card) {
        cards.add(card);
    }
    
    public List<Card> getCards(){
    	return cards;
    }
    
    public void showFirstCard() {
    	System.out.println("딜러:" + cards.get(0).getCard());
    }
    
    public List<Card> selectCard(List<Card> newCards) {
    	Collections.shuffle(newCards);
    	addCard(newCards.get(0));
    	newCards.remove(0);
    	
    	return newCards;
    }

    // TODO 추가 기능 구현
}
