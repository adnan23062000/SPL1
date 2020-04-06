
package spl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class File_Operations {

        
        public static ArrayList<ArrayList_Data> list = new ArrayList<>();   
        
        public void File_Subjects()throws FileNotFoundException
        {
            File file = new File("D:\\newfolder\\file.txt");
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
                
                ArrayList_Data ob = new ArrayList_Data(name,math,phy,ict,studyHour,gpa);
            
                list.add(ob);
            }
        
        }
        
}
