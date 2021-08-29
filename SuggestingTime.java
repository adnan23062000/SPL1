package sample;

import java.io.IOException;
import java.text.ParseException;
import java.util.Random;

public class SuggestingTime {

    public String prevTime;
    public String finTime;

    public String TimeSuggester(double val) throws IOException
    {
        ClockTime ob2 = new ClockTime();

        PreferableTime obj = new PreferableTime();
        String prefTime = obj.ReadPrefTime();

        if(prefTime.equals("Morning"))
            prevTime = "9:00";
        else if (prefTime.equals("Noon"))
            prevTime = "14:00";
        else if (prefTime.equals("Afternoon"))
            prevTime = "16:00";
        else if(prefTime.equals("Evening"))
            prevTime = "18:30";
        else if(prefTime.equals("Night"))
            prevTime = "20:30";
        else if(prefTime.equals("Anytime"))
        {
            String[] arr = new String[] { "10:00", "12:00", "2:00", "4:00", "6:00", "8:00", "14:00", "16:00", "18:00", "20:00"};
            prevTime = arr[new Random().nextInt(arr.length)];

        }

        try {
            finTime = ob2.Clock(prefTime, Double.toString(val), prevTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return prevTime + "   to   " + finTime;


    }


}
