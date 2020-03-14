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
 *  Tests methods in rainfall analyzer
 *
 *  @author Musaab Elsheikh (melsheikh)
 *  @version (2019.12.09)
 */
public class RainfallAnalyzerTest extends TestCase
{
    //~ Fields ................................................................
    
    
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new RainfallAnalyzerTest test object.
     */
    public RainfallAnalyzerTest()
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
        // no setup needed
    }


    // ----------------------------------------------------------
    /**
     * tests for no data
     */
    public void testRainfallAnalyzer()
    {
        setIn("");
        RainfallAnalyzer analyzer = new RainfallAnalyzer(in());
        assertNull(analyzer.getBureau().lowestStation());
    }

    /**
     * tests that rainfall analyzer properly scans text
     */
    public void testRainfallAnalyzer2()
    {
        setIn("KE000063613 3.117 35.617 515 4/20/16 0.47 87 98 73\n" +
            "KE000063614 3.137 31.123 515 5/10/16 0.99 89 89 74\n");
        RainfallAnalyzer analyzer = new RainfallAnalyzer(in());
        assertEquals("KE000063613: 4: 0.47", analyzer.getText().getText());
    }
    
    /**
     * tests for default constructor
     */
    public void testRainfallAnalyzer3()
    {
        RainfallAnalyzer analyzer = new RainfallAnalyzer();
        assertEquals("KEM00063741: 1: -1.00", analyzer.getText().getText());
    }
    
    /**
     * tests get station method
     */
    public void testGetStation()
    {
        RainfallAnalyzer analyzer = new RainfallAnalyzer();
        assertEquals("KEM00063741", analyzer.getStation().getId());
    }
}


























