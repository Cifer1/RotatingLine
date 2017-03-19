/*
 * CartesianPoint is a class that represents a point on the xy-plane. Private data consists of the x component and y component of the ordered
 * pair making up the point. The ctors include one that takes in a given double array in format [x,y] and one that takes in polar coordinates 
 * and calculates the cartesian equivalent. Methods include forming a human-readable representation of the point, and getters and setters
 * for the x/y components of the point.
 */
public class CartesianPoint {
	private double x;
	private double y;
	
	public CartesianPoint(double[] point){
		/*
		 * This ctor takes in a double array representing a point on the xy-plane and sets the x and y components of the new object
		 * to the value of the first and second indices of the input array, respectively.
		 */
		this.x = point[0];
		this.y = point[1];
	}
	public CartesianPoint(double r, double theta){
		/*
		 * This ctor takes in a radius and theta representing a polar point, and calculates the Cartesian equivalent using 
		 * the formulas x = r * cos(theta) and y = r * sin(theta). 
		 */
		this.x = r * Math.cos(theta);
		this.y = r * Math.sin(theta);
	}
	public String toString(){
		// represents the point in a String in the format (x,y)
		return "(" + x + "," + y + ")";
	}
	public double getX() {
		// getter for x component of point, returns double x
		return x;
	}

	public void setX(double x) {
		// setter for x component of point, takes in double x
		this.x = x;
	}

	public double getY() {
		// getter for y component of point, returns double y

		return y;
	}

	public void setY(double y) {
		// setter for y component of point, takes in double y

		this.y = y;
	}
}
