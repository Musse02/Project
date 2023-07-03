package uk.ac.aston.oop.calendar;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class DayTest.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DayTest {

	@Test public void appointmentStartOfDay() {
		Day day = new Day(1);
		Appointment app = new Appointment("meeting", 1);
		boolean success = day.makeAppointment(Day.START_OF_DAY, app);
		Appointment fetched = day.getAppointment(Day.START_OF_DAY);
		assertTrue(success, "Making an appointment at the start of the new day should work");
		assertSame(app,fetched,"It should be possible to fetch the appointment we just made");
		
	}
	
	@Test public void appointmentBeforeStartDay() {
		Day day = new Day(1);
		Appointment app = new Appointment("meeting", 1);
		boolean success = day.makeAppointment(Day.START_OF_DAY - 1,app);
		Appointment fetched = day .getAppointment(Day.START_OF_DAY -1);
		assertFalse(success);
		assertNull(fetched);
	}
	
	
	@Test public void twoAppsOnSameTime() {
		Day day = new Day(1);
		Appointment appA = new Appointment("meeting", 1);
		Appointment appB = new Appointment("meeting", 1);
		boolean successA = day.makeAppointment(Day.START_OF_DAY, appA);
		boolean successB = day.makeAppointment(Day.START_OF_DAY, appB);
		Appointment fetchedA = day.getAppointment(Day.START_OF_DAY);
		Appointment fetchedB = day.getAppointment(Day.START_OF_DAY);
		assertTrue(successA);
		assertFalse(successB);
		assertSame(appA,fetchedA);
		assertSame(appA,fetchedB);
		
		
	}

}
