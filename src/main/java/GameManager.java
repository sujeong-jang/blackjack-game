import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain.card.Card;
import domain.card.CardFactory;
import domain.user.Dealer;
import domain.user.Player;

public class GameManager {
	static final String PLAYER_NAMES_INPUT_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요(쉼표(,)기준으로 분리";
	static final String PLAYER_BETTING_MONEY_MESSAGE = "의 배팅 금액은?";

	Scanner sc;
	List<Player> players;
	List<Card> cards;
	Dealer dealer;
	
	public GameManager() {
		players = new ArrayList<>();
		dealer = new Dealer();
		cards = new ArrayList<>();
		sc = new Scanner(System.in);
	}
	
	public void run() {
		inputPlayer();
		createCard();
		addCardToUsers();
		showUserCards();
	}

	public List<Player> getPlayers() {
		return players;
	}
	
	/* 게임에 참여할 player와 각 플레이어의 배팅금액 입력 */
	public void inputPlayer() {
		System.out.println(PLAYER_NAMES_INPUT_MESSAGE);
		
		String names = sc.next();
		String[] splitNames = splitNames(names);
		
		for(int i=0; i<splitNames.length; i++) {
			System.out.println(splitNames[i] + PLAYER_BETTING_MONEY_MESSAGE);
			double money = sc.nextDouble();

			addPlayerList(splitNames[i], money);
		}
	}
	
	/* player의 이름과 배팅 금액을 받아 객체 생성 후 ArrayList에 추가  */
	public void addPlayerList(String name, double money) {
		players.add(new Player(name, money));
	}

	/* 쉼표를 기준으로 player 이름 분리 */
	public String[] splitNames(String names) {
		String[] nameArray = names.split(",");

		return nameArray;
	}
	
	public void createCard() {
		List<Card> tmp = CardFactory.create();

		for(Card card : tmp) {
			cards.add(card);
		}
	}
	
	public void addCardToUsers() {
		addPlayerCard();
		addPlayerCard();
		addDealerCard();
	}
	
	public void addPlayerCard() {
		for(int i=0; i<players.size(); i++) {
			cards = players.get(i).selectCard(cards);
		}
	}
	
	public void addDealerCard() {
		cards = dealer.selectCard(cards);
	}
	
	public void showUserCards() {
		List<String> playerList = new ArrayList<>();
		for(int i=0; i<players.size(); i++) {
			playerList.add(players.get(i).getName());
		}
		
		String player = String.join(",", playerList);
		System.out.println("딜러와" + player + "에게 2장의 카드를 나누었습니다.");
		
		showFirstResult();
	}
	
	public void showFirstResult() {
		dealer.showFirstCard();
		int size = players.size();

		int i = 0;
		while(size-- > 0) {
			players.get(i).showFirstCard();
			i++;
		}
	}
}
