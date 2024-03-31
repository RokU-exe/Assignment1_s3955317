/**
 * @author <Le Xuan Loc - s3955317>
 */

package org.system.insurance.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility class for handling common date operations.
 */
public class DateUtil {
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);

    /**
     * Parses a date string into a Date object.
     *
     * @param dateString The string representation of the date.
     * @return A Date object.
     * @throws ParseException If the dateString cannot be parsed.
     */
    public static Date parseDate(String dateString) throws ParseException {
        return simpleDateFormat.parse(dateString);
    }

    /**
     * Formats a Date object into a string representation.
     *
     * @param date The Date object to format.
     * @return A string representation of the date.
     */
    public static String formatDate(Date date) {
        return simpleDateFormat.format(date);
    }

    /**
     * Compares two dates to determine which comes first.
     *
     * @param date1 The first date.
     * @param date2 The second date.
     * @return -1 if date1 is before date2, 1 if date1 is after date2, or 0 if they are equal.
     */
    public static int compareDates(Date date1, Date date2) {
        return date1.compareTo(date2);
    }
}
