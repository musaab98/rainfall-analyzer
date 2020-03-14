// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Musaab Elsheikh (melsheikh)

import sofia.micro.*;
import java.util.*;
import sofia.graphics.*;
import student.*;

//-------------------------------------------------------------------------
/**
 *  Displays rainfall/weather station data
 *
 *  @author Musaab Elsheikh (melsheikh)
 *  @version (2019.12.09)
 */
public class RainfallAnalyzer extends World
{
    //~ Fields ................................................................
    
    private WeatherBureau bureau;
    private TextShape text;
    private WeatherStation station;
    
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new RainfallAnalyzer object.
     * @param input     scanner stream
     */
    public RainfallAnalyzer(Scanner input)
    {
        super(8, 5, 72);
        this.bureau = new WeatherBureau();
        bureau.recordDailySummaries(input);
        station = bureau.lowestStation();
        String iD;
        int low;
        double avg;
        if (station != null)
        {
            iD = station.getId();
            low = station.getLowestMonth();
            avg = station.getAvgForMonth(station.getLowestMonth());
            text = new TextShape(iD + ": " + low + ": " + 
                String.format("%.2f", avg));
            add(text, 4, 2);
            text.setTypeSize(40);
            text.setColor(Color.black);
        }
        else
        {
            text = new TextShape("no data");
            add(text, 3, 2);
            text.setTypeSize(60);
            text.setColor(Color.black);
        }
    }
    /**
     * Reads from online weather data txt file
     */
    public RainfallAnalyzer()
    {
        this(IOHelper.createScannerForURL(
                "http://courses.cs.vt.edu/~cs1114/Kenya-2014-2016.txt"));
    }


    //~ Methods ...............................................................
    
    /**
     * Bureau getter method
     * @return      bureau
     */
    public WeatherBureau getBureau()
    {
        return bureau;
    }
    
    /**
     * Text getter method
     * @return text
     */
    public TextShape getText()
    {
        return text;
    }
    
    /**
     * Station getter method
     * @return lowest station
     */
    public WeatherStation getStation()
    {
        return station;
    }
}












