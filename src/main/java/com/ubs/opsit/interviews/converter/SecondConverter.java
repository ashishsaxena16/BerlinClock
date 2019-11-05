package com.ubs.opsit.interviews.converter;

import static com.ubs.opsit.interviews.util.BerlinClockConstant.O_IND;
import static com.ubs.opsit.interviews.util.BerlinClockConstant.Y_IND;

/**
 * The SecondConverter class assumes the responsibility to convert the seconds
 * portion of the input time string to the Berlin clock representation of
 * seconds.
 * 
 * @author Ashish
 */
public class SecondConverter extends AbstractTimeConverter {

	/**
	 * The method generates the representation for seconds lamp of the Berlin
	 * clock
	 * 
	 * @param aTime
	 *            seconds portion of the input time
	 * @return string for seconds representation of Berlin clock
	 */
	@Override
	public String convertTime(final String aTime) {
		return Integer.parseInt(aTime) % 2 == 0 ? Y_IND : O_IND;
	}
}
