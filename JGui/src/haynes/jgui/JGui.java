package haynes.jgui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class JGui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JGui() {
		super("Telinha do Haynes");
		setSize(400, 300);
		setLayout(new FlowLayout());
		configure();
	}

	public static void main(String[] args) {
		JGui app = new JGui();
		app.setVisible(true);
	}

	private void configure() {
		JTextField txName = new JTextField();
		txName.setPreferredSize(new Dimension(200, 25));

		JButton btName = new JButton("Enviar Nome");
		btName.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(JGui.this, "Bem vindo: " + txName.getText());
			}
		});
		;

		add(txName);
		add(btName);
	}
}
