package sample;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ClearFile {

    public static void clearTheFile() throws IOException
    {
        FileWriter fwOb = new FileWriter("src\\TimeDurations.txt", false);
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
    }

}
