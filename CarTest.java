import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CarTest {
    private CarService carService;

    public static void main(String[] args) throws Exception {
        CarTest carTest = new CarTest();
        carTest.initObject();
        System.out.println("testCarLateFee() -> " + (carTest.testCarLateFee() ? "pass" : "fail"));
    }

    @Before
    public void initObject() {
        Car car = new Car("C_15", 2007, "Fiat", "Punto", 0, new VehicleType(4));
        carService = mock(CarService.class);
        car.setCarService(carService);
    }

    @Test
    public boolean testCarLateFee() throws Exception {
        DateTime dt1 = new DateTime(12, 10, 2013);
        DateTime dt2 = new DateTime(19, 10, 2013);
        DateTime dt3 = new DateTime(29, 10, 2013);
        DateTime dt4 = new DateTime(12, 11, 2013);
        when(carService.getLateFee(dt1, dt2)).thenReturn(25.50);
        when(carService.getLateFee(dt1, dt3)).thenReturn(50.00);
        when(carService.getLateFee(dt1, dt4)).thenReturn(100.00);
        return carService.getLateFee(dt1, dt2) == 25.50;
    }
}