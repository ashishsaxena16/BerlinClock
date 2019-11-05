package com.ubs.opsit.interviews.validator;

import org.junit.Before;
import org.junit.Test;

import static com.ubs.opsit.interviews.util.BerlinClockConstant.TIME_FORMAT;
import static org.junit.Assert.*;

public class BerlinTimeFormatValidatorTest {

	private TimeValidator timeValidator;

	@Before
	public void setUp() {

		this.timeValidator = new BerlinTimeFormatValidator(TIME_FORMAT);

	}

	@Test
	public void test_NullString() {
		boolean expectedResult = false;
		boolean actualResult = this.timeValidator.validateTime(null);

		assertEquals(expectedResult, actualResult);

	}

	@Test
	public void test_EmptyString() {
		boolean expectedResult = false;
		boolean actualResult = this.timeValidator.validateTime(" ");

		assertEquals(expectedResult, actualResult);

	}

	@Test
	public void tesInvalidString() {
		boolean expectedResult = false;
		boolean actualResult = this.timeValidator.validateTime(" : : ");

		assertEquals(expectedResult, actualResult);

	}

	@Test
	public void testValidTime1String() {
		boolean expectedResult = true;
		boolean actualResult = this.timeValidator.validateTime("12:49:32");

		assertEquals(expectedResult, actualResult);

	}

	@Test
	public void testValidTime_Midnight_String() {
		boolean expectedResult = true;
		boolean actualResult = this.timeValidator.validateTime("00:00:00");

		assertEquals(expectedResult, actualResult);

	}

	@Test
	public void testValidTime_Midnight_TwentyFour_Hour_String() {
		boolean expectedResult = true;
		boolean actualResult = this.timeValidator.validateTime("24:00:00");

		assertEquals(expectedResult, actualResult);

	}

	@Test
	public void test_Should_Validate_Invalid_Hour_String() {
		boolean expectedResult = false;
		boolean actualResult = this.timeValidator.validateTime("-1:20:40");

		assertEquals(expectedResult, actualResult);

	}

	@Test
	public void test_Should_Validate_Invalid_Minute_String() {
		boolean expectedResult = false;
		boolean actualResult = this.timeValidator.validateTime("12:79:40");

		assertEquals(expectedResult, actualResult);

	}

	@Test
	public void test_Should_Validate_Invalid_Second_String() {
		boolean expectedResult = false;
		boolean actualResult = this.timeValidator.validateTime("12:49:82");

		assertEquals(expectedResult, actualResult);

	}

	@Test
	public void test_Should_Validate_Invalid_Minute_sixty_String() {
		boolean expectedResult = false;
		boolean actualResult = this.timeValidator.validateTime("12:60:22");

		assertEquals(expectedResult, actualResult);

	}
}
