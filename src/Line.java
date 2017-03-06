import java.util.ArrayList;

public class Line implements Rotatable {
	private double radius;
	private double theta;
	private Direction currDirection;
	private double interval;

	public Direction getCurrDirection() {
		return currDirection;
	}
	public void setCurrDirection(Direction currDirection) {
		this.currDirection = currDirection;
	}
	public double getInterval() {
		return interval;
	}
	public void setInterval(double interval) {
		this.interval = interval;
	}
	public void setTheta(double theta) {
		// TODO Auto-generated method stub
		this.theta = theta;
	}
	public double getTheta(){
		return theta;
	}
	@Override
	public void setRadius(double radius) {
		// TODO Auto-generated method stub
		this.radius = radius;
	}
	public double getRadius(){
		return radius;
	}
	
	
	public Line(Direction d, double interval, double radius){
		this.currDirection = d;
		this.interval = interval;
		this.radius = radius;
		this.theta = 0;
	}
	public Line(Direction d, double interval, double radius, double theta){
		this.currDirection = d;
		this.interval = interval;
		this.radius = radius;
		this.theta = theta;
	}
	
	public static void main(String[] args){
		Line test = new Line(Direction.CLOCKWISE, 0.01, 1);
		for(int i = 0; i < 629; i++){
			System.out.println(test.getTheta());
			System.out.println(test.nextState());
		}
	}
	public ArrayList<CartesianPoint> nextState(){ // assumes center of graph is the center of screen/circumscribed circle
		this.rotate();
				
		return currentState();
	}
	public void rotate() {
		if(currDirection == Direction.CLOCKWISE) theta+=interval;
		else theta-=interval;
	}
	@Override
	public ArrayList<CartesianPoint> currentState() {
		// TODO Auto-generated method stub
		ArrayList<CartesianPoint> result = new ArrayList<CartesianPoint>();
		result.add(new PolarPoint(radius,theta).toCartesian());
		result.add(new PolarPoint(-radius, theta).toCartesian());
		return result;
	}
	
	
}
