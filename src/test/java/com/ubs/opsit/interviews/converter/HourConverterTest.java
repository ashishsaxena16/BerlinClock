package com.ubs.opsit.interviews.converter;

import org.junit.Before;
import org.junit.Test;

import static com.ubs.opsit.interviews.util.BerlinClockConstant.LINE_SEPERATOR;
import static org.junit.Assert.*;

public class HourConverterTest {

	private HourConverter hourConverter;

	@Before
	public void setUp() {
		this.hourConverter = new HourConverter();
	}

	@Test
	public void testMorning() {
		final String morning9AM = "09";
		final String expectedResult = String.join(LINE_SEPERATOR, "ROOO", "RRRR");
		final String actualResult = this.hourConverter.convertTime(morning9AM);

		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testNoon() {
		final String morning9AM = "12";
		final String expectedResult = String.join(LINE_SEPERATOR, "RROO", "RROO");
		final String actualResult = this.hourConverter.convertTime(morning9AM);

		assertEquals(expectedResult, actualResult);

	}

	@Test
	public void testEvening() {
		final String morning9AM = "18";
		final String expectedResult = String.join(LINE_SEPERATOR, "RRRO" , "RRRO");
		final String actualResult = this.hourConverter.convertTime(morning9AM);

		assertEquals(expectedResult, actualResult);

	}
}