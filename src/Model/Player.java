package Model;

public class Player {

	private String name;
	private char symbol;
	
	private int[] rowSum;
	private int[] colSum;
	private int digSum;
	private int revDigSum;
	
	public Player(String name, char symbol, int size) {

		this.name = name;
		this.symbol = symbol;

		rowSum = new int[size];
		colSum = new int[size];
		digSum = 0;
		revDigSum = 0;
	}

	public String getName() {
		return name;
	}

	public char getSymbol() {
		return symbol;
	}
	
	boolean hasWon(int move, int boardSize) {
		
		int row = move / boardSize, col = move % boardSize;
		
		rowSum[row]++;
		
		colSum[col]++;
		
		if(row == col) digSum++;
		
		if((row + col) == (boardSize - 1)) revDigSum++;
		
		return (rowSum[row] == boardSize || colSum[col] == boardSize || digSum == boardSize || revDigSum == boardSize);
	}
}
