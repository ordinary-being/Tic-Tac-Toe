package Model;

public class Board {
	
	private int size;
	private char[][] grid;
	
	public Board(int size) {
		
		this.size = size;
		this.grid = new char[size][size];
		
		for(int i = 0; i < size; i++)
			for(int j = 0; j < size; j++)
				grid[i][j] = ' ';
	}

	public int getSize() {
		return size;
	}

	public char[][] getGrid() {
		return grid;
	}
	
	void display() {
		
		for(int i = 0; i < size; i++) {
			System.out.print("| " + grid[i][0]+ " | ");
			for(int j = 1; j < size; j++)
				System.out.print(grid[i][j] + " | ");
			System.out.println();
		}
	}
}
 