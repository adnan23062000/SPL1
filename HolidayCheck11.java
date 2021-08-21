package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class HolidayCheck11 {

    public void HolidayMatch(ArrayList<String> ara) throws FileNotFoundException {

        File file = new File("src\\holiday.txt");
        Scanner scanner = new Scanner(file);


        while (scanner.hasNextLine()) {

            String[] elements = scanner.nextLine().split("->", 0);
            int dayToday = Integer.parseInt(elements[0]);

            LocalDate date = LocalDate.now();
            DayOfWeek day = DayOfWeek.from(date);

            int val = day.getValue();

            if (val == dayToday) {
                ara.add(elements[1]);
                ara.add(elements[2]);
                ara.add(elements[3]);
                break;
            }
        }
    }
}
