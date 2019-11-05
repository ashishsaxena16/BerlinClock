package com.ubs.opsit.interviews.validator;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BerlinTimeFormatValidator implements TimeValidator {

	private final String timeFormat;
	private static final Logger logger = LoggerFactory.getLogger(BerlinTimeFormatValidator.class);

	public BerlinTimeFormatValidator(final String timeFormat) {
		super();
		this.timeFormat = timeFormat;
	}

	@Override
	public boolean validateTime(final String timeString) {

		return (validateIsNotNullOrBlank(timeString) && isValidTimeString(timeString, this.timeFormat));
	}

	private boolean isValidTimeString(final String timeString, final String timeFormat) {

		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(timeFormat);
		try {
			LocalTime.parse(timeString, formatter);
			return true;
		} catch (DateTimeParseException ex) {
			logger.error(ex.getMessage());
		}
		return false;
	}

	private boolean validateIsNotNullOrBlank(final String timeString) {
		return (null != timeString && !"".equals(timeString.trim()));
	}
}
