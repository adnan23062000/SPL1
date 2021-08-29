package sample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PreferableTime {

    private String PrefTime;

    public void WritePrefTime(String val) throws IOException
    {
        File file = new File("src\\PrefTime.txt");

        FileWriter writer = new FileWriter(file);
        PrintWriter pw = new PrintWriter(writer);
        pw.println(val);
        pw.close();
    }

    public String ReadPrefTime() throws IOException
    {
        File file = new File("src\\PrefTime.txt");
        Scanner scanner = new Scanner(file);

        while(scanner.hasNextLine()){

            String[] elements=scanner.nextLine().split(" ",0);
            PrefTime = elements[0];
        }

        return PrefTime;

    }


}
