package hw4.game;

import java.util.ArrayList;
import java.util.Random;

import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.maze.Row;
import hw4.player.Movement;
import hw4.player.Player;

/**
 * Represents the game state and logic for Tears, Despair & Debugging.
 */
public class Game {
    private Grid grid;
    private Random rand = new Random();

    /**
     * A constructor for the Game object 
     * which acts as the game itself, having
     * a Grid object as an area to play.
     * Initializes the Game's Grid with a pre-made
     * Grid object
     * @param grid The received Grid 
     */
    public Game(Grid grid) {
        this.grid = grid;
    }

    /**
     * A constructor for the Game object 
     * which acts as the game itself, having
     * a Grid object as an area to play.
     * Initializes the Game's grid by making
     * one with a size between 3 and 7.
     * @param size The received size the Grid
     * will be.
     */
    public Game(int size) {
        if (size >= 3 && size <= 7) {
            this.grid = createRandomGrid(size);
        } else {
            this.grid = null;
        }
    }

    /**
     * Retrieves the Game's Grid 
     * @return The Grid
     */
    public Grid getGrid() {
        return grid;
    }

    /**
     * Receives a Grid object to be assigned
     * to the Game's Grid.
     * @param grid The Grid object to be assigned
     * to the Game's Grid.
     */
    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    /**
     * Creates a grid from a received size,
     * making sure every cell in the grid has
     * at least one APERTURE and the exit is
     * on the leftmost side of the grid.
     * @param size The received size the Grid
     * will be.
     * @return The Grid with its newly created
     * ArrayList of Rows of Cells.
     */
    public Grid createRandomGrid(int size) {
        if (size < 3 || size > 7) return null;

        ArrayList<Row> rows = new ArrayList<>();
        boolean exitPlaced = false;
        int exitRow = rand.nextInt(size); // ensure exactly one EXIT

        for (int r = 0; r < size; r++) {
            ArrayList<Cell> cells = new ArrayList<>();

            for (int c = 0; c < size; c++) {
                CellComponents left = CellComponents.WALL;
                CellComponents right = CellComponents.WALL;
                CellComponents up = CellComponents.WALL;
                CellComponents down = CellComponents.WALL;

                // Match left neighbor
                if (c > 0) {
                    Cell leftNeighbor = cells.get(c - 1);
                    left = leftNeighbor.getRight();
                } else if (c == 0 && r == exitRow && !exitPlaced) {
                    left = CellComponents.EXIT;
                    exitPlaced = true;
                }

                // Match top neighbor
                if (r > 0) {
                    Cell topNeighbor = rows.get(r - 1).getCells().get(c);
                    up = topNeighbor.getDown();
                }

                // Randomize right and down
                right = rand.nextBoolean() ? CellComponents.APERTURE : CellComponents.WALL;
                down = rand.nextBoolean() ? CellComponents.APERTURE : CellComponents.WALL;

                // Ensure at least one APERTURE
                if (left != CellComponents.APERTURE &&
                    right != CellComponents.APERTURE &&
                    up != CellComponents.APERTURE &&
                    down != CellComponents.APERTURE) {
                    right = CellComponents.APERTURE; // force one
                }

                cells.add(new Cell(left, right, up, down));
            }
            rows.add(new Row(cells));
        }

        return new Grid(rows);
    }

    /**
     * Receives a Player of the Game and the
     * move the player is making. Moves the player
     * if there is an APERTURE in the direction
     * of the player's received move.
     * @param move The player's move
     * @param player The object which moves through
     * the Game's Grid
     * @return True if the move is valid, or false
     * if it is invalid.
     */
    public boolean play(Movement move, Player player) {
        if (move == null || player == null || grid == null) return false;

        ArrayList<Row> rows = grid.getRows();
        int rowIndex = rows.indexOf(player.getCurrentRow());
        int colIndex = player.getCurrentRow().getCells().indexOf(player.getCurrentCell());

        try {
            switch (move) {
                case UP -> {
                    if (rowIndex > 0 &&
                        player.getCurrentCell().getUp() == CellComponents.APERTURE) {
                        player.setCurrentRow(rows.get(rowIndex - 1));
                        player.setCurrentCell(rows.get(rowIndex - 1).getCells().get(colIndex));
                        return true;
                    }
                }
                case DOWN -> {
                    if (rowIndex < rows.size() - 1 &&
                        player.getCurrentCell().getDown() == CellComponents.APERTURE) {
                        player.setCurrentRow(rows.get(rowIndex + 1));
                        player.setCurrentCell(rows.get(rowIndex + 1).getCells().get(colIndex));
                        return true;
                    }
                }
                case LEFT -> {
                    if (colIndex > 0 &&
                        player.getCurrentCell().getLeft() == CellComponents.APERTURE) {
                        player.setCurrentCell(rows.get(rowIndex).getCells().get(colIndex - 1));
                        return true;
                    }
                    // Escape condition
                    if (colIndex == 0 &&
                        player.getCurrentCell().getLeft() == CellComponents.EXIT) {
                        return true;
                    }
                }
                case RIGHT -> {
                    if (colIndex < rows.get(rowIndex).getCells().size() - 1 &&
                        player.getCurrentCell().getRight() == CellComponents.APERTURE) {
                        player.setCurrentCell(rows.get(rowIndex).getCells().get(colIndex + 1));
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            return false;
        }

        return false;
    }

    /**
     * Prints the Game's Grid.
     */
    @Override
    public String toString() {
        return "Game [grid=" + grid + "]";
    }
}
