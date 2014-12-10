
public class Resistor {

	private String information;
	private int base;
	private String multiplier;
	private String tolerance;
	private String coefficient;

	private void bandsToBase(String firstBand, String secondBand, String thirdBand) {
		int tmp = 0;
		if (!firstBand.equals("none")) {
			tmp += Color.colorToInt(firstBand);
		}
		if (!secondBand.equals("none")) {
			tmp *= 10;
			tmp += Color.colorToInt(secondBand);
		}
		if (!thirdBand.equals("none")) {
			tmp *= 10;
			tmp += Color.colorToInt(thirdBand);
		}
		base = tmp;
		return;
	}

	/**
	 * @param band
	 * set multiplier
	 */
	private void bandToMultiplier(String band) {
		multiplier = Color.colorToMulti(Color.colorToInt(band));
	}

	private void bandToTolerance(String band) {
		if (!band.equals("none"))
			tolerance = Color.colorToTolerance(Color.colorToInt(band));
		else
			tolerance = "";
	}
	
	private void bandToCoefficient(String band) {
		if (!band.equals("none"))
			coefficient = Color.colorToCoeffcient(Color.colorToInt(band));
		else
			coefficient ="";
	}

	private void makeInfo() {
		information = new String();
		information += "Your Resistor Data:\n";
		information += "Resistance = " + base + " * " + multiplier + "\n";
		if (!tolerance.equals(""))
			information += "Tolerance = " + tolerance + "\n";
		if (!coefficient.equals(""))
			information += "Coefficient = " + coefficient  ;
	}
	
	public String getInformation() {
		return information;
	}

	/**
	 * @return true if everything went fine :)
	 */

	public boolean setResistor(String[] arrayOfBands) {
		if (arrayOfBands.length != 6) {
			return false;
		}
		for (String i : arrayOfBands) {
			if (Color.isValidResistorColor(i) == false)
				return false;
		}

		bandsToBase(arrayOfBands[0], arrayOfBands[1], arrayOfBands[2]);
		bandToMultiplier(arrayOfBands[3]);
		bandToTolerance(arrayOfBands[4]);
		bandToCoefficient(arrayOfBands[5]);
		makeInfo();
		return true;
	}

	// Do nothing
	Resistor() {
		// OFC jvm do it without our help but it looks so fun ;)
		information = multiplier = tolerance = coefficient = null;
	}

}
