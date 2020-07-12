package sample;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToInt {


    public double daysBetween;

    public String MonthToInt(String month)
    {
        if(month.equals("January"))
            return "01";
        else if(month.equals("February"))
            return "02";
        else if(month.equals("March"))
            return "03";
        else if(month.equals("April"))
            return "04";
        else if(month.equals("May"))
            return "05";
        else if(month.equals("June"))
            return "06";
        else if(month.equals("July"))
            return "07";
        else if(month.equals("August"))
            return "08";
        else if(month.equals("September"))
            return "09";
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
            
            System.out.println("Number of Days between dates: "+daysBetween);
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
