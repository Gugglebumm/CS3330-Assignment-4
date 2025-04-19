package hw4;

import hw4.maze.Cell;
import hw4.maze.CellComponents;

public class Main {

	public static void main(String[] args) {
		
		Cell cell = new Cell(CellComponents.EXIT, CellComponents.WALL, CellComponents.APERTURE, CellComponents.WALL);
		System.out.println(cell);
		cell.setUp(null);
		System.out.println(cell);


	}

}
