
package spl;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;
import static spl.File_Operations.list;


public class HolidayCheck {
    
    public boolean IsHoliday() throws FileNotFoundException
    {
        File file = new File("D:\\newfolder\\holiday.txt");
        Scanner scanner = new Scanner(file);
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        System.out.println(date);    
        while(scanner.hasNextLine()){
            
                String[] elements=scanner.nextLine().split("->",0);
                String name=elements[0];
                String date2=elements[1];
                System.out.println(date2);
                boolean x = date.equals(date2);
                if(x==true)
                {
                    double ans = Double.parseDouble(JOptionPane.showInputDialog(null, "Today is " + name + "\nIt is a National Holiday\nDo you want to study?\n\n|1| = YES\n|2| = NO\n"));
                    if(ans==1)
                        return false;
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Take Rest\nHave a nice day\n");
                        return true;
                    }
                    
                }
                 
        }
        
        return false;
        
    }
}
