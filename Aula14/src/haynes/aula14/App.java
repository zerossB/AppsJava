package haynes.aula14;

import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class App extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -497084751931260796L;

	public App() {
		super("Window Aplication");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
		setLayout(new FlowLayout());
		addWindowListener(new AppListener());
	}

	public static void main(String[] args) {
		App app = new App();
		app.setVisible(true);
	}
	
	private class AppListener implements WindowListener{

		@Override
		public void windowActivated(WindowEvent e) {
			System.out.println("windowActivated");
		}

		@Override
		public void windowClosed(WindowEvent e) {
			System.out.println("windowClosed");
		}

		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("windowClosing");
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			System.out.println("windowDeactivated");
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			System.out.println("windowDeiconified");
		}

		@Override
		public void windowIconified(WindowEvent e) {
			System.out.println("windowIconified");
		}

		@Override
		public void windowOpened(WindowEvent e) {
			System.out.println("windowOpened");
		}
		
	}

}
