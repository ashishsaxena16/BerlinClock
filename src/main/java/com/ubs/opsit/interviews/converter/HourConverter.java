package com.ubs.opsit.interviews.converter;

import static com.ubs.opsit.interviews.util.BerlinClockConstant.LINE_SEPERATOR;
import static com.ubs.opsit.interviews.util.BerlinClockConstant.O_IND;
import static com.ubs.opsit.interviews.util.BerlinClockConstant.R_IND;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The HourConverter class assumes the responsibility to convert the hour
 * portion of the input time string to the Berlin clock representation of hours.
 * 
 * @author Ashish
 */
public class HourConverter extends AbstractTimeConverter {

	/**
	 * The method generates the representation for hour group five and hour
	 * unit(s) of the Berlin clock
	 * 
	 * @param aTime
	 *            hour portion of the input time
	 * @return string for hour representation of Berlin clock
	 */
	@Override
	public String convertTime(final String aTime) {
		final int hours = Integer.parseInt(aTime);
		final int hourFiveUnits = hours / 5;
		final int hourUnits = hours % 5;
		return Stream.of(hourFiveUnits, hourUnits)
				.map(hrUnitsToSelect -> this.timeGrouper(4, index -> this.mapToHourString(hrUnitsToSelect, index)))
				.collect(Collectors.joining(LINE_SEPERATOR));
	}

	/**
	 * Method to set the value in lamp
	 * 
	 * @param hrUnitsToSelect
	 *            hour units for the hour row
	 * @param index
	 *            index of lamp for setting the value
	 * @return
	 */
	private String mapToHourString(final int hrUnitsToSelect, final Integer index) {
		if (index < hrUnitsToSelect) {
			return R_IND;
		} else {
			return O_IND;
		}
	}

}
