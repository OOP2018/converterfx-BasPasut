package converter;

/**
 * Print the unit and value in enum Length
 * @author Pasut Kittiprapas
 *
 */
public class EnumTest {
	
	public static void main(String[] args) {
		Length[] lengths = Length.values();
		for(Length x : lengths)
			System.out.println(x.toString() + " = " + x.getValue());
	}
	
}
