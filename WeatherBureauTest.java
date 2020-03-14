// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Musaab Elsheikh (melsheikh)

import sofia.micro.*;
import java.util.*;

// -------------------------------------------------------------------------
/**
 *  Tests methods in weather bureau
 *
 *  @author Musaab Elsheikh (melsheikh)
 *  @version (2019.12.09)
 */
public class WeatherBureauTest extends TestCase
{
    //~ Fields ................................................................
    
    private WeatherBureau bureau;
    
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new WeatherBureauTest test object.
     */
    public WeatherBureauTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        bureau = new WeatherBureau();
    }


    // ----------------------------------------------------------
    /**
     * tests station getter method
     */
    public void testGetStation()
    {
        String line = "KE00006696 3.933 41.867 231 5/25/15 -1.0 88 -1 -1";
        bureau.recordDailySummary(line);
        assertNotNull(bureau.getStation("KE00006696"));
    }

    /**
     * tests station getter method for null value
     */
    public void testGetStation2()
    {
        assertNull(bureau.getStation("sample text"));
    }  
    
    /**
     * tests lowest station method for one month
     */
    public void testLowestStation()
    {
        String line = "KE000063612 3.117 35.617 515 3/26/14 0.08 80 97 -1";
        String line2 = "KE000063723 -0.467 39.633 147 3/15/14 1.26 83 -1 71";
        bureau.recordDailySummary(line);
        bureau.recordDailySummary(line2);
        assertEquals(bureau.lowestStation(3).getId(), "KE000063612");
    }

    /**
     * tests lowest station method for all months
     */
    public void testLowestStation2()
    {
        String line = "KE000063612 3.117 35.617 515 3/26/14 0.08 80 97 -1";
        String line2 = "KE000063723 -0.467 39.633 147 3/15/14 1.26 83 -1 71";
        bureau.recordDailySummary(line);
        bureau.recordDailySummary(line2);
        assertEquals(bureau.lowestStation().getId(), "KE000063612");
    }

    /**
     * tests lowest station method for null value
     */
    public void testLowestStation3()
    {
        assertNull(bureau.lowestStation());
    }

    /**
     * Tests lowest station for month with no values
     */
    public void testLowestStation4()
    {
        assertNull(bureau.lowestStation(3)); 
    }
}
