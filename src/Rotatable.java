import java.util.ArrayList;
/*
 * Rotatable is an interface that represents common actions that any object able to rotate should be able to perform. These include
 * actual rotation, representing the object in the xy-plane, and getting and setting various relevant rotation/shape parameters.
 */
public interface Rotatable {
	public void rotate(); // rotates the Rotatable object a certain interval in a given direction
	public ArrayList<CartesianPoint> nextState(); // rotates the Rotatable object and returns the current state of the object in the form of its vertices
	public Direction getCurrDirection(); // getter for Direction of rotation, either clockwise or counterclockwise
	public void setCurrDirection(Direction d); // setter for Direction of rotation, either clockwise or counterclockwise
	public double getInterval(); // getter for interval of rotation (how many radians will the object rotate each tick)
	public void setInterval(double interval); // setter for interval of rotation (how many radians will the object rotate each tick)
	public ArrayList<CartesianPoint> currentState(); // returns the state of the Rotatable object in the form of an ArrayList of its vertices
	public void setRadius(double radius); // setter for radius of the Rotatable's bounding circle that it rotates about
	public double getRadius(); // getter for radius of the Rotatable's bounding circle that it rotates about
	public void setTheta(double theta); // setter for current angle theta of the first vertex of the Rotatable object
	public double getTheta(); // getter for current angle theta of the first vertex of the Rotatable object
}
