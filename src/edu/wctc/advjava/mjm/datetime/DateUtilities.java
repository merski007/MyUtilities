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
 *
 * @author mjmersenski
 */
public class DateUtilities {

    /**
     * Format a <code>LocalDateTime</code> to a month/day/year hour:minute format (mm/dd/yyyy HH:mm)
     *
     * @param date a <code>LocalDateTime</code> object
     * @return a date formatted to month/day/year hour:minute (mm/dd/yyyy HH:mm)
     * @throws IllegalArgumentException if date is null
     */
    public String toString(LocalDateTime date) throws IllegalArgumentException {
        if (date == null) {
            throw new IllegalArgumentException("Error: date argument cannot be null");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
        return date.format(formatter);
        // add an exception
    }

    /**
     * Format a <code>LocalDateTime</code> object according to a specified format
     *
     * @param date a <code>LocalDateTime</code> object
     * @param pattern a String with the specified date & time pattern
     * @return a date and/or time format according to the specified pattern
     * @throws IllegalArgumentException if pattern is not recognized and/or date
     * is null
     */
    public String toString(LocalDateTime date, String pattern) throws IllegalArgumentException {
        if (date == null) {
            throw new IllegalArgumentException("Error: date argument cannot be null");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }

    /**
     * Attempts to convert a String representation of a date & time to a
     * <code>LocalDateTime<code> object. Conversion rules are based on parse
     * definitions in the java.​time.​format.​DateTimeFormatter class.
     *
     * @param dateString a string representation of a date
     * @return a <code>LocalDateTime<code> object
     * @throws IllegalArgumentException if the date string cannot be parsed
     * and/or if the string object is null or empty.
     */
    public LocalDateTime toDateTime(String dateString) throws IllegalArgumentException {
        if (dateString == null || dateString.isEmpty()) {
            throw new IllegalArgumentException("Error: dateString argument cannot be null or empty");
        }

        LocalDateTime date = LocalDateTime.parse(dateString);
        return date;
    }

     /**
     * Attempts to convert a String representation of a date to a
     * <code>LocalDateTime<code> object by with any pattern specified. 
     * Conversion rules are based on parse definitions in the 
     * java.​time.​format.​DateTimeFormatter class.
     *
     * @param dateString a string representation of a date & time
     * @param pattern a String with the specified date & time pattern
     * @return a <code>LocalDateTime<code> object
     * @throws IllegalArgumentException if the date string cannot be parsed
     * and/or if the string object is null or empty.
     */
    public LocalDateTime toDateTime(String dateString, String pattern) throws IllegalArgumentException {
        if (dateString == null || dateString.isEmpty()) {
            throw new IllegalArgumentException("Error: dateString argument cannot be null or empty");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime date = LocalDateTime.parse(dateString, formatter);

        return date;
    }

     /**
     * Attempts to perform a calculation between two <code>LocalDateTime<code> objects by
     * using a specified <code>ChronoUnit<code> and returns a <code>long<code> object.
     * 
     * supported ChronoUnits are:
     * SECONDS
     * MINUTES
     * HOURS
     * DAYS
     * WEEKS
     * MONTHS
     * 
     * all other values will throw an exception. calculation will take endDate and
     * subtract startDate to return long value.
     *
     * @param startDate the starting <code>LocalDateTime<code> object for calculation
     * @param endDate the ending <code>LocalDateTime<code> object for calculation
     * @param unit must be a supported <code>ChronoUnit<code> from list above
     * @return a long object
     * @throws IllegalArgumentException if any objects are null.
     */
    public long getDateDiff(LocalDateTime startDate, LocalDateTime endDate, ChronoUnit unit)
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
    
    public static void main(String[] args) {
        DateUtilities mjm = new DateUtilities();

//        // toString test - outputs a formatted string MM/dd/yyyy
        LocalDateTime today = LocalDateTime.now();
        System.out.println(mjm.toString(today));

//        // toString test - takes a date and format as parameters and returns specified format
//        LocalDateTime today = LocalDateTime.now();
//        String pattern = "yyyy/MM/dd HH:mm";
//        System.out.println(mjm.toString(today, pattern));

//        // toDateTime test - takes a string as a paramter
//        String today = "2007-11-03T12:30:00";
//        mjm.toDateTime(today);
//        System.out.println(mjm.toDateTime(today));

//         toDateTime test - takes a string date and a string format
//        String today = "11/03/2017 12:30";
//        String pattern = "MM/dd/yyyy HH:mm";
//        System.out.println(mjm.toDateTime(today, pattern));

        // getDateDiff - 
//        LocalDateTime date = LocalDateTime.now();
//        LocalDateTime yesterday = date.minusDays(1);
//        System.out.println(mjm.getDateDiff(yesterday, date, DAYS));

    }
}
