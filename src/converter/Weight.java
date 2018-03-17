package converter;

/**
 * The class that contain the units and value of the Weight that use in
 * converter.
 * 
 * @author Pasut Kittiprapas
 *
 */
public enum Weight implements Units {

	KILOGRAMS("Kilogram", 1.00), 
	POUND("Pound", 0.453592), 
	BAHT("Baht", 0.015);

	private final double value;
	private final String name;

	private Weight(String name, double value) {
		this.name = name;
		this.value = value;
	}

	/**
	 * Convert one unit with another unit depend on the user input. Both unit
	 * have to have the same unit type.
	 */
	@Override
	public String convert(Units other1,Units other2,double input) {
		return String.format("%.5g", input*(other1.getValue())/other2.getValue());

	}

	/**
	 * Get the value of the unit in Weight.
	 */
	@Override
	public double getValue() {
		return this.value;
	}

	/**
	 * Get the unit name of the weight.
	 */
	@Override
	public String toString() {
		return this.name;
	}

}
