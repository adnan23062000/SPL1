package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class ClassRoutine {

    public void RoutineAccordingToClass(String[] ara) throws FileNotFoundException {
        File file = new File("D:\\newfolder\\classRoutine.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {

            String[] elements = scanner.nextLine().split("->", 0);
            int dayToday = Integer.parseInt(elements[0]);
            String sub1 = elements[1];
            String sub2 = elements[2];
            String sub3 = elements[3];

            LocalDate date = LocalDate.now();
            DayOfWeek day = DayOfWeek.from(date);

            int val = day.getValue();

            //Routine obj = new Routine();

            if (val == dayToday) {
                ara[0] = elements[1];
                ara[1] = elements[2];
                ara[2] = elements[3];
            }
        }
    }
}
