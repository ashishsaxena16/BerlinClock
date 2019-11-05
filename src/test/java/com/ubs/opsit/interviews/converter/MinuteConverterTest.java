package com.ubs.opsit.interviews.converter;

import org.junit.Before;
import org.junit.Test;

import static com.ubs.opsit.interviews.util.BerlinClockConstant.LINE_SEPERATOR;
import static org.junit.Assert.*;

public class MinuteConverterTest {

	private MinuteConverter minConverter;

	@Before
	public void setUp() {
		this.minConverter = new MinuteConverter();
	}

	@Test
	public void testZeroMin() {
		final String time = "00";
		final String expectedResult = String.join(LINE_SEPERATOR, "OOOOOOOOOOO", "OOOO");
		final String actualResult = this.minConverter.convertTime(time);

		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testFiftyFiveMin() {
		final String time = "55";
		final String expectedResults = String.join(LINE_SEPERATOR, "YYRYYRYYRYY", "OOOO");
		final String actualResults = this.minConverter.convertTime(time);

		assertEquals(expectedResults, actualResults);

	}

	@Test
	public void testNineteenMin() {
		final String time = "19";
		final String expectedResults = String.join(LINE_SEPERATOR, "YYROOOOOOOO", "YYYY");
		final String actualResults = this.minConverter.convertTime(time);

		assertEquals(expectedResults, actualResults);
	}

	@Test
	public void testFiftyNineMin() {
		final String time = "59";
		final String expectedResults = String.join(LINE_SEPERATOR, "YYRYYRYYRYY", "YYYY");
		final String actualResults = this.minConverter.convertTime(time);

		assertEquals(expectedResults, actualResults);
	}
}
