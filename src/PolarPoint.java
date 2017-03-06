public class PolarPoint {
	private double r;
	private double theta;
	public PolarPoint(double[] point){
		theta = Math.atan2(point[0], point[1]);
		r = point[0] / Math.cos(theta);
	}
	public PolarPoint(double r, double theta){
		this.r = r;
		this.theta = theta;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String toString(){
		return "(" + r + "," + theta + " radians)";
	}
	public CartesianPoint toCartesian(){
		double x = r * Math.cos(theta);
		double y = r * Math.sin(theta);
		return new CartesianPoint(x,y);
	}
	public double getR() {
		return r;
	}
	public void setR(double r) {
		this.r = r;
	}
	public double getTheta() {
		return theta;
	}
	public void setTheta(double theta) {
		this.theta = theta;
	}

}
