import org.junit.*;

import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.*;

public class ThriftyRentSystemTest {
    private ThriftyRentSystem thriftyRentSystem;

    public ThriftyRentSystemTest() {
        thriftyRentSystem = new ThriftyRentSystem();
    }

    @Before
    public void initObject() {
        thriftyRentSystem = new ThriftyRentSystem();
    }

    @Test
    public void test1() throws FileNotFoundException {
        File f = new File("test1.txt");
        String output = "There are no cars, please add cars.";
        assertEquals(output, thriftyRentSystem.returnCar(new Scanner(f)));
    }

    @Test
    public void test2() throws FileNotFoundException {
        File f1 = new File("car.txt");
        thriftyRentSystem.add(new Scanner(f1));
        File f2 = new File("return-car.txt");
        String expected = "There are no vans, please add vans.";
        assertEquals(expected, thriftyRentSystem.returnCar(new Scanner(f2)));
    }

    @Test
    public void test3() throws FileNotFoundException {
        File f1 = new File("car.txt");
        thriftyRentSystem.add(new Scanner(f1));
        File f2 = new File("van.txt");
        thriftyRentSystem.add(new Scanner(f2));
        File f3 = new File("rent-car.txt");
        thriftyRentSystem.rent(new Scanner(f3));
        File f4 = new File("return-car.txt");
        String expected =  "Record ID:             " + "C_15_12_12052017"
                + "\nRent Date:             " + "12/05/2017"
                + "\nEstimated Return Date: " + "17/05/2017"
                + "\nActual Return Date:    " + "17/05/2017"
                + "\nRental Fee:            " + "390.00" +
                "\nLate Fee:              " + "0.00";
        assertEquals(expected, thriftyRentSystem.returnCar(new Scanner(f4)));
    }

    @Test
    public void test4() throws FileNotFoundException {
        File f1 = new File("car.txt");
        thriftyRentSystem.add(new Scanner(f1));
        File f2 = new File("van.txt");
        thriftyRentSystem.add(new Scanner(f2));
        File f3 = new File("rent-van.txt");
        thriftyRentSystem.rent(new Scanner(f3));
        File f4 = new File("return-van.txt");
        String expected =  "Record ID:             " + "V_16_12_12052017"
                + "\nRent Date:             " + "12/05/2017"
                + "\nEstimated Return Date: " + "13/05/2017"
                + "\nActual Return Date:    " + "13/05/2017"
                + "\nRental Fee:            " + "235.00" +
                "\nLate Fee:              " + "0.00";
        assertEquals(expected, thriftyRentSystem.returnCar(new Scanner(f4)));
    }
}