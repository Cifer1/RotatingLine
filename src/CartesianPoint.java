
public class CartesianPoint {
	private double x;
	private double y;
	
	public CartesianPoint(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public PolarPoint toPolar(){
		return new PolarPoint(new double[]{x,y});
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
