package sample;

import java.io.*;

public class Dynamic1 {

    public double dayss;

    public double TimeDuration() throws IOException {

        RemainingDays SemesterDays = new RemainingDays();

        try {
            dayss = SemesterDays.DateConvertString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return this.dayss;

    }

}
