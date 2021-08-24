package sample;

import java.io.*;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dynamic2 {

    private double days;
    private double cg;
    private double value;
    private String[] subjects = {"Introduction to Structured Programming", "Discrete Mathematics", "Calculus and Analytical Geometry", "Probability and Statistics", "Sociology", "Introduction to Software Engineering"};
    private Map<String, Double> subMap = new HashMap<>();

    public void WriteTimeToFile() throws ParseException, FileNotFoundException, IOException
    {
        Dynamic1 obj = new Dynamic1();
        try {
            days = obj.TimeDuration();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        File file = new File("src\\CG.txt");
        Scanner scanner = new Scanner(file);

        while(scanner.hasNextLine()){
            String[] elements=scanner.nextLine().split(" ",0);
            cg = Double.parseDouble(elements[0]);
        }

        System.out.println(cg);


        for(int i=2;i<=7;i++) {

            TimeSet time = new TimeSet();
            value = time.TimePeriod(i, cg);

            File file2 = new File("src\\TimeDurations.txt");

            FileWriter writer = new FileWriter(file2, true);
            PrintWriter pw = new PrintWriter(writer);
            pw.println(value);
            pw.close();
        }

    }

    public Map<String, Double> ReadTimeFromFile() throws IOException, FileNotFoundException
    {
        File file = new File("src\\TimeDurations.txt");
        Scanner scanner = new Scanner(file);

        int i=0;

        while(scanner.hasNextLine())
        {
            String[] elements = scanner.nextLine().split(" ", 0);
            double number = Double.parseDouble(elements[0]);
            subMap.put(subjects[i], number);
            i++;
        }

        return subMap;

        /*for (Map.Entry<String, Double> entry : subMap.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());*/
    }


}
