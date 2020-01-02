package domain.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domain.card.Card;

/**
 * 게임 참여자를 의미하는 객체
 */
public class Player {
    private final String name;
    private final double bettingMoney;
    private final List<Card> cards = new ArrayList<>();

    public Player(String name, double bettingMoney) {
        this.name = name;
        this.bettingMoney = bettingMoney;
    }

    public void addCard(Card card) {
        cards.add(card);
    }
    
    public String getName() {
    	return name;
    }
    
    public List<Card> getCards(){
    	return cards;
    }
    
    public void showFirstCard() {
    	System.out.println(name + "카드:" + cards.get(0).getCard() +","+ cards.get(1).getCard());
    }
    
    public List<Card> selectCard(List<Card> newCards) {
    	Collections.shuffle(newCards);
    	addCard(newCards.get(0));
    	newCards.remove(0);
    	
    	return newCards;
    }
    // TODO 추가 기능 구현

}
