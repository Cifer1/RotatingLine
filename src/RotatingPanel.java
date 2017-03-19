/*
 * Rotating panel is the class where the drawing of the shape occurs. Private data is a Rotatable shape. The only constructor takes in no parameters. 
 * There is a changeShape method, a rotate method, setDirection and setInterval methods, and a paintComponent method. 
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;


public class RotatingPanel extends JPanel {
	private Rotatable shape;
	
	// this constructor takes in no parameters, and creates a line with clockwise direction, a radius, and interval. Also gets theta from the shape
	public RotatingPanel(){
		shape = new Line(Direction.CLOCKWISE, .01, Math.sqrt(getHeight()*getHeight()+getWidth()*getWidth()));
		double theta = shape.getTheta();
	}
	// this method has a parameter for sides. If the # of sides is >=3 it gets a new radius and makes a new shape with the given number of sides
	// otherwise, it creates a line with a radius, theta, and interval already given
	public void changeShape(int sides){
		
		if(sides>=3){
			double radius = Math.min(getHeight()/2.0, getWidth()/2.0);	
			shape = new Polygon(shape.getCurrDirection(), sides, 0.01, radius, shape.getTheta());
		}
		else{
			shape = new Line(shape.getCurrDirection(),0.01, Math.sqrt(getHeight()*getHeight()+getWidth()*getWidth()), shape.getTheta());
		}
		repaint();
	}
	// sets the current direction based on the parameter and repaints
	public void setDirection(Direction d){
		shape.setCurrDirection(d);
		repaint();
	}
	//rotates the object and then repaints
	public void rotate(){
		shape.rotate();
		repaint();
	}
	//sets the interval based on the parameter and repaints
	public void setInterval(double interval){
		shape.setInterval(interval);
		repaint();
	}
	
	// Method will paint the lines from each vertex to the next based on the arraylist of points received received
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		// if the shape is a line, sets the radius to the correct radius based on width/height
		if(shape instanceof Line){
			shape.setRadius(Math.sqrt(getHeight()*getHeight()+getWidth()*getWidth()));
		}
		else{
			// if not, sets the radius using the height/width
			shape.setRadius(Math.min(getHeight()/2.0, getWidth()/2.0));
		}
		// gets the array list of cartesian points from the shape
		ArrayList<CartesianPoint> vertices= shape.currentState();
		double heightScale = getHeight()/2.0;
		double widthScale = getWidth() / 2.0;
		for(int i = 0; i<vertices.size()-1; i++){
			// draws the line from each vertex to the next until to the second to last one
			// uses the drawline function which draws a line from one point to another. 
			g2.drawLine(
			(int)(Math.round(vertices.get(i).getX()+widthScale)), 
			(int)(Math.round(vertices.get(i).getY()+heightScale)), 
			(int)(Math.round(vertices.get(i+1).getX()+widthScale)),
			(int)(Math.round(vertices.get(i+1).getY()+heightScale)));
			 
		}
		// draws a line from the "last vertex" to the "first vertex"
		g2.drawLine(
				(int)(Math.round(vertices.get(vertices.size()-1).getX()+widthScale)),
				(int)(Math.round(vertices.get(vertices.size()-1).getY()+heightScale)), 
				(int)(Math.round(vertices.get(0).getX()+widthScale)),
				(int)(Math.round(vertices.get(0).getY()+heightScale)));
		
		
	}

	


}
