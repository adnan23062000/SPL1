package sample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class TimelineFixation {

    public double TimeGetter(String course) throws IOException
    {
        Dynamic2 obj = new Dynamic2();
        Map<String, Double> map = obj.ReadTimeFromFile();

        for (Map.Entry<String, Double> entry : map.entrySet())
        {
            if(entry.getKey().equals(course))
            {
                Dynamic1 objj = new Dynamic1();
                double days = objj.TimeDuration();
                return (entry.getValue())/days;
            }
        }

        return 1.00;
    }


    public void MainTimeChange(String course, double val) throws IOException
    {

        Dynamic2 getObj = new Dynamic2();
        Map<String, Double> map = getObj.ReadTimeFromFile();

        for (Map.Entry<String, Double> entry : map.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());

        //map.put(course, (map.get(course))-val);
        double v1 = (double)map.get(course);
        System.out.println("v1: " + v1);
        double v2 = v1 - val;
        System.out.println("v1 after: " + v2);
        map.put(course, v2);
        System.out.println("map: " + map.get(course));
        //System.out.println("Time after reducing: " + map.get(course));

        ClearFile objj = new ClearFile();
        objj.clearTheFile();

        double[] array = new double[6];

        String[] subjects = {"Introduction to Structured Programming", "Discrete Mathematics", "Calculus and Analytical Geometry", "Probability and Statistics", "Sociology", "Introduction to Software Engineering"};

        for (Map.Entry<String, Double> entry : map.entrySet())
        {
            if(entry.getKey().equals("Introduction to Structured Programming"))
            {
                array[0] = (Double)entry.getValue();
            }
            if(entry.getKey().equals("Discrete Mathematics"))
            {
                array[1] = (Double)entry.getValue();
            }
            if(entry.getKey().equals("Calculus and Analytical Geometry"))
            {
                array[2] = (Double)entry.getValue();
            }
            if(entry.getKey().equals("Calculus and Analytical Geometry"))
            {
                array[3] = (Double)entry.getValue();
            }
            if(entry.getKey().equals("Sociology"))
            {
                array[4] = (Double)entry.getValue();
            }
            if(entry.getKey().equals("Introduction to Software Engineering"))
            {
                array[5] = (Double)entry.getValue();
            }
        }



        for(int j=0;j<6;j++) {

            File file2 = new File("src\\TimeDurations.txt");

            FileWriter writer = new FileWriter(file2, true);
            PrintWriter pw = new PrintWriter(writer);
            pw.println(array[j]);
            pw.close();
        }


    }



}
