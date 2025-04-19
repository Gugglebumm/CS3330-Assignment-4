package hw4.maze;

public class Cell {
	
	private CellComponents left, right, up, down;
	
	/**
	 * Constructor for Cell objects which act as the individual
	 * spaces on the grid for our game. Initializes the four sides
	 * of the Cell with CellComponents which determine if their is
	 * a WALL, EXIT, or APERTURE on each side
	 * @param left The received CellComponent for the left side
	 * @param right The received CellComponent for the right side
	 * @param up The received CellComponent for the up
	 * @param down The received CellComponent for the down
	 */
	public Cell(CellComponents left, CellComponents right, CellComponents up, CellComponents down) {
		this.left = left;
		this.right = right;
		this.up = up;
		this.down = down;
	}

	/**
	 * Retrieves the CellComponent to the left of the Cell
	 * @return left
	 */
	public CellComponents getLeft() {
		return left;
	}

	/**
	 * Sets the left CellComponent of the Cell with the 
	 * received CellComponent, setting the left to WALL
	 * if the received CellComponent is null
	 * @param left The CellComponent to be assigned to
	 * in the Cell's left CellComponent
	 */
	public void setLeft(CellComponents left) {
		if(left == null) {
			this.left = CellComponents.WALL;
		}
		else
			this.left = left;
	}
	
	/**
	 * Retrieves the CellComponent to the right of the Cell
	 * @return right
	 */
	public CellComponents getRight() {
		return right;
	}

	/**
	 * Sets the right CellComponent of the Cell with the 
	 * received CellComponent, setting the right to WALL
	 * if the received CellComponent is null
	 * @param right The CellComponent to be assigned to
	 * in the Cell's right CellComponent
	 */
	public void setRight(CellComponents right) {
		if(right == null) {
			this.right = CellComponents.WALL;
		}
		else
			this.right = right;
	}

	/**
	 * Retrieves the CellComponent above the Cell
	 * @return up
	 */
	public CellComponents getUp() {
		return up;
	}

	/**
	 * Sets the up CellComponent of the Cell with the 
	 * received CellComponent, setting the up to WALL
	 * if the received CellComponent is null
	 * @param up The CellComponent to be assigned to
	 * in the Cell's up CellComponent
	 */
	public void setUp(CellComponents up) {
		if(up == null) {
			this.up = CellComponents.WALL;
		}
		else
			this.up = up;
	}

	/**
	 * Retrieves the CellComponent below the Cell
	 * @return down
	 */
	public CellComponents getDown() {
		return down;
	}

	/**
	 * Sets the down CellComponent of the Cell with the 
	 * received CellComponent, setting the down to WALL
	 * if the received CellComponent is null
	 * @param down The CellComponent to be assigned to
	 * in the Cell's down CellComponent
	 */
	public void setDown(CellComponents down) {
		if(down == null) {
			this.down = CellComponents.WALL;
		}
		else
			this.down = down;
	}

	/**
	 * Prints the four sides of the Cell
	 */
	@Override
	public String toString() {
		return "Cell [left=" + left + ", right=" + right + ", up=" + up + ", down=" + down + "]";
	}

	

}
