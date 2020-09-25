import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VanTest {
    private Van van;

    public VanTest() {

    }

    @Test
    public void test1() throws Exception {
        van = new Van("D_15", 2007, "Citroen", "Relay", 1, new VehicleType(15));
        assertTrue(van.returnVehicle(new DateTime(13, 12, 2009)));
    }
}