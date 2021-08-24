package sample;

import java.io.File;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dynamic3 {

    private String[] subjects = {"Introduction to Structured Programming", "Discrete Mathematics", "Calculus and Analytical Geometry", "Probability and Statistics", "Sociology", "Introduction to Software Engineering"};
    private Map<String, Boolean> subMap = new HashMap<>();

    public void DailyRoutineCheck() throws IOException
    {
        for (int i=0;i<6;i++)
        {
            subMap.put(subjects[i], false);
        }

        LocalDate date = LocalDate.now();
        DayOfWeek day = DayOfWeek.from(date);
        int val = day.getValue();

        File file = new File("src\\classRoutine.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine())
        {
            String[] elements = scanner.nextLine().split("->", 0);
            int dayToday = Integer.parseInt(elements[0]);

            if(val==dayToday)
            {
                for(int i=1;i<=3;i++)
                {
                    
                }
            }

        }

    }




}
