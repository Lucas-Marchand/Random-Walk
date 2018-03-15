import java.util.ArrayList;
import java.util.Random;
import java.awt.Point;

/*
 * Class defines a RandomWalk object that takes input from the user for a grid.
 * It will then create a random path from the bottom left corner to the top right corner of the grid.
 * 
 * @author Lucas Marchand
 */
public class RandomWalk implements RandomWalkInterface {
	private int gridSize;
	private Random direction;
	private boolean done = false;
	private ArrayList<Point> path = new ArrayList<Point>();
	private Point end;
	private Point start;
	
	private int x = 0;
	private int y = 0;
	private final int STEP = 1;
	private int choose = 0;

	/*
	 * @param
	 * unseeded object constructor.
	 */
	public RandomWalk(int size) {
		gridSize = size;
		x = 0;
		y = gridSize-1;
		direction = new Random();
		start = new Point(0,gridSize-1);
		end = new Point(gridSize-1,0);
		path.clear();
		path.add(start);
	}

	/*
	 * @param
	 * seeded object constructor
	 */
	public RandomWalk(int size, long seed) {
		gridSize = size;
		x = 0;
		y = gridSize - 1;
		start = new Point(0,gridSize-1);
		end = new Point(gridSize-1,0);
		direction = new Random(seed);
		path.clear();
		path.add(start);
	}

	/*
	 * @return
	 * @see RandomWalkInterface#step()
	 * 
	 * takes one additional step toward the end point randomly between directional north
	 * and east.
	 */
	public void step() {
		// Randomly choose to increment x or y
		choose = direction.nextInt(2);

		// increment the y coordinate
		if (choose == 1) {
			// check if it is off the grid
			if (y != 0) {
				y -= STEP;
				path.add(new Point(x,y));
			} else if (y == 0 && x == gridSize-1) {
				done = true;
				
			}

			// increment the x coordinate
		} else if (choose == 0) {
			// check if it is off the grid
			if (x != gridSize-1) {
				x += STEP;
				path.add(new Point(x, y));
			} else if (x == gridSize -1 && y == 0) {
				done = true;
			}
		}
	}
	
	/*
	 * @return
	 * @see RandomWalkInterface#createWalk()
	 * 
	 * creates the entire ArrayList from "Start" point to "End" point.
	 */
	public void createWalk() {
		while (done == false) {
			step();
		}
	}

	/*
	 * @return
	 * @see RandomWalkInterface#isDone()
	 * 
	 * getter for the boolean status of the program. 
	 */
	public boolean isDone() {
		return done;
	}

	/*
	 * @return
	 * @see RandomWalkInterface#getGridSize()
	 * 
	 * getter for the current gridSize.
	 */
	public int getGridSize() {
		return gridSize;
	}

	/*
	 * @return
	 * @see RandomWalkInterface#getStartPoint()
	 * 
	 * getter for the start point in the ArrayList
	 */
	public Point getStartPoint() {
		return start;
	}

	/*
	 * @return
	 * @see RandomWalkInterface#getEndPoint()
	 * 
	 * getter for the end point in the ArrayList
	 */
	public Point getEndPoint() {
		return end;
	}

	/*
	 * @return
	 * @see RandomWalkInterface#getCurrentPoint()
	 * 
	 * getter for the current point in the ArrayList
	 */
	public Point getCurrentPoint() {
		return path.get(path.size() - 1);
	}

	/* 
	 * @return
	 * @see RandomWalkInterface#getPath()
	 * 
	 * open a public copy of the ArrayList that encapsulates the original
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Point> getPath() {
		return (ArrayList<Point>) path.clone();
	}

	/*
	 * @return
	 * 
	 * getter for a string form of the ArrayList format for ease of reading to the user.
	 */
	public String toString() {
		String string = "";
		for (Point p : path) {
			string = string + "[" + p.x + "," + p.y + "] ";
		}
		return string;
	}

//	@Override
//	public void stepEC() {
//		// TODO Auto-generated method stub
//
//	}

//	@Override
//	public void createWalkEC() {
//		// TODO Auto-generated method stub
//
//	}
}
