package sample;

import java.io.*;

public class Dynamic1 {

    public double dayss;

    public void TimeDuration() throws IOException {

        RemainingDays SemesterDays = new RemainingDays();

        try {
            dayss = SemesterDays.DateConvertString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        File file = new File("src\\TimeDurations.txt");

        FileWriter writer = new FileWriter(file, false);
        PrintWriter pw = new PrintWriter(writer);
        pw.println(dayss);
        pw.close();

    }

}
