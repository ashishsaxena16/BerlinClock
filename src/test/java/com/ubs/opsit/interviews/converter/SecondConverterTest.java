package com.ubs.opsit.interviews.converter;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SecondConverterTest {

	private SecondConverter secConverter;

	@Before
	public void setUp() {

		this.secConverter = new SecondConverter();

	}

	@Test
	public void testFiveSecs() {
		final String time = "05";
		final String expectedResult = "O";
		final String actualResult = this.secConverter.convertTime(time);

		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testEightSecs() {
		final String time = "8";
		final String expectedResult = "Y";
		final String actualResult = this.secConverter.convertTime(time);

		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testZeroSecs() {
		final String time = "00";
		final String expectedResult = "Y";
		final String actualResult = this.secConverter.convertTime(time);

		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testFiftyNineSecs() {
		final String time = "59";
		final String expectedResult = "O";
		final String actualResult = this.secConverter.convertTime(time);

		assertEquals(expectedResult, actualResult);
	}
}
