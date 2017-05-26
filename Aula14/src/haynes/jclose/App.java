package haynes.jclose;

import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class App extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -497084751931260796L;

	public App() {
		super("Window Aplication");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setSize(400, 300);
		setLayout(new FlowLayout());
		addWindowListener(new AppListener());
	}

	public static void main(String[] args) {
		App app = new App();
		app.setVisible(true);
	}
	
	void windowClosing(WindowEvent e){
		if(JOptionPane.showConfirmDialog(App.this,
				"Deseja sair?",
				"Questão",
				JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION){
			App.this.dispose();
		}
	}

	private class AppListener implements WindowListener {

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
			App.this.windowClosing(e);
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
