package hw4.maze;

import java.util.ArrayList;

public class Grid {

	private ArrayList<Row> rows;

	/**
	 * A constructor for Grid objects which act
	 * as the area to play the game, being made up
	 * of an ArrayList of Row's of Cells. Initializes
	 * the Grid's ArrayList of Rows
	 * @param rows The received ArrayList of Rows
	 */
	public Grid(ArrayList<Row> rows) {
		this.rows = rows;
	}

	/**
	 * Retrieves the ArrayList of Rows of the Grid
	 * @return ArrayList of Rows
	 */
	public ArrayList<Row> getRows() {
		return rows;
	}

	/**
	 * Receives an ArrayList of Rows to be assigned
	 * to the Rows in the Grid's ArrayList
	 * @param rows The ArrayList of Rows to be assigned
	 * to the Grid's Rows
	 */
	public void setRows(ArrayList<Row> rows) {
		this.rows = rows;
	}

	/**
	 * Prints every Cell in every Row in the Grid
	 */
	@Override
	public String toString() {
		return "Grid [rows=" + rows + "]";
	}
	
}
