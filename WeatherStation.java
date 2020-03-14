// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Musaab Elsheikh (melsheikh)

//-------------------------------------------------------------------------
/**
 *  Weather Station class that stores statistics for rainfall.
 *
 *  @author Musaab Elsheikh (melsheikh)
 *  @version (2019.12.09)
 */
public class WeatherStation 
{
    //~ Fields ................................................................
    
    private String iD;
    private double[] totalRain;
    private int[] dailyRain;
    
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new WeatherStation object.
     * @param iD        given iD for station
     */
    public WeatherStation(String iD)
    {
        dailyRain = new int[12];
        totalRain = new double[12];
        this.iD = iD;
    }
    
    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * ID getter method
     * @return      station's ID
     */
    public String getId()
    {
        return this.iD;
    }
    
    /**
     * Records the information from one daily raifall summary
     * @param month         given month in which it rains
     * @param rainfall      amount of rain
     */
    public void recordDailyRain(int month, double rainfall)
    {
        totalRain[month - 1] += rainfall;
        dailyRain[month - 1]++;
    }
    
    /**
     * Gets amount of daily rainfall values
     * @param month         given month in which it rains
     * @return              number of daily rainfall values
     */
    public int getCountForMonth(int month)
    {
        return dailyRain[month - 1];
    }
    
    /**
     * Gets average rainfall for month
     * @param month in which it rains
     * @return average daily rainfall for the month
     */
    public double getAvgForMonth(int month)
    {
        if (dailyRain[month - 1] == 0)
        {
            return -1.0;
        }
        double total = totalRain[month - 1];
        double days = dailyRain[month - 1];
        return (total / days);
    }
    
    /**
     * gets month which has least amount of rainfall
     * @return      month with lowest rainfall average
     */
    public int getLowestMonth()
    {
        double min = 999999;
        int month = 1;
        for (int i = 1; i <= 12; i++)
        {
            if (getAvgForMonth(i) == -1.0)
            {
                continue;
            }
            if (getAvgForMonth(i) < min)
            {
                min = getAvgForMonth(i);
                month = i;
            }
        }
        return month;
    }
}




















