package com.ubs.opsit.interviews.converter;

import com.ubs.opsit.interviews.TimeConverter;

import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The AbstractTimeConverter class is an abstract class whose concrete
 * definitions are expected to extend the time conversion of TimeConverter to
 * the parts of time- hours, mins and seconds.
 * 
 * @author Ashish
 */
public abstract class AbstractTimeConverter implements TimeConverter {

	/**
	 * Method to represent a group of lamp for Berlin clock representation
	 * 
	 * @param range
	 *            range of lamps in berlin time unit
	 * @param timeToLampFunction
	 *            function to populate the lamps value
	 * @return
	 */
	protected String timeGrouper(final Integer range, final IntFunction<String> timeToLampFunction) {
		return IntStream.range(0, range)
				.boxed()
				.map(timeToLampFunction::apply)
				.collect(Collectors.joining(""));
	}
}
