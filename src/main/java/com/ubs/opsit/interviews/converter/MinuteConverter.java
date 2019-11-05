package com.ubs.opsit.interviews.converter;

import static com.ubs.opsit.interviews.util.BerlinClockConstant.*;

/**
 * The MinuteConverter class assumes the responsibility to convert the minutes
 * portion of the input time string to the Berlin clock representation of
 * minutes.
 * 
 * @author Ashish
 */
public class MinuteConverter extends AbstractTimeConverter {

	/**
	 * The method generates the representation for minute group five and minute
	 * unit(s) of the Berlin clock
	 * 
	 * @param aTime
	 *            minute portion of the input time
	 * @return string for minute representation of Berlin clock
	 */
	@Override
	public String convertTime(final String aTime) {
		final int minutes = Integer.parseInt(aTime);
		final int minFiveUnits = minutes / 5;
		final int minUnits = minutes % 5;

		final String minFiveString = this.timeGrouper(11, index -> this.mapToMin5String(minFiveUnits, index));
		final String minString = this.timeGrouper(4, index -> this.mapToMinString(minUnits, index));
		return String.join(LINE_SEPERATOR, minFiveString, minString);
	}

	/**
	 * Method to set the value in lamp row where each lamp represents 5 mins and
	 * every third lamp has R color
	 * 
	 * @param input
	 * @param index
	 * @return
	 */
	private String mapToMin5String(final int input, final int index) {
		if (index < input) {
			if ((index + 1) % 3 == 0) {
				return R_IND;
			} else {
				return Y_IND;
			}
		} else {
			return O_IND;
		}
	}

	/**
	 * Method to set the value in lamp
	 * 
	 * @param input
	 * @param index
	 * @return
	 */
	private String mapToMinString(final int input, final int index) {
		if (index < input) {
			return Y_IND;
		} else {
			return O_IND;
		}
	}

}
