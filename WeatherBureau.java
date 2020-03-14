// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Musaab Elsheikh (melsheikh)

import java.util.*;

//-------------------------------------------------------------------------
/**
 *  Weather Bureau class that manages weather station data
 *
 *  @author Musaab Elsheikh (melsheikh)
 *  @version (2019.12.09)
 */
public class WeatherBureau 
{
    //~ Fields ................................................................
    private HashMap<String, WeatherStation> weatherMap;
    
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new WeatherBureau object.
     */
    public WeatherBureau()
    {
        weatherMap = new HashMap<String, WeatherStation>();
    }
    
    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Records the rainfall from a string of text
     * @param text      given text w/ rainfall
     */
    public void recordDailySummary(String text)
    {
        Scanner scanner = new Scanner(text);
        String iD = scanner.next();
        if (!weatherMap.containsKey(iD))
        {
            weatherMap.put(iD, new WeatherStation(iD));
        }
        WeatherStation station = weatherMap.get(iD);
        String word = "";
        scanner.next();
        scanner.next();
        scanner.next();
        word = scanner.next();
        int day = word.indexOf("/");
        String month = word.substring(0, day);
        double rainfall = Double.parseDouble(scanner.next());
        int monthInt = Integer.parseInt(month);
        if (rainfall != -1.0)
        {
            station.recordDailyRain(monthInt, rainfall);
        }
    }
    
    /**
     * Records daily summaries for weather stations
     * @param input         from data source
     */
    public void recordDailySummaries(Scanner input)
    {
        while (input.hasNextLine())
        {
            String line = input.nextLine();
            recordDailySummary(line);
        }        
    }
    
    /**
     * Weather station getter
     * @param       iD the station's identification
     * @return      the weather station object
     */
    public WeatherStation getStation(String iD)
    {
        return weatherMap.get(iD);
    }
    
    /**
     * Gets weather station with lowest average rainfall for month
     * @param month     given month of rain
     * @return          station with the least rainfall
     */
    public WeatherStation lowestStation(int month)
    {
        WeatherStation station = null; 
        double min = 999999.9;
        for (WeatherStation values : weatherMap.values())
        {
            double average = values.getAvgForMonth(month);
            if (average != -1 && average < min)
            {
                min = average;
                station = values;
            }
        }
        return station;
    }
    
    /**
     * Gets weather station with lowest average rainfall in ANY month
     * @return          station with the least rainfall
     */
    public WeatherStation lowestStation()
    {
        WeatherStation station = null;
        double min = 999999.0;
        double avg = 0.0;
        for (String keys : weatherMap.keySet())
        {
            WeatherStation s = weatherMap.get(keys);
            avg = s.getAvgForMonth(s.getLowestMonth());
            if (station == null) {
                station = s;
                min = station.getAvgForMonth(station.getLowestMonth());
            }
            else if (avg < min)
            {
                station = s;
                min = s.getAvgForMonth(station.getLowestMonth());
            }
        }
        return station;
    }
}
















