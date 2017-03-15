
public class CartesianPoint {
	private double x;
	private double y;
	
	public CartesianPoint(double[] point){
		this.x = point[0];
		this.y = point[1];
	}
	public CartesianPoint(double r, double theta){
		this.x = r * Math.cos(theta);
		this.y = r * Math.sin(theta);
	}
	public String toString(){
		return "(" + x + "," + y + ")";
	}
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
}
