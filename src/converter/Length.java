package converter;

public enum Length {

	METER(1.00000),
	CENTIMETER(0.0100),
	KILOMETER(1000.0),
	MILE(1609.344),
	FOOT(0.30480),
	WA(2.00000),
	AU(149597870700.0);
	
	private final double value;
	
	private Length(double value){
		this.value = value;
	}
	
	public double getValue(){
		return this.value;
	}
	
	
	
	
	
}
