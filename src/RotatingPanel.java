import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;


public class RotatingPanel extends JPanel {
	private Rotatable shape;
	
	public RotatingPanel(){
		shape = new Line(Direction.CLOCKWISE, .01, Math.sqrt(getHeight()*getHeight()+getWidth()*getWidth()));
		double theta = shape.getTheta();
	}
	public void changeShape(int sides){
		
		if(sides>=3){
			double radius = Math.min(getHeight()/2.0, getWidth()/2.0);	
			shape = new Polygon(shape.getCurrDirection(), sides, .01, radius, shape.getTheta());
		}
		else{
			shape = new Line(shape.getCurrDirection(), .01, Math.sqrt(getHeight()*getHeight()+getWidth()*getWidth()), shape.getTheta());
		}
		repaint();
	}
	public void setDirection(Direction d){
		shape.setCurrDirection(d);
		repaint();
	}
	public void rotate(){
		shape.rotate();
		repaint();
	}
	public void setInterval(double interval){
		shape.setInterval(interval);
		repaint();
	}
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		if(shape instanceof Line){
			shape.setRadius(Math.sqrt(getHeight()*getHeight()+getWidth()*getWidth()));
		}
		else{
			shape.setRadius(Math.min(getHeight()/2.0, getWidth()/2.0));
		}
		ArrayList<CartesianPoint> vertices= shape.currentState();
		double heightScale = getHeight()/2.0;
		double widthScale = getWidth() / 2.0;
		for(int i = 0; i<vertices.size()-1; i++){
			g2.drawLine(
			(int)(Math.round(vertices.get(i).getX()+widthScale)), 
			(int)(Math.round(vertices.get(i).getY()+heightScale)), 
			(int)(Math.round(vertices.get(i+1).getX()+widthScale)),
			(int)(Math.round(vertices.get(i+1).getY()+heightScale)));
			 
		}
		g2.drawLine(
				(int)(Math.round(vertices.get(vertices.size()-1).getX()+widthScale)),
				(int)(Math.round(vertices.get(vertices.size()-1).getY()+heightScale)), 
				(int)(Math.round(vertices.get(0).getX()+widthScale)),
				(int)(Math.round(vertices.get(0).getY()+heightScale)));
		
		
	}

	


}
