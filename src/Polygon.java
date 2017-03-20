import java.util.ArrayList;
/*
 * Polygon is a Rotatable object that represents a 2D regular polygon. Private data includes the direction of rotation for the Polygon, 
 * the # of sides,  the interval (in radians) at which the polygon rotates, the angle of the first vertex, and the radius of the circumscribed circle. 
 * One constructor takes in the initial direction, # of sides, the radius of the circumscribed circle, and the interval
 * at which the polygon rotates. The other ctor also takes in the initial angle theta. Methods include rotating the polygon one interval, finding the next set of vertices, and getting/setting
 * the current direction of rotation, interval of rotation, radius, and angle of first vertex. 
 */
public class Polygon implements Rotatable {
	private Direction currDirection;
	private double interval;
	private int sides;
	private double radius;
	private double theta;
	
	public Polygon(Direction d, int sides, double interval, double radius){
		/* 
		 * This constructor takes in Direction d (direction of rotation), int sides (# of sides on the polygon), double interval
		 * (how many radians the shape shifts every rotation), and double radius (radius of the circumscribed circle), and sets
		 * the relevant private data. Initial angle theta is set to 0. O(1)
		 */
		currDirection = d;
		this.sides = sides;
		this.radius = radius;
		this.theta = 0;
		this.interval = interval;
		
	}
	public Polygon(Direction d, int sides, double interval, double radius, double theta){
		/* 
		 * This constructor takes in Direction d (direction of rotation), int sides (# of sides on the polygon), double interval
		 * (how many radians the shape shifts every rotation), double radius (radius of the circumscribed circle), and double theta 
		 * (initial angle of the first vertex compared to x axis), and sets the relevant private data. O(1)
		 */
		currDirection = d;
		this.sides = sides;
		this.radius = radius;
		this.theta = theta;
		this.interval = interval;
		
	}
	@Override
	public void rotate() {
		/*
		 * rotate() shifts the position of the polygon by incrementing or decrementing the current angle theta of the first vertex.
		 * Incrementing happens when the shape is rotating clockwise, and decrementing happens when the shape is rotating counterclockwise. O(1)
		 */
		if (currDirection == Direction.CLOCKWISE) theta+=interval;
		else theta-=interval;
	}

	@Override
	public ArrayList<CartesianPoint> nextState() {
		/*
		 * nextState() rotates the Polygon and then returns the state of the Polygon post rotation in the form of an ArrayList of
		 * CartesianPoints that represent individual vertices of the polygon. O(n)
		 */
		rotate();
		return currentState();
	}

	public static void main(String[] args) {
		// testing
		Polygon test = new Polygon(Direction.CLOCKWISE, 5, 1, 0.01);
		for(int i = 0; i < 629; i++){
			System.out.println(test.nextState());
		}
	}
	@Override
	public Direction getCurrDirection() {
		/*
		 * getter for current direction of rotation of the Polygon, either CLOCKWISE or COUNTERCLOCKWISE, uses Direction enum type O(1)
		 */
		return currDirection;
	}
	@Override
	public void setCurrDirection(Direction d) {
		/*
		 * setter for current direction of rotation of the Polygon, either CLOCKWISE or COUNTERCLOCKWISE, uses Direction enum type O(1)
		 */
		this.currDirection = d;
	}
	@Override
	public double getInterval() {
		/*
		 * Getter for current interval of rotation for the Polygon, represents how many radians the shape rotates every tick. O(1)
		 */
		return interval;
	}
	@Override
	public void setInterval(double interval) {
		/*
		 * Setter for current interval of rotation for the Polygon, represents how many radians the shape rotates every tick. O(1)
		 */
		this.interval = interval;
	}
	@Override
	public ArrayList<CartesianPoint> currentState() {
		/*
		 * currentState() returns the current positions of all vertices of the polygon. The method calculates current position of each
		 * vertex by starting at angle theta (private data) and adding 2pi/# of sides to calculate a cartesian point from a polar coordinate
		 * representing the vertex. The resulting list contains each vertex only once, in the form of a CartesianPoint. The method assumes
		 * the origin is the center of the circumscribed circle. O(n)
		 */
		ArrayList<CartesianPoint> curr = new ArrayList<CartesianPoint>();
		for(int i = 1; i < sides+1; i++){
			curr.add(new CartesianPoint(radius, theta + (Math.PI * 2)/sides *i));
		}
		return curr;
	}
	@Override
	public void setRadius(double radius) {
		/*
		 * setter for the radius of the circumscribed circle, takes in double radius O(1)
		 */
		this.radius = radius;
		
	}
	@Override
	public double getRadius() {
		/*
		 * getter for the radius of the circumscribed circle, returns a double radius O(1)
		 */
		return radius;
	}
	@Override
	public void setTheta(double theta) {
		/*
		 * setter for current angle of the first vertex theta, takes in double theta O(1)
		 */
		this.theta = theta;
	}
	@Override
	public double getTheta() {
		/*
		 * getter for current angle of the first vertex theta, returns double theta O(1)
		 */
		return theta;
	}

}
