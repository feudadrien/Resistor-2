import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private final String TITLE_STRING = "Resistor Calc";
	private final String COPY_LEFT_STRING = "Made by Alex Baranowski, all right copyleft";
	private final JButton exitJButton = new JButton();
	private final JButton calculateJButton = new JButton();
	private final JButton infoJButton = new JButton();
	//private final JLabel COPYLEFT_STRING = new JLabel();

	private void initUI() {
		exitJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitJButton.setText("EXIT");
		calculateJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(new JPanel(), "NOT IMPLEMENT YET");
				
			}
		});
		calculateJButton.setText("CALCULATE");
		infoJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(new JPanel(), COPY_LEFT_STRING);
			}
		});
		infoJButton.setText("Program info");
		JPanel pane = new JPanel(); 
		pane.add(calculateJButton);
		pane.add(infoJButton);
		pane.add(exitJButton);
		add (pane);
	}

	MainFrame() {
		super();
		setSize(500, 500);
		setTitle(TITLE_STRING);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 * Auto generated serial VersionUID, error etc etc ;)
	 */
	private static final long serialVersionUID = -1177953479545908261L;

	public static void main(String[] args) {

		
		// Make 
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				MainFrame a = new MainFrame();
				a.initUI();
				a.setVisible(true);

			}

		});

		
	}

}
