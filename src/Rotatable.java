import java.util.ArrayList;

public interface Rotatable {
	public void rotate();
	public ArrayList<CartesianPoint> nextState();
	public Direction getCurrDirection();
	public void setCurrDirection(Direction d);
	public double getInterval();
	public void setInterval(double interval);
	public ArrayList<CartesianPoint> currentState();
	public void setRadius(double radius);
	public double getRadius();
	public void setTheta(double theta);
	public double getTheta();
}
