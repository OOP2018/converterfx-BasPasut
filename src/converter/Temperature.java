package converter;

/**
 * The class that contain the units and value of the Temperature that use in
 * converter.
 * 
 * @author Pasut Kittiprapas
 *
 */
public enum Temperature implements Units {

	CELCIUS("Celcius", 0),
	FAHRENHEIT("Fahrenheit", 32.00),
	KELVIN("Kelvin", 273.15);

	private final String name;
	private final double value;

	private Temperature(String name, double value) {
		this.name = name;
		this.value = value;
	}

	public String CelciusToOther(Units u,double c) {
		if(u.toString().equalsIgnoreCase("Fahrenheit")){
			return String.format("%.5g", (c*9/5)+32);
		}
		else if(u.toString().equalsIgnoreCase("Kelvin")){
			return String.format("%.5g", c+273);
		}
		else{
			return String.format("%.5g", c);
		}
	}
	
	public String FahrenheitToOther(Units u,double f) {
		if(u.toString().equalsIgnoreCase("Celcius")){
			return String.format("%.5g", (f-32)*5/9);
		}
		else if(u.toString().equalsIgnoreCase("Kelvin")){
			return String.format("%.5g", ((f-32)*5/9)+273);
		}
		else{
			return String.format("%.5g", f);
		}
	}
	
	public String KelvinToOther(Units u,double k) {
		if(u.toString().equalsIgnoreCase("Celcius")){
			return String.format("%.5g", k-273);
		}
		else if(u.toString().equalsIgnoreCase("Fahrenheit")){
			return String.format("%.5g", (9*(k-273)/5)+32);
		}
		else{
			return String.format("%.5g", k);
		}
	}

	/**
	 * Get the value of the unit in temperature.
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Convert one unit with another unit depend on the user input. Both unit
	 * have to have the same unit type.
	 */
	@Override
	public String convert(Units other1, Units other2, double input) {
		if(other1.toString().equalsIgnoreCase("Celcius")){
			return CelciusToOther(other2, input);
		}
		else if (other1.toString().equalsIgnoreCase("Fahrenheit")){
			return FahrenheitToOther(other2, input);
		}
		else if (other1.toString().equalsIgnoreCase("Kelvin")){
			return KelvinToOther(other2, input);
		}
		else{
			return "0";
		}

	}

	/**
	 * Get the unit name of the Temperature.
	 */
	@Override
	public String toString() {
		return this.name;
	}
}
