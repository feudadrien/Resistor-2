import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class MainFrame extends JFrame {
	private final String TITLE_STRING = "Resistor Calc";
	private final String COPY_LEFT_STRING = "Made by Alex Baranowski, all right copyleft. More Info\nhttps://github.com/AlexBaranowski/Resistor";
	private final JButton exitJButton = new JButton();
	private final JButton calculateJButton = new JButton();
	private final JButton infoJButton = new JButton();
	private ColorChooser band1, band2, band3, band4, band5, band6;
	private ResistorDrawer drawer = new ResistorDrawer();
	private JTextPane text = new JTextPane();

	private void initDrawer(JPanel jpane) {
		jpane.add(drawer);
	}

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
				Resistor res = new Resistor();
				String b1 = (String) band1.getList().getSelectedItem();
				String b2 = (String) band2.getList().getSelectedItem();
				String b3 = (String) band3.getList().getSelectedItem();
				String b4 = (String) band4.getList().getSelectedItem();
				String b5 = (String) band5.getList().getSelectedItem();
				String b6 = (String) band6.getList().getSelectedItem();

				res.setResistor(new String[] { b1, b2, b3, b4, b5, b6 });

				setTextField(res.getInformation());
			}
		});
		calculateJButton.setText("CALCULATE");
		
		
		infoJButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setTextField(COPY_LEFT_STRING);
			}
		});
		infoJButton.setText("Program info");
	}

	private void setTextField(String textFieldOutput) {
		text.setText(textFieldOutput);
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

	/**
	 * @param bandPane
	 *            Method set listners on JLists (bands) then adds to bandPane
	 */
	private void initBands(JPanel bandPane) {
		band1.getList().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bandChange();

			}
		});
		band2.getList().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bandChange();
			}
		});
		band3.getList().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Its working
				bandChange();

			}
		});
		band4.getList().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bandChange();
			}
		});
		band5.getList().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bandChange();
			}
		});
		band6.getList().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
		JPanel pane = new JPanel();
		text.setPreferredSize(new Dimension(400, 100));
		initDrawer(pane);
		initButtons();
		initBands(pane);

		pane.add(calculateJButton);
		pane.add(infoJButton);
		pane.add(exitJButton);
		pane.add(text);
		add(pane);
	}

	MainFrame() {
		super();
		setSize(500, 500);
		setTitle(TITLE_STRING);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		band1 = new ColorChooser(ColorChooser.MODE_BASE);
		band2 = new ColorChooser(ColorChooser.MODE_BASE);
		band3 = new ColorChooser(ColorChooser.MODE_BASEANDNONE);
		band4 = new ColorChooser(ColorChooser.MODE_MULTIPLIER);
		band5 = new ColorChooser(ColorChooser.MODE_TOLERANCE);
		band6 = new ColorChooser(ColorChooser.MODE_COEFFICIENT);
	}

	/**
	 * Auto generated serial VersionUID, error etc etc ;)
	 */
	private static final long serialVersionUID = -1177953479545908261L;

	public static void main(String[] args) {

		// Makes frame :)
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
