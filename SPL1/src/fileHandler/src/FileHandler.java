import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        File file = new File("D:\\newfolder\\file.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<objectList> list = new ArrayList<>();
        
        
        while(scanner.hasNextLine()){
            String[] elements=scanner.nextLine().split(" ",0);
            String name=elements[0];
            double math=Double.parseDouble(elements[1]);
            double phy=Double.parseDouble(elements[2]);
            double ict=Double.parseDouble(elements[3]);
            objectList ob = new objectList(name,math,phy,ict);
            
            list.add(ob);
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*String line1 = scanner.nextLine();//line 1 = "Fahim 80 82 85"
        String[] line1Split = line1.split(" ",0);// {"Fahim","80","82","85"}
        int[] marks1 = new int[3];
        for(int i = 0; i<3;i++)
            marks1[i] = Integer.parseInt(line1Split[i+1]);
       
        System.out.println(line1Split[0]+" "+marks1[0]+" "+marks1[1]+" "+marks1[2]);
       
        String line2 = scanner.nextLine();
        String[] line2Split = line2.split(" ",0);
        int[] marks2 = new int[3];
        for(int i = 0; i<3;i++)
            marks2[i] = Integer.parseInt(line2Split[i+1]);
       
        System.out.println(line2Split[0]+" "+marks2[0]+" "+marks2[1]+" "+marks2[2]);
       
        String line3 = scanner.nextLine();
        String[] line3Split = line3.split(" ",0);
        int[] marks3 = new int[3];
        for(int i = 0; i<3;i++)
            marks3[i] = Integer.parseInt(line3Split[i+1]);
       
        System.out.println(line3Split[0]+" "+marks3[0]+" "+marks3[1]+" "+marks3[2]);
       
       */
       
    }
   
}  
