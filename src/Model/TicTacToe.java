package Model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TicTacToe {

	public static void main(String[] args) {
		
		int boardSize = 4;
		
		List<Map<String, Object>> playersInfo = Arrays.asList(
				Map.of("name", "Player1", "symbol", 'X'),
				Map.of("name", "Player2" , "symbol", 'O')
			);
		
		
		Game ticTacToe = new Game(boardSize);
		ticTacToe.addPlayers(playersInfo);
		ticTacToe.play();
	}
}
