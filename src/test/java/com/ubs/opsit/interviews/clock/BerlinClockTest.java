package com.ubs.opsit.interviews.clock;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static com.ubs.opsit.interviews.util.BerlinClockConstant.LINE_SEPERATOR;

public class BerlinClockTest {

	private  BerlinClock berlinClock ;
	@Before
	public void setUp() {
		this.berlinClock = new BerlinClock();
	}
	
	@Test
	public void testValidBerlinClockRepresentation(){
		final String aTime = "13:17:01";
		final String expectedString = String.join(LINE_SEPERATOR, "O","RROO","RRRO","YYROOOOOOOO","YYOO");
		final String actualResult = berlinClock.convertTime(aTime);
		assertEquals(expectedString, actualResult);
	}
	
	@Test
	public void testInvalidBerlinClockRepresentation(){
		final String aTime = "42:17:01";
		try{
			berlinClock.convertTime(aTime);
			fail("Expected an Illegal Argumnet Exception to be thrown");
		}catch(IllegalArgumentException iex){
			assertEquals(iex.getMessage(), "The provided input time is not valid");
		}
	}
}
