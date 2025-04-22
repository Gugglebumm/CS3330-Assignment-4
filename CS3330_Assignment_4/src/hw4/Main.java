package hw4;

import java.util.Scanner;

import hw4.game.Game;
import hw4.maze.Cell;
import hw4.maze.Grid;
import hw4.maze.Row;
import hw4.player.Movement;
import hw4.player.Player;

/**
 * Entry point for the Tears, Despair & Debugging simulation.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Game game = new Game(5); // Generate a 5x5 grid
        Grid grid = game.getGrid();

        // Start player in bottom-right corner
        int rowIndex = grid.getRows().size() - 1;
        int colIndex = grid.getRows().get(0).getCells().size() - 1;
        Row startRow = grid.getRows().get(rowIndex);
        Cell startCell = startRow.getCells().get(colIndex);
        Player player = new Player(startRow, startCell);

        System.out.println("Welcome to Tears, Despair & Debugging!");
        System.out.println("Escape the maze through the EXIT on the leftmost wall.");
        System.out.println("Controls: W = Up | A = Left | S = Down | D = Right");

        while (true) {
            // Print grid with player position
            printGrid(grid, player);

            System.out.print("Enter move (W/A/S/D): ");
            String input = scanner.nextLine().toUpperCase();

            Movement move = switch (input) {
                case "W" -> Movement.UP;
                case "A" -> Movement.LEFT;
                case "S" -> Movement.DOWN;
                case "D" -> Movement.RIGHT;
                default -> null;
            };

            if (!game.play(move, player)) {
                System.out.println("Invalid move!");
            }

            // Check for escape condition
            int col = player.getCurrentRow().getCells().indexOf(player.getCurrentCell());
            if (col == 0 && player.getCurrentCell().getLeft() == hw4.maze.CellComponents.EXIT) {
                System.out.println("You escaped the maze! 🎉");
                break;
            }
        }

        scanner.close();
    }

    private static void printGrid(Grid grid, Player player) {
        for (Row row : grid.getRows()) {
            for (Cell cell : row.getCells()) {
                if (cell == player.getCurrentCell()) {
                    System.out.print("A ");
                } else if (cell.getLeft() == hw4.maze.CellComponents.EXIT) {
                    System.out.print("E ");
                } else {
                    System.out.print("S ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
