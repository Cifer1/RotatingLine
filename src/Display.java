import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.Timer;





public class Display extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display frame = new Display();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Display() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel controlPanel = new JPanel();
		contentPane.add(controlPanel, BorderLayout.NORTH);
		
		JRadioButton clockwiseButton = new JRadioButton("Clockwise");
		clockwiseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		buttonGroup.add(clockwiseButton);
		controlPanel.add(clockwiseButton);
		
		JRadioButton counterclockwiseButton = new JRadioButton("Counterclockwise");
		counterclockwiseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup.add(counterclockwiseButton);
		controlPanel.add(counterclockwiseButton);
		
		JButton startStopButton = new JButton("Start");
		controlPanel.add(startStopButton);
		
		
		JPanel panel = new RotatingPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.SOUTH);
		
		JPanel sidesPanel = new JPanel();
		tabbedPane.addTab("Sides", null, sidesPanel, null);
		
		JLabel label = new JLabel("Sides");
		sidesPanel.add(label);
		
		JSlider sideSlider = new JSlider();
		sideSlider.setToolTipText("");
		sideSlider.setSnapToTicks(true);
		sideSlider.setPaintTicks(true);
		sideSlider.setPaintLabels(true);
		sideSlider.setMinimum(2);
		sideSlider.setMaximum(12);
		sidesPanel.add(sideSlider);
		
		JPanel speedPanel = new JPanel();
		tabbedPane.addTab("Speed", null, speedPanel, null);
		
		JSlider speedSlider = new JSlider();
		speedSlider.setValue(1);
		speedSlider.setMinimum(1);
		speedSlider.setMaximum(1000);
		speedPanel.add(speedSlider);
		
		JPanel colorPanel = new JPanel();
		tabbedPane.addTab("Color", null, colorPanel, null);
		
		JButton lineColorButton = new JButton("Set Line Color");
		colorPanel.add(lineColorButton);
		
		JButton backgroundButton = new JButton("Set Background Color");
		colorPanel.add(backgroundButton);
		
	}

}