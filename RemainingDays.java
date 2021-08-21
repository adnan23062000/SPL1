package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class RemainingDays {

    public double DateConvertString() throws FileNotFoundException
    {
        String end = null;

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = dateFormat.format(date);
        //System.out.println("Converted String: " + strDate);

        File file = new File("src\\EndDate.txt");
        Scanner scanner = new Scanner(file);

        while(scanner.hasNextLine()) {

            String[] elements = scanner.nextLine().split("->", 0);
            end = elements[0];
        }

        DateToInt ob = new DateToInt();
        double remainingDays = ob.Days(strDate, end);

        return remainingDays;

    }


}
