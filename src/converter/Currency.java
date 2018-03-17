package converter;

public enum Currency implements Units{
	
	BAHT("Baht",1.00000),
	DOLLAR("Dollar",31.21),
	YEN("Yen", 0.29),
	YUAN("Yuan",4.93),
	EURO("Euro",38.41);
	
	
	private final double value;
	private final String name;
	
	private Currency(String name,double value){
		this.value = value;
		this.name = name;
	}

	/**
	 * Get the value of the unit in Currency.
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
	 * Get the unit name of the Currency.
	 */
	@Override
	public String toString(){
		return this.name;
	}

}
