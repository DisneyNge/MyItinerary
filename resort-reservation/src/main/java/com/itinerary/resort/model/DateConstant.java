package com.itinerary.resort.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateConstant class.
 *
 * @author akuma408
 *
 */
public final class DateConstant {
    /***
     * private constructor.
     */
    private DateConstant() {

    }

    /**
     * @param date
     *            date
     * @return String
     */
    public static String getDateToString(final Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    /**
     * @param date
     *            date
     * @return Date
     */
    public static Date getStringToDate(final String date) {
        Date d = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
            d = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }

}
