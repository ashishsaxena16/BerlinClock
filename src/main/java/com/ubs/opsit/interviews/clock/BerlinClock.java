package com.ubs.opsit.interviews.clock;

import com.ubs.opsit.interviews.TimeConverter;
import com.ubs.opsit.interviews.converter.HourConverter;
import com.ubs.opsit.interviews.converter.MinuteConverter;
import com.ubs.opsit.interviews.converter.SecondConverter;
import com.ubs.opsit.interviews.validator.BerlinTimeFormatValidator;
import com.ubs.opsit.interviews.validator.TimeValidator;

import static com.ubs.opsit.interviews.util.BerlinClockConstant.LINE_SEPERATOR;
import static com.ubs.opsit.interviews.util.BerlinClockConstant.TIME_FORMAT;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Berlin Clock class implements the convertTime method from TimeConverter
 * interface Used for conversion of the input time string to Berlin clock
 * representation. Members include Hour minute and time converter and
 * TimeValidator utility to validate the time format.
 * 
 * @author Ashish
 */
public class BerlinClock implements TimeConverter {

	/**
	 * TimeConverter class to convert hour part of input time string to berlin
	 * clock representation
	 */
	private final HourConverter hourConverter = new HourConverter();
	/**
	 * TimeConverter class to convert minute part of input time string to berlin
	 * clock representation
	 */
	private final MinuteConverter minuteConverter = new MinuteConverter();
	/**
	 * TimeConverter class to convert seconds part of input time string to
	 * berlin clock representation
	 */
	private final SecondConverter secConverter = new SecondConverter();
	/**
	 * TimeValidator to validate time format with TIME_FORMAT(HH:mm:ss) defined
	 * in BerlinClockConstants
	 */
	private final TimeValidator validator = new BerlinTimeFormatValidator(TIME_FORMAT);

	private static Logger logger = LoggerFactory.getLogger(BerlinClock.class);
	/**
	 * TimeConverter implementation of the converTime method to return Berlin
	 * Clock representation Utilizes TimeValidator to validate time and
	 * converter methods to different parts of input time
	 * 
	 * @param aTime
	 *            time to be represented by Berlin Clock
	 * @return berlin clock representation of time or the invalid time string
	 *         message
	 */
	@Override
	public String convertTime(String aTime) {

		/**
		 * Validate that the time is in the expected format by passing
		 * 
		 * @param aTime
		 *            input time string and assessing the
		 * @return boolean to represent valid time string input
		 */
		if (!validator.validateTime(aTime)) {
			logger.error("The provided input time: {} is not valid", aTime);
			throw new IllegalArgumentException("The provided input time is not valid");
		}

		/**
		 * Split the valid time string to hour, minutes and second
		 */
		final String[] timeArr = Arrays.stream(aTime.split(":"))
				.toArray(String[]::new);

		/**
		 * Delegate the time conversion to HourConverter, Minute Converter and
		 * SecondConverter
		 */
		final String hour = this.hourConverter.convertTime(timeArr[0]);
		final String min = this.minuteConverter.convertTime(timeArr[1]);
		final String sec = this.secConverter.convertTime(timeArr[2]);

		/**
		 * Join and return the Berlin clock string representation from the time
		 * converters separated by the platform line separator
		 */
		return String.join(LINE_SEPERATOR, sec, hour, min);
	}

}
