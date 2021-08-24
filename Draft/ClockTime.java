package sample;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ClockTime {

    public String Clock(String prefTime, String duration, String prevTime) throws ParseException {

        if(prevTime.equals("00:00"))
        {
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
        }

        double x = Double.parseDouble(duration);
        x = x*60;


        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        Date d = df.parse(prevTime);
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);

        cal.add(Calendar.MINUTE, (int) x);
        String newTime = df.format(cal.getTime());

        return newTime;
    }



}
