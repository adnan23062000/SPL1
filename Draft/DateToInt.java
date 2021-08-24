package sample;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToInt {


    public double daysBetween;

    public String MonthToInt(String month)
    {
        if(month.equals("January"))
            return "1";
        else if(month.equals("February"))
            return "2";
        else if(month.equals("March"))
            return "3";
        else if(month.equals("April"))
            return "4";
        else if(month.equals("May"))
            return "5";
        else if(month.equals("June"))
            return "6";
        else if(month.equals("July"))
            return "7";
        else if(month.equals("August"))
            return "8";
        else if(month.equals("September"))
            return "9";
        else if(month.equals("October"))
            return "10";
        else if(month.equals("November"))
            return "11";
        else
            return "12";
    }

    public double Days(String dateBeforeString, String dateAfterString)
    {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");


        try {
            Date dateBefore = myFormat.parse(dateBeforeString);
            Date dateAfter = myFormat.parse(dateAfterString);
            long difference = dateAfter.getTime() - dateBefore.getTime();
            daysBetween = (difference / (1000*60*60*24));

            //System.out.println("Number of Days between dates: "+daysBetween);
            return daysBetween;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return daysBetween;
    }

    public double getDaysBetween(){
        return this.daysBetween;
    }


}
