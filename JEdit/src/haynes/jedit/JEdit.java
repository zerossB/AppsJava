package haynes.jedit;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

public class JEdit extends JFrame implements ActionListener {

	private static final String NEW = "NEW";
	private static final String OPEN = "OPEN";
	private static final String SAVE = "SAVE";
	private static final String CLOSE = "CLOSE";

	private JPanel pBotoes;
	private JPanel pEditor;

	private JButton btNew;
	private JButton btOpen;
	private JButton btSave;
	private JButton btClose;

	private JScrollPane spEditor;
	private JTextArea txEditor;

	private JFileChooser fileChooser;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor da Classe
	 */
	public JEdit() {
		super("JEdit");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(400, 300));
		configure();
		pack();
	}

	/**
	 * Configuração básica dos componentes
	 */
	private void configure() {
		pBotoes = new JPanel();
		pEditor = new JPanel();

		btNew = new JButton("Novo");
		btOpen = new JButton("Abrir");
		btSave = new JButton("Salvar");
		btClose = new JButton("Fechar");

		txEditor = new JTextArea();
		spEditor = new JScrollPane(txEditor);

		new JCheckBox("Foi editado?");

		fileChooser = new JFileChooser();

		txEditor.setMargin(new Insets(5, 5, 5, 5));
		txEditor.setEditable(false);

		pBotoes.setLayout(new FlowLayout());
		pBotoes.setBorder(new EtchedBorder());

		pEditor.setLayout(new BorderLayout());

		btNew.setActionCommand(NEW);
		btNew.addActionListener(this);
		btOpen.setActionCommand(OPEN);
		btOpen.addActionListener(this);
		btSave.setActionCommand(SAVE);
		btSave.addActionListener(this);
		btClose.setActionCommand(CLOSE);
		btClose.addActionListener(this);

		pBotoes.add(btNew);
		pBotoes.add(btOpen);
		pBotoes.add(btSave);
		pBotoes.add(btClose);

		pEditor.add(spEditor);

		add(pBotoes, BorderLayout.NORTH);
		add(pEditor, BorderLayout.CENTER);
	}

	/**
	 * Listener de Ações dos Botões
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		switch (action) {
		case NEW:
			btNewAction();
			break;
		case OPEN:
			btOpenAction();
			break;
		case SAVE:
			btSaveAction();
			break;
		case CLOSE:
			btCloseAction();
			break;
		default:
			System.out.println("ERRO");
			break;
		}
	}

	/**
	 * Ação do btNew
	 */
	private void btNewAction() {
		txEditor.setEditable(true);
		txEditor.grabFocus();
	}

	/**
	 * Ação do btOpen
	 */
	private void btOpenAction() {
		fileChooser.setDialogTitle("Abrir Arquivo");
		fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		int opt = fileChooser.showDialog(this, "Abrir");

		if (opt == JFileChooser.APPROVE_OPTION) {
			try {
				StringBuilder dados = new StringBuilder();
				File file = fileChooser.getSelectedFile();
				List<String> linhas = Files.readAllLines(file.toPath());

				for (String linha : linhas) {
					dados.append(linha + "\n");
				}

				txEditor.setText(dados.toString());
				txEditor.setEditable(true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Ação do btSave
	 */
	private void btSaveAction() {
		fileChooser.setDialogTitle("Abrir Arquivo");
		fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		int opt = fileChooser.showDialog(this, "Salvar");

		if (opt == JFileChooser.APPROVE_OPTION) {
			try {
				StringBuilder dados = new StringBuilder(txEditor.getText());
				File file = fileChooser.getSelectedFile();

				List<String> linhas = new ArrayList<>();
				String[] splits = dados.toString().split("\\n");

				for (String string : splits) {
					linhas.add(string);
				}

				Files.write(file.toPath(), linhas, Charset.forName("UTF-8"));
				
				JOptionPane.showMessageDialog(this, file.getName()+" Salvo com Exito em "+file.getAbsolutePath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Ação do btClose
	 */
	private void btCloseAction() {
		txEditor.setText("");
		txEditor.setEditable(false);
	}

	/**
	 * Metodo main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		JEdit app = new JEdit();
		app.setVisible(true);
	}
}
