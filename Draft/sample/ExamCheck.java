package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExamCheck {

    private String str;

    public boolean IsExam(String s) throws FileNotFoundException
    {
        File file = new File("src\\exam.txt");
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){

            String[] elements=scanner.nextLine().split("->",0);
            String name=elements[0];
            String date2=elements[1];
            boolean x = s.equals(date2);
            if(x==true)
            {
                str = name;
                return true;
            }

        }

        return false;

    }

    public String ExamName()
    {
        return this.str;
    }

}
