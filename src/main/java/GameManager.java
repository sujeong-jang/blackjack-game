import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain.user.Player;

public class GameManager {

	Scanner sc;
	List<Player> players;
	
	public GameManager() {
		players = new ArrayList<>();
		sc = new Scanner(System.in);
	}
	
	public void run() {
		inputPlayer();
	}

	public List<Player> getPlayers() {
		return players;
	}
	
	/* 게임에 참여할 player와 각 플레이어의 배팅금액 입력 */
	public void inputPlayer() {
		System.out.println("게임에 참여할 사람의 이름을 입력하세요(쉼표(,)기준으로 분리");
		
		String names = sc.next();
		String[] splitNames = splitNames(names);
		
		for(int i=0; i<splitNames.length; i++) {
			System.out.println(splitNames[i] + "의 배팅 금액은?");
			int money = sc.nextInt();

			addPlayerList(splitNames[i], money);
		}
	}
	
	/* player의 이름과 배팅 금액을 받아 객체 생성 후 ArrayList에 추가  */
	public void addPlayerList(String name, int money) {
		players.add(new Player(name, money));
	}
	
	/* 배팅금액 입력  */
	public int inputBettingMoney() {
		return sc.nextInt();
	}

	/* 쉼표를 기준으로 player 이름 분리 */
	public String[] splitNames(String names) {
		String[] nameArray = names.split(",");

		return nameArray;
	}
}
