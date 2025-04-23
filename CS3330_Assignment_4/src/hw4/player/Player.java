// Player.java
package hw4.player;

import hw4.maze.Cell;
import hw4.maze.Row;

/**
 * Represents the player/agent inside the maze.
 */
public class Player {
    private Cell currentCell;
    private Row currentRow;

    /**
     * Constructs a Player with starting position in the given row and cell.
     * @param currentRow Starting row
     * @param currentCell Starting cell
     */
    public Player(Row currentRow, Cell currentCell) {
        this.currentRow = currentRow;
        this.currentCell = currentCell;
    }

    public Cell getCurrentCell() { return currentCell; }
    public Row getCurrentRow() { return currentRow; }
    public void setCurrentCell(Cell cell) { this.currentCell = cell; }
    public void setCurrentRow(Row row) { this.currentRow = row; }

    @Override
    public String toString() {
        return "Player [currentCell=" + currentCell + ", currentRow=" + currentRow + "]";
    }
}
