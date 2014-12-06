import javax.swing.JList;



public class ColorChooser {
	public final static int MODE_ALL = 0;
	public final static int MODE_TOLERANCE = 1;
	public final static int MODE_MULTIPLIER = 2;
	public final static int MODE_COEFFICIENT = 3;
	private String[] myColors = null;
	JList<String> colorList  = new JList<String>();
	ColorChooser(int MODE) {

		if (MODE == MODE_ALL) {
			myColors = new String[Color.RESISTOR_BAND_COLORS.length];
			int index = 0;

			for (String i : Color.RESISTOR_BAND_COLORS) {
				myColors[index] = new String(i);// Deep copy ?? TODO CHECK
				index++;
			}
		}
		if (MODE == MODE_TOLERANCE) { // ADDS only Colors used in tolerance band
			myColors=Color.toleranceColors();
		}
		if (MODE == MODE_MULTIPLIER) {
			myColors=Color.multiplierColors();
		}
		if (MODE == MODE_COEFFICIENT) {
			myColors=Color.coefficientColors();
		}
		colorList = new JList<String> (myColors);
	}
}
