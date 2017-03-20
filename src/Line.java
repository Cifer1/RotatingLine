import java.util.ArrayList;
/*
 * Line is a Rotatable object that represents a 2D line. Private data includes the direction of rotation for the Line, 
 * the radius of the circle bounding the line, the interval (in radians) at which the 
 * line rotates, and the angle of the first vertex of the line.
 *  One constructor takes in the initial direction, the radius of the bounding circle, and the interval
 * at which the polygon rotates. The other ctor also takes in the initial angle theta. Methods include rotating the line one interval, finding the next set of vertices, and getting/setting
 * the current direction of rotation, interval of rotation, radius of the bounding circle, and angle of the first vertex. 
 */
public class Line implements Rotatable {
	private double radius;
	private double theta;
	private Direction currDirection;
	private double interval;

	public Direction getCurrDirection() {
		/*
		 * getter for current direction of rotation of the Line, either CLOCKWISE or COUNTERCLOCKWISE, uses Direction enum type, O(1)
		 */
		return currDirection;
	}
	public void setCurrDirection(Direction currDirection) {
		/*
		 * setter for current direction of rotation of the Line, either CLOCKWISE or COUNTERCLOCKWISE, uses Direction enum type, O(1)
		 */
		this.currDirection = currDirection;
	}
	public double getInterval() {
		/*
		 * Getter for current interval of rotation for the Line, represents how many radians the Line rotates every tick. O(1)
		 */
		return interval;
	}
	public void setInterval(double interval) {
		/*
		 * Setter for current interval of rotation for the Line, represents how many radians the Line rotates every tick. O(1)
		 */
		this.interval = interval;
	}
	public void setTheta(double theta) {
		/*
		 * setter for current angle of the first vertex theta, takes in double theta O(1)
		 */
		this.theta = theta;
	}
	public double getTheta(){
		/*
		 * getter for current angle of the first vertex theta, returns double theta O(1)
		 */
		return theta;
	}
	@Override
	public void setRadius(double radius) {
		/*
		 * setter for the radius of the bounding circle, takes in double radius O(1)
		 */
		// TODO Auto-generated method stub
		this.radius = radius;
	}
	public double getRadius(){
		/*
		 * getter for the radius of the bounding circle, returns a double radius O(1)
		 */
		return radius;
	}
	
	
	public Line(Direction d, double interval, double radius){
		/* 
		 * This constructor takes in Direction d (direction of rotation), double interval
		 * (how many radians the Line shifts every rotation), and double radius (radius of the bounding circle), and sets
		 * the relevant private data. Initial angle theta is set to 0. O(1)
		 */
		this.currDirection = d;
		this.interval = interval;
		this.radius = radius;
		this.theta = 0;
	}
	public Line(Direction d, double interval, double radius, double theta){
		/* 
		 * This constructor takes in Direction d (direction of rotation), double interval
		 * (how many radians the shape shifts every rotation), double radius (radius of the circumscribed circle), and double theta 
		 * (initial angle of the first vertex compared to x axis), and sets the relevant private data. O(1)
		 */
		this.currDirection = d;
		this.interval = interval;
		this.radius = radius;
		this.theta = theta;
	}
	
	public static void main(String[] args){
		// testing
		Line test = new Line(Direction.CLOCKWISE, 0.01, 1);
		for(int i = 0; i < 629; i++){
			System.out.println(test.getTheta());
			System.out.println(test.nextState());
		}
	}
	public ArrayList<CartesianPoint> nextState(){ 
		/*
		 * nextState() rotates the Line and then returns the state of the Line post rotation in the form of an ArrayList of
		 * CartesianPoints that represent individual vertices of the Line. O(1)
		 */
		this.rotate();	
		return currentState();
	}
	public void rotate() {
		/*
		 * rotate() shifts the position of the Line by incrementing or decrementing the current angle theta of the first vertex.
		 * Incrementing happens when the Line is rotating clockwise, and decrementing happens when the Line is rotating counterclockwise. O(1)
		 */
		if(currDirection == Direction.CLOCKWISE) theta+=interval;
		else theta-=interval;
	}
	@Override
	public ArrayList<CartesianPoint> currentState() {
		/*
		 * currentState() returns the current positions of both vertices of the Line. The method calculates current position
		 * of each vertex using polar coordinate conversions to cartesian (basically using principle that the line is formed
		 * of point (r,theta) and (-r, theta)) The method assumes the mdpt of the line is the origin. O(1)
		 */
		ArrayList<CartesianPoint> result = new ArrayList<CartesianPoint>();
		result.add(new CartesianPoint(radius,theta));
		result.add(new CartesianPoint(-radius, theta));
		return result;
	}
	
	
}
