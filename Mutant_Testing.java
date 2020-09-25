import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Mutant_Testing {
	VehicleType vt;
	RentalRecord r;
	

	@Test
	void test1() { //car, with 4 seats, getCarSeats/getSeats, getLastMaintenance,
				   //isUnderMaintenance,canBeRentedForMinimumDays
		DateTime dt = new DateTime();
		vt = new VehicleType(4,dt);
		vt.setCarSeats(4);
		vt.setLastMaintenance(dt);
		
		assertEquals(4,vt.getCarSeats());
		assertEquals(4,vt.getSeats("car"));
		assertEquals(vt.getLastMaintenance(),dt);
		assertFalse(vt.IsUnderMaintenance(dt,"car",15)); 	
		
		assertEquals(vt.canBeRentedForMinimumDays("car"),3);

	}
	
	@Test
	void test2() { //van, getSeats, indexOf, isUnderMaintenance, canBeRentedForMinimumDays
		DateTime dt = new DateTime();
		DateTime maintenance=new DateTime();
		vt = new VehicleType(15,dt);
		
		assertEquals(15,vt.getSeats("van"));
		
		assertEquals(-1,vt.indexOf("Caturday"));
		assertEquals(vt.indexOf("Monday"),1);
		assertEquals(vt.indexOf("Sunday"),0);
		
		maintenance.setDate(2020,5,22);
		assertFalse(vt.IsUnderMaintenance(maintenance,"van",12)); 
		assertTrue(vt.IsUnderMaintenance(maintenance,"van",14)); 
		
		assertEquals(vt.canBeRentedForMinimumDays("van"),1);
	}
	
	@Test
	void test3() { //RentalRecord, every method
		DateTime dt = new DateTime();
		DateTime rt=new DateTime();
		rt.setDate(22,10,2020);
		DateTime at=new DateTime();
		at.setDate(10, 10, 2020);
		
		r = new RentalRecord("111",dt,rt);
		
		assertNotEquals("",r.getDetails());
		assertNotEquals("",r.toString());
		assertNotEquals(null,r.getEstimatedReturnDate());
		assertNotEquals(null,r.getRentDate());
		
		r.setData(at, 12.5, 30.3);
		assertNotEquals("",r.getDetails());
		assertNotEquals("",r.toString());
		
	}
	

	
	
	

}
