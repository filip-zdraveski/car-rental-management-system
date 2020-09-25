import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;


public class ISP_BCC_Testing {

	private DateTime dateTime;
	private int day;
	private int month;
	private int year;
	Calendar calendar;
	
	//Interface-based tests
	//A-day -> null, <=0, (0,28), 29, 30, 31, >31
	//B-month -> null, <=0, (1,3,5,7,8,10,12), (4,6,9,11), 2, >12
	//C-year -> null, <=0, (0,2010), (2012,2014,2018,2020), (2010,2011,2013,2015,2016,2017,2019),>2020
	
	//BCC - base case - A3, B3, C4 

	@Before
	public void make_Calendar() {
		dateTime=new DateTime() {};
		calendar= Calendar.getInstance();
		calendar.setLenient(false);
	}
	
	
	 @Test
	    public void ib_test1_base() throws Exception {    // A3,B3,C4
	    	day=28;
	    	month=3;
	    	year=2020;
	    	calendar.set(2020,3,28,0,0,0);
	    	calendar.setTimeInMillis(0);
//	    	System.out.println(calendar);
	        assertEquals(calendar, dateTime.setCalendar(day,month,year));
	    } 
	 
	 
    @Test
    public void ib_test1_1() throws Exception {    // A4,B3,C4
    	day=29;
    	month=3;
    	year=2012;
    	calendar.set(2012,3,29,0,0,0);
    	calendar.setTimeInMillis(0);
//    	System.out.println(calendar);
        assertEquals(calendar, dateTime.setCalendar(day,month,year));
    }
    
    @Test
    public void ib_test1_2() throws Exception {    // A3,B4,C4
    	day=11;
    	month=4;
    	year=2012;
    	calendar.set(11,4,2012,0,0);
    	calendar.setTimeInMillis(0);
        assertEquals(calendar, dateTime.setCalendar(day,month,year));
    }
    
    @Test
    public void ib_test1_3() throws Exception {    // A5,B3,C4
    	day=30;
    	month=5;
    	year=2012;
    	calendar.set(30,5,2012,0,0);
    	calendar.setTimeInMillis(0);
        assertEquals(calendar, dateTime.setCalendar(day,month,year));
    }
    
    @Test
    public void ib_test1_4() throws Exception {    // A3,B5,C4
    	day=11;
    	month=2;
    	year=2012;
    	calendar.set(11,2,2012,0,0);
    	calendar.setTimeInMillis(0);
        assertEquals(calendar, dateTime.setCalendar(day,month,year));
    }
    
    @Test
    public void ib_test1_5() throws Exception {    // A3,B3,C5
    	day=11;
    	month=3;
    	year=2012;
    	calendar.set(11,3,2012,0,0);
    	calendar.setTimeInMillis(0);
        assertEquals(calendar, dateTime.setCalendar(day,month,year));
    }
    
    @Test(expected = NullPointerException.class)
    public void ib_test1_6() throws Exception {   
        dateTime.setCalendar(2,2,(Integer) null);
    }
    
    @Test(expected = InvalidDateException.class)
    public void ib_test1_7() throws Exception {   
        dateTime.setCalendar(2,2,1750);
    }
    
    // ---------------------------------------------------------------------------------------------------------------//

    
	//Functionality-based tests
	//A-validnost -> T,F
	//B-tochnost -> T,F
	
	//BCC - base case - A1,B1 
   
    

    @Test
    public void fb_test1_base() throws Exception {    // A1,B1 validen e i tochen e
    	day=11;
    	month=3;
    	year=2012;
    	calendar.set(11,3,2012,0,0);
    	calendar.setTimeInMillis(0);
        assertEquals(calendar, dateTime.setCalendar(day,month,year));
    }
    
    @Test(expected = InvalidDateException.class)
    public void fb_test1_1() throws Exception {    // A1,B2 validen e no ne i tochen
    	day=31;
    	month=2;
    	year=2012;
    	calendar.set(31,2,2012,0,0);
    	calendar.setTimeInMillis(0);
    	calendar.setLenient(false);
        assertEquals(calendar, dateTime.setCalendar(day,month,year));
    }
    
    @Test(expected = InvalidDateException.class)
    public void fb_test1_2() throws Exception {    // A2,B2 ne e ni validen ni tochen
    	day=-1;
    	month=0;
    	year=30;
    	calendar.set(-1,0,30,0,0);
    	calendar.setTimeInMillis(0);
        assertEquals(calendar, dateTime.setCalendar(day,month,year));
    }
    
    
	
}
