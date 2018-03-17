package converter;

/**
 * Interface of all the Unit that use in UnitConverter.
 * @author Pasut Kittiprapas
 *
 */
public interface Units {
	
	/**
	 * Convert one unit with another unit depend on the user input.
	 */
	public String convert(Units other1,Units other2,double input);
	
	/**
	 * Get the value of unit.
	 * @return the value of the unit.
	 */
	public double getValue();
	
	/**
	 * Get the name of the unit.
	 * @return name of the unit.
	 */
	public String toString();
	
}
