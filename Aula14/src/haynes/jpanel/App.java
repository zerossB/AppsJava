package haynes.jpanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class App extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 330761061202792662L;

	public App() {
		super("Panel Aplication");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 450);
		setLayout(new FlowLayout());

		configure();
		
		pack();
	}

	private void configure() {
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JPanel panel6 = new JPanel();
		
		JPanel pGrid = new JPanel();
		
		panel1.setBorder(BorderFactory.createTitledBorder("Titulo"));
		panel2.setBorder(BorderFactory.createEtchedBorder());
		panel3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel4.setBorder(BorderFactory.createRaisedBevelBorder());
		panel5.setBorder(BorderFactory.createLoweredBevelBorder());
		panel6.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED));
		
		pGrid.setLayout(new GridLayout(2, 3, 5, 5));
		pGrid.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		panel1.setPreferredSize(new Dimension(100, 100));
		panel2.setPreferredSize(new Dimension(100, 100));
		panel3.setPreferredSize(new Dimension(100, 100));
		panel4.setPreferredSize(new Dimension(100, 100));
		panel5.setPreferredSize(new Dimension(100, 100));
		panel6.setPreferredSize(new Dimension(100, 100));
		
		pGrid.add(panel1);
		pGrid.add(panel2);
		pGrid.add(panel3);
		pGrid.add(panel4);
		pGrid.add(panel5);
		pGrid.add(panel6);
		
		add(pGrid);
	}

	public static void main(String[] args) {
		App app = new App();
		app.setVisible(true);
	}

}
