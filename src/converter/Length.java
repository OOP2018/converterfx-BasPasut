package converter;

/**
 * The class that contain the units and value of the Length that use in converter.
 * @author Pasut Kittiprapas
 *
 */
public enum Length implements Units{

	METER("Meter",1.00000),
	CENTIMETER("Centimeter",0.0100),
	KILOMETER("Kilometer",1000.0),
	MILE("Mile",1609.344),
	FOOT("Foot",0.30480),
	WA("Wa",2.00000),
	AU("Astronomical Unit",149597870700.0);
	
	private final double value;
	private final String name;
	
	/**
	 * Initialize the name and value of Length.
	 * @param name
	 * @param value
	 */
	private Length(String name,double value){
		this.value = value;
		this.name = name;
	}
	
	/**
	 * Get the value of the unit in length.
	 */
	public double getValue(){
		return this.value;
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
	 * Get the unit name of the length.
	 */
	@Override
	public String toString(){
		return this.name;
	}

}
