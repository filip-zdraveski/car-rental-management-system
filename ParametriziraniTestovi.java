import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


class ParametriziraniTestovi {

	private VehicleType vt;
	
	@BeforeEach
	public void setup() {
	vt=new VehicleType();
	}
	
	public static Collection<Object[]> index() {
	return Arrays.asList(new Object[][] {
	{ "Sunday", 0 },
	{ "Monday", 1 },
	{ "Tuesday", 2 },
	{ "Wednesday", 3 },
	{ "Thursday", 4 },
	{ "Friday", 5 },
	{ "Saturday", 6 },
	{ "Caturday", -1 }
	});
	}
	
	@ParameterizedTest
	@MethodSource("index")
	void testPowerOfTwo (String day, int expectedResult) {
			System.out.println("Parameterized Day is : "+ day);
			assertEquals(expectedResult,vt.indexOf(day));
			}
	
}

