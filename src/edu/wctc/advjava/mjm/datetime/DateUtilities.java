package edu.wctc.advjava.mjm.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import static java.time.temporal.ChronoUnit.SECONDS;
import static java.time.temporal.ChronoUnit.MINUTES;
import static java.time.temporal.ChronoUnit.HOURS;
import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.WEEKS;
import static java.time.temporal.ChronoUnit.MONTHS;
import java.util.Calendar;

/**
 * A utility class that represents commonly used Date/Time methods for the
 * JDK 8 API.
 * <br>
 * @author Mark J. Mersenski, mmersenski@my.wctc.edu
 * @version 1.00
 * @since 1.8
 * 
 */
public class DateUtilities {

    /**
     * Format a LocalDateTime object to a month/day/year hour:minute 
     * format (mm/dd/yyyy HH:mm)<br>
     *
     * @param date a LocalDateTimeobject
     * @return a date formatted to month/day/year hour:minute (mm/dd/yyyy HH:mm)
     * @throws IllegalArgumentException if date is null
     */
    public final String toString(LocalDateTime date) throws IllegalArgumentException {
        if (date == null) {
            throw new IllegalArgumentException("Error: date argument cannot be null");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
        return date.format(formatter);
    }

    /**
     * Format a LocalDateTime object according to a specified format.
     * For example, you can put a LocalDateTime object in the format
     * of 'yyyy/MM/dd' or 'HH:mm' or 'MM-dd HH:mm'.<br>
     *
     * @param date a LocalDateTime object
     * @param pattern a String with the specified date and time pattern
     * @return a date and/or time format according to the specified pattern
     * @throws IllegalArgumentException if pattern is not recognized and/or date
     * is null
     */
    public final String toString(LocalDateTime date, String pattern) throws IllegalArgumentException {
        if (date == null) {
            throw new IllegalArgumentException("Error: date argument cannot be null");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }

    /**
     * Attempts to convert a String representation of a date and time to a
     * LocalDateTime object. Conversion rules are based on parse
     * definitions in the java.​time.​format.​DateTimeFormatter class.<br>
     * <br>
     * Format has to be this way: 'yyyy-MM-ddTHH:mm:ss'<br>
     *
     * @param dateString a string representation of a date
     * @return a LocalDateTime object
     * @throws IllegalArgumentException if the date string cannot be parsed
     * and/or if the string object is null or empty.
     */
    public final LocalDateTime toDateTime(String dateString) throws IllegalArgumentException {
        if (dateString == null || dateString.isEmpty()) {
            throw new IllegalArgumentException("Error: dateString argument cannot be null or empty");
        }

        LocalDateTime date = LocalDateTime.parse(dateString);
        return date;
    }

     /**
     * Attempts to convert a String representation of a date and time to a
     * LocalDateTime object by any pattern specified. 
     * Conversion rules are based on parse definitions in the 
     * java.​time.​format.​DateTimeFormatter class.
     *
     * @param dateString a string representation of a date and time
     * @param pattern a String with the specified date and time pattern
     * @return a LocalDateTime object
     * @throws IllegalArgumentException if the date string cannot be parsed
     * and/or if the string object is null or empty.
     */
    public final LocalDateTime toDateTime(String dateString, String pattern) throws IllegalArgumentException {
        if (dateString == null || dateString.isEmpty()) {
            throw new IllegalArgumentException("Error: dateString argument cannot be null or empty");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime date = LocalDateTime.parse(dateString, formatter);

        return date;
    }

     /**
     * Attempts to perform a calculation between two LocalDateTime objects by
     * using a specified ChronoUnit and returns a long object.<br>
     * <br>
     * supported ChronoUnits are:<br>
     * SECONDS<br>
     * MINUTES<br>
     * HOURS<br>
     * DAYS<br>
     * WEEKS<br>
     * MONTHS<br>
     * <br>
     * all other values will throw an exception. calculation will take endDate and
     * subtract startDate to return long value.<br>
     * @param startDate the starting LocalDateTime object for calculation
     * @param endDate the ending LocalDateTime object for calculation
     * @param unit must be a supported ChronoUnit from list above
     * @return a long object
     * @throws IllegalArgumentException if any objects are null.
     */
    public final long getDateDiff(LocalDateTime startDate, LocalDateTime endDate, ChronoUnit unit)
    throws IllegalArgumentException{
        if (startDate == null) {
            throw new IllegalArgumentException("Error: startDate cannot be null");
        }
        else if (endDate == null) {
            throw new IllegalArgumentException("Error: endDate cannot be null");
        }
        else if (unit == null) {
            throw new IllegalArgumentException("Error: unit cannot be null");
        }
        
        long tempDateDiff = unit.between(startDate, endDate);
        return tempDateDiff;
    }
    
}
