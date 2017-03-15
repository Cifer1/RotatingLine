import java.util.ArrayList;
/*
 * Polygon is a Rotatable object that represents a 2D regular polygon. Private data includes the direction of rotation for the Polygon, 
 * the vertices of the polygon relative to the center of the circumscribed circle, and the interval (in radians) at which the 
 * polygon rotates. The only constructor takes in the initial direction, # of sides, the radius of the circumscribed circle, and the interval
 * at which the polygon rotates. Methods include rotating the polygon one interval, finding the next set of vertices, and getting/setting
 * the current direction of rotation and interval of rotation. 
 */
public class Polygon implements Rotatable {
	private Direction currDirection;
	private double interval;
	private int sides;
	private double radius;
	private double theta;
	
	public Polygon(Direction d, int sides, double interval, double radius){
		currDirection = d;
		this.sides = sides;
		this.radius = radius;
		this.theta = 0;
		this.interval = interval;
		
	}
	public Polygon(Direction d, int sides, double interval, double radius, double theta){
		currDirection = d;
		this.sides = sides;
		this.radius = radius;
		this.theta = theta;
		this.interval = interval;
		
	}
	@Override
	public void rotate() {
		if (currDirection == Direction.CLOCKWISE) theta+=interval;
		else theta-=interval;
	}

	@Override
	public ArrayList<CartesianPoint> nextState() {
		rotate();
		return currentState();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Polygon test = new Polygon(Direction.CLOCKWISE, 5, 1, 0.01);
		for(int i = 0; i < 629; i++){
			System.out.println(test.nextState());
		}
	}
	@Override
	public Direction getCurrDirection() {
		// TODO Auto-generated method stub
		return currDirection;
	}
	@Override
	public void setCurrDirection(Direction d) {
		// TODO Auto-generated method stub
		this.currDirection = d;
	}
	@Override
	public double getInterval() {
		// TODO Auto-generated method stub
		return interval;
	}
	@Override
	public void setInterval(double interval) {
		this.interval = interval;
	}
	@Override
	public ArrayList<CartesianPoint> currentState() {
		// TODO Auto-generated method stub
		ArrayList<CartesianPoint> curr = new ArrayList<CartesianPoint>();
		for(int i = 1; i < sides+1; i++){
			curr.add(new CartesianPoint(radius, theta + (Math.PI * 2)/sides *i));
		}
		return curr;
	}
	@Override
	public void setRadius(double radius) {
		this.radius = radius;
		
	}
	@Override
	public double getRadius() {
		// TODO Auto-generated method stub
		return radius;
	}
	@Override
	public void setTheta(double theta) {
		// TODO Auto-generated method stub
		this.theta = theta;
	}
	@Override
	public double getTheta() {
		// TODO Auto-generated method stub
		return theta;
	}

}
