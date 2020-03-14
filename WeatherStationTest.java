// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Musaab Elsheikh (melsheikh)

import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  Tests methods in weather station
 *
 *  @author Musaab Elsheikh (melsheikh)
 *  @version (2019.12.09)
 */
public class WeatherStationTest extends TestCase
{
    //~ Fields ................................................................
    
    private WeatherStation station;
    
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new WeatherStationTest test object.
     */
    public WeatherStationTest()
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
        station = new WeatherStation("KE000069420");
    }
    
    
    // ----------------------------------------------------------
    /**
     * tests get ID method for correct ID
     */
    public void testGetID()
    {
        assertEquals("KE000069420", station.getId());
    }
    
    /**
     * tests get count for month
     */
    public void testGetCountForMonth()
    {
        station.recordDailyRain(4, 2.0);
        assertEquals(1, station.getCountForMonth(4));
    }
    
    
    /**
     * Tests record daily rain method
     */
    public void testRecordDailyRain1()
    {
        station.recordDailyRain(7, 2.5);
        assertEquals(1, station.getCountForMonth(7));
        assertEquals(2.5, station.getAvgForMonth(7), 0.001);
    }
    
    /**
     * Tests that -1 is returned when month is 1
     */
    public void testRecordDailyRain2()
    {
        assertEquals(-1.0, station.getAvgForMonth(6), 0.001);
    }
    
    /**
     * Tests which month has the lowest rainfall
     */
    public void testLowestMonth()
    {
        station.recordDailyRain(4, 6.7);
        station.recordDailyRain(8, 1.1);
        //assertEquals(1, station.getAvgForMonth(1), 0.001);  
        assertEquals(8, station.getLowestMonth());  
    }
}

























