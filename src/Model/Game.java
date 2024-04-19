package Model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Game {

	private int movesPlayed;
	private Queue<Player> players;
	private Board board;
	
	public Game(int boardSize) {
		
		movesPlayed = 0;
		players = new LinkedList<>();
		board = new Board(boardSize);
	}
	
	public void addPlayers(List<Map<String, Object>> playersInfo) {
		
		if(playersInfo.size() <= 1) {
			throw new IllegalArgumentException("There should be at least 2 players to play the game");
		}
		
		int size = board.getSize();
		Set<Character> pickedSymbols = new HashSet<>();
		
		for(Map<String, Object> info : playersInfo) {
			
			char symbol = (char) info.get("symbol");
			
			if(!pickedSymbols.add(symbol)) {
				throw new IllegalArgumentException("Two players can't choose same symbols");
			}
			
			players.add(new Player(info.get("name").toString(), symbol, size));
		}
	}
	
	public void play() {
		
		int boardSize = board.getSize(), totalMoves = boardSize * boardSize;
		Scanner scanner = new Scanner(System.in);
		
		while(movesPlayed < totalMoves) {
			
			board.display();
			
			Player player = players.poll();
			
			int move;
			do {
				System.out.print(player.getName() + ", Your turn: ");
				move = scanner.nextInt();
			} while(!isValidMove(move));
			
			makeMove(move, player.getSymbol());
			movesPlayed++;
			
			if(player.hasWon(move, boardSize)) {
				board.display();
				System.out.println(player.getName() + " Won!");
				return;
			}
			
			players.add(player);
		}
		
		board.display();
		System.out.println("Game resulted in a Draw");
		scanner.close();
	}
	
	private boolean isValidMove(int move) {
		
		int size = board.getSize();
		
		if(move < 0 || move == size * size) return false;
		
		
		int row = move / size,  col = move % size;
		return (board.getGrid()[row][col] == ' '); 
	}
	
	private void makeMove(int move, char symbol) {
		
		int size = board.getSize(); 
		int row = move / size, col = move % size;
		board.getGrid()[row][col] = symbol;
	}
}
