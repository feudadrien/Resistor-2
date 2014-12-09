import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private final String TITLE_STRING = "Resistor Calc";
	private final String COPY_LEFT_STRING = "Made by Alex Baranowski, all right copyleft";
	private final JButton exitJButton = new JButton();
	private final JButton calculateJButton = new JButton();
	private final JButton infoJButton = new JButton();
	private ColorChooser band1, band2, band3, band4, band5, band6;
	private ResistorDrawer drawer = new ResistorDrawer();

	private void initDrawer(JPanel jpane) {
		jpane.add(drawer);
	}

	// private final JLabel COPYLEFT_STRING = new JLabel();
	private void initButtons() {
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
	}

	private void bandChange() {
		String b1 = (String) band1.getList().getSelectedItem();
		String b2 = (String) band2.getList().getSelectedItem();
		String b3 = (String) band3.getList().getSelectedItem();
		String b4 = (String) band4.getList().getSelectedItem();
		String b5 = (String) band5.getList().getSelectedItem();
		String b6 = (String) band6.getList().getSelectedItem();
		
		drawer.setResistor(Color.colorToInt(b1), Color.colorToInt(b2), Color.colorToInt(b3), Color.colorToInt(b4),
				Color.colorToInt(b5), Color.colorToInt(b6));
		drawer.paint(getGraphics());
		drawer.repaint();
	}

	private void initBands(JPanel bandPane) {
		// TODO Make Listeners
		band1.getList().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bandChange();
				
			}
		});
		band2.getList().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Its working
				bandChange();
				
			}
		});
		band3.getList().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Its working
				bandChange();
				
			}
		});
		band4.getList().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Its working
				bandChange();
				
			}
		});
		band5.getList().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Its working
				bandChange();
				
			}
		});
		band6.getList().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Its working
				bandChange();
				
			}
		});
		bandPane.add(band1.getList());
		bandPane.add(band2.getList());
		bandPane.add(band3.getList());
		bandPane.add(band4.getList());
		bandPane.add(band5.getList());
		bandPane.add(band6.getList());
	}

	private void initUI() {
		setResizable(false);
		JPanel bandPanel = new JPanel();
		JPanel pane = new JPanel();

		initDrawer(pane);
		initButtons();
		initBands(pane);

		pane.add(calculateJButton);
		pane.add(infoJButton);
		pane.add(exitJButton);
		add(pane);
		// add(bandPanel);
	}

	MainFrame() {
		super();
		setSize(500, 500);
		setTitle(TITLE_STRING);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		band1 = new ColorChooser(ColorChooser.MODE_ALL);
		band2 = new ColorChooser(ColorChooser.MODE_ALL);
		band3 = new ColorChooser(ColorChooser.MODE_ALL);
		band4 = new ColorChooser(ColorChooser.MODE_MULTIPLIER);
		band5 = new ColorChooser(ColorChooser.MODE_TOLERANCE);
		band6 = new ColorChooser(ColorChooser.MODE_COEFFICIENT);
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
