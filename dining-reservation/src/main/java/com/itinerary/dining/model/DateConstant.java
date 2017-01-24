package com.itinerary.dining.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * DateConstant.
 * @author akuma408
 * DateConstant
 */
public final class DateConstant {
	/**
	 * DateConstant.
	 */
	private DateConstant() {
	}
/**
 * getDateToString.
 * @param date date
 * @return String
 */
	public static String getDateToString(final Date date) {
		SimpleDateFormat dateFormat =
				new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}

	/**
	 * getStringToDate method return string. hello
	 * @param date
	 *            date
	 * @return Date Date
	 */
	public static Date getStringToDate(final String date) {
		Date d = null;
		try {
			SimpleDateFormat dateFormat =
					new SimpleDateFormat("yyyy-MM-dd");
			d = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

}
