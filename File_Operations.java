package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class File_Operations {

    public static ArrayList<Arraylist_Data> list = new ArrayList<>();

    public void File_Subjects() throws FileNotFoundException
    {
        File file = new File("src\\data.txt");
        Scanner scanner = new Scanner(file);

        //ArrayList<ArrayList_Data> list = new ArrayList<>();

        while(scanner.hasNextLine()){

            String[] elements=scanner.nextLine().split(" ",0);
            String name=elements[0];
            double math=Double.parseDouble(elements[1]);
            double phy=Double.parseDouble(elements[2]);
            double ict=Double.parseDouble(elements[3]);
            double studyHour = Double.parseDouble(elements[4]);
            double gpa = Double.parseDouble(elements[5]);
            double cse101 = Double.parseDouble(elements[6]);
            double discrete = Double.parseDouble(elements[7]);
            double calculus = Double.parseDouble(elements[8]);
            double stat = Double.parseDouble(elements[9]);
            double sociology = Double.parseDouble(elements[10]);
            double se = Double.parseDouble(elements[11]);
            Arraylist_Data ob = new Arraylist_Data(name,math,phy,ict,studyHour,gpa,cse101,discrete,calculus,stat,sociology,se);

            list.add(ob);
        }

    }
}

