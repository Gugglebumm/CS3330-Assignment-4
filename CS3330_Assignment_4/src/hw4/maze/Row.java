package hw4.maze;

import java.util.ArrayList;

public class Row {
	
	private ArrayList<Cell> cells;

	/**
	 * A constructor for Row objects which act as
	 * rows of Cell objects to create a grid for the
	 * game. Initializes the Row's ArrayList of Cells
	 * @param cells The received ArrayList of Cells
	 */
	public Row(ArrayList<Cell> cells) {
		this.cells = cells;
	}

	/**
	 * Retrieves the ArrayList of Cells of the Row
	 * @return ArrayList of Cells
	 */
	public ArrayList<Cell> getCells() {
		return cells;
	}

	/**
	 * Receives an ArrayList of Cells to be assigned
	 * the Cells in Row's ArrayList
	 * @param cells The ArrayList of Cells to be assigned
	 * to the Row's Cells
	 */
	public void setCells(ArrayList<Cell> cells) {
		this.cells = cells;
	}

	/**
	 * Prints every Cell in the Row's ArrayList of Cells
	 */
	@Override
	public String toString() {
		return "Row [cells=" + cells + "]";
	}
	

}
