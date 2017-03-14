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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
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

		setBounds(100,100,450,300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		JPanel mainPanel = new RotatingPanel();
		contentPane.add(mainPanel, BorderLayout.CENTER);
		
		Timer timer = new Timer(10, new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				((RotatingPanel)mainPanel).rotate();
			}

		});
		
		JPanel controlPanel = new JPanel();
		contentPane.add(controlPanel, BorderLayout.NORTH);
		
		JRadioButton clockwiseButton = new JRadioButton("Clockwise");
		clockwiseButton.setSelected(true);
		clockwiseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((RotatingPanel)mainPanel).setDirection(Direction.CLOCKWISE);
			}
		});
		buttonGroup.add(clockwiseButton);
		controlPanel.add(clockwiseButton);
		
		JRadioButton counterclockwiseButton = new JRadioButton("Counterclockwise");
		counterclockwiseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((RotatingPanel)mainPanel).setDirection(Direction.COUNTERCLOCKWISE);

			}
		});
		buttonGroup.add(counterclockwiseButton);
		controlPanel.add(counterclockwiseButton);
		
		JButton startStopButton = new JButton("Start");
		startStopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(startStopButton.getText()=="Start"){
					startStopButton.setText("Stop");
					timer.start();
				}
				else{
					startStopButton.setText("Start");
					timer.stop();
				}
			}
		});
		controlPanel.add(startStopButton);
		
		
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.SOUTH);
		
		JPanel sidesPanel = new JPanel();
		tabbedPane.addTab("Sides", null, sidesPanel, null);
		
		JLabel label = new JLabel("Sides");
		sidesPanel.add(label);
		
		JSlider sideSlider = new JSlider();		
		sideSlider.setSnapToTicks(true);
		sideSlider.setToolTipText("");
		sideSlider.setPaintTicks(true);
		sideSlider.setPaintLabels(true);
		sideSlider.setMinimum(2);
		sideSlider.setMaximum(12);
		sidesPanel.add(sideSlider);
		sideSlider.setValue(2);
	
	sideSlider.addChangeListener(new ChangeListener() {
		public void stateChanged(ChangeEvent arg0) {
			JSlider source = (JSlider)arg0.getSource();
			((RotatingPanel)mainPanel).changeShape(source.getValue());
		}
	});
		
		JPanel speedPanel = new JPanel();
		tabbedPane.addTab("Speed", null, speedPanel, null);
		
		JSlider speedSlider = new JSlider();
		speedSlider.setMinimum(1);
		speedSlider.setMaximum(100);
		speedSlider.setInverted(true);
		speedSlider.setValue(timer.getDelay());

		speedPanel.add(speedSlider);
		speedSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				JSlider source= (JSlider)arg0.getSource();
				timer.setDelay((int)(source.getValue()));
			}
		});
		
		
		
		JPanel colorPanel = new JPanel();
		tabbedPane.addTab("Color", null, colorPanel, null);
		
		JButton lineColorButton = new JButton("Set Line Color");
		lineColorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Color initialColor = Color.BLACK;
				Color color = JColorChooser.showDialog(mainPanel, "Choose", initialColor);
				mainPanel.setForeground(color);
			}
		});
		colorPanel.add(lineColorButton);
		
		
		JButton backgroundButton = new JButton("Set Background Color");
		colorPanel.add(backgroundButton);
		backgroundButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Color initialColor = Color.GRAY;
				Color color = JColorChooser.showDialog(mainPanel, "Choose", initialColor);
				mainPanel.setBackground(color);			
			}
		});

	}

}
