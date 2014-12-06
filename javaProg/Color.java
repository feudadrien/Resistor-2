/**
 * 
 * @author Alex
 * This Class is responsible all operations with colors
 * Maybe it would be better to do colors with strings in another class
 * And then make Color chooser
 */
public class Color {
	public final static String[] RESISTOR_BAND_COLORS = { "black", "brown",
			"red", "orange", "yellow", "green", "blue", "violet", "grey",
			"white", "gold", "silver" };




	
	public static String []allColors(){
		String []myColors = new String[Color.RESISTOR_BAND_COLORS.length+1];
		int index = 0;

		for (String i : Color.RESISTOR_BAND_COLORS) {
			myColors[index] = new String(i);// Deep copy ?? TODO CHECK
			index++;
		}
		myColors[myColors.length-1] = "none";
		return myColors;
	}
	public static String[] multiplierColors(){
		String []myColors = new String[10];
		int index = 0;
		for (String i : Color.RESISTOR_BAND_COLORS) {
			int colorInt = Color.colorToInt(i);
			if (colorInt < 8 || colorInt > 9) {
				myColors[index] = new String(i);
				index++;
			}
		}
		return myColors;
	}
	
	public static String[] toleranceColors(){
		String []myColors = new String[9];
		int index = 0;
		for (String i : Color.RESISTOR_BAND_COLORS) {
			int colorInt = Color.colorToInt(i);
			if (colorInt == 1 || colorInt == 2 || colorInt == 5
					|| colorInt == 6 || colorInt == 7 || colorInt == 8
					|| colorInt == 10 || colorInt == 11) {
				myColors[index] = new String(i);
				index++;
			}
		}
		myColors[myColors.length-1] = "none";//Tolerance is no required
		return myColors;
	}
	public static String[] coefficientColors(){
		String []myColors = new String[7];
		int index = 0;
		for (String i : Color.RESISTOR_BAND_COLORS) {
			int colorInt = Color.colorToInt(i);
			if ( (colorInt > 0 && colorInt < 5) || colorInt == 6 || colorInt == 7 ) {
				myColors[index] = new String(i);
				index++;
			}
		}
		myColors[myColors.length-1] = "none";//Coefficient is no required
		return myColors;
	}
	
	
	public static int colorToInt(String color) {

		for (int i = 0; i < RESISTOR_BAND_COLORS.length; i++) {
			if (color.equals(RESISTOR_BAND_COLORS[i]))
				return i;

		}
		return -1;
	}

	public static String colorToMulti(int arg) {
		if (arg == 0)
			return "1 OHM"; // black
		else if (arg == 1)
			return "10 OHM"; // brown
		else if (arg == 2)
			return "100 OHM"; // red
		else if (arg == 3)
			return "1K OHM"; // orange
		else if (arg == 4)
			return "10K OHM"; // yellow
		else if (arg == 5)
			return "100K OHM"; // green
		else if (arg == 6)
			return "1M OHM"; // blue
		else if (arg == 7)
			return "10M OHM"; // violet
		else if (arg == 10)
			return "0.1 OHM"; // gold
		else if (arg == 11)
			return "0.01 OHM"; // silver
		else
			return "ERR no such multiplier"; // FU -eq FuckYou there is no such
												// color ;v
	}

	public static String colorToTolerance(int arg) {
		if (arg == 0)
			return "(+/-)1 %"; // black
		else if (arg == 1)
			return "(+/-)1 %"; // brown
		else if (arg == 2)
			return "(+/-)1 %"; // red
		else if (arg == 5)
			return "(+/-)0.5 %"; // green
		else if (arg == 6)
			return "(+/-)0.25 %"; // blue
		else if (arg == 7)
			return "(+/-)0.10 %"; // violet
		else if (arg == 8)
			return "(+/-)0.05 %"; // grey
		else if (arg == 10)
			return "(+/-)5 %"; // gold
		else if (arg == 11)
			return "(+/-)10 %"; // silver
		else		
			return "ERR no such tolerance"; // FU -eq FuckYou there is no such
											// color ;v
	}

	public static String colorToCoeffcient(int arg) {

		if (arg == 1)
			return "100 ppm"; // brown
		else if (arg == 2)
			return "50 ppm"; // red
		else if (arg == 3)
			return "15 ppm"; // orange
		else if (arg == 4)
			return "25 ppm"; // yellow
		else if (arg == 6)
			return "10 ppm"; // blue
		else if (arg == 7)
			return "5 ppm"; // violet
		else
			return "ERR no such Coefficient"; // FU -eq FuckYou there is no such
												// color :D
	}


}
