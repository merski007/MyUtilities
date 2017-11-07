package edu.wctc.advjava.mjm.datetime;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for DateUtilities
 * <br>
 * @author mjmersenski
 * @version 1.00
 */
public class DateUtilitiesTest {
    private DateUtilities du;
    
    public DateUtilitiesTest() {
    }
    
    @Before
    public void setUp() {
        du = new DateUtilities();
    }
    
    @After
    public void tearDown() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullLocalDateTimeValueThrowsException(){
        LocalDateTime ldt = null;
        du.localDateTimeToString(ldt);
    }
    
    @Test
    public void validLocalDateTimeValuePasses(){
        LocalDateTime ldt = LocalDateTime.now();
        du.localDateTimeToString(ldt);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nullLocalDateTimeValueWithValidPatternThrowsException(){
        LocalDateTime ldt = null;
        String pattern = "yyyy-MM-dd HH:mm";
        du.localDateTimeToString(ldt, pattern);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nullLocalDateTimeValueWithInvalidPatternThrowsException(){
        LocalDateTime ldt = null;
        String pattern = "yyyy-mm-DD HH:mm";
        du.localDateTimeToString(ldt, pattern);
    }
    
    @Test(expected = DateTimeException.class)
    public void validLocalDateTimeValueWithInvalidPatternThrowsException(){
        LocalDateTime ldt = LocalDateTime.now();
        String pattern = "yyyy-mm-DD HH:mm";
        du.localDateTimeToString(ldt, pattern);
    }    
    
    @Test
    public void validLocalDateTimeValueWithValidPattern(){
        LocalDateTime ldt = LocalDateTime.now();
        String pattern = "yyyy-MM-dd HH:mm";
        du.localDateTimeToString(ldt, pattern);
    }  
    
}
