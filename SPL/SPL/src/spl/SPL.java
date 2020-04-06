
package spl;

import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class SPL {

    
    public static void main(String[] args) throws FileNotFoundException {
        
        {
            
            File_Operations ob = new File_Operations();
            ob.File_Subjects();
            
            System.out.print("Enter your choice:\n\n|1| = See the Linear Regression\n|2| = See the multiple Line regression\n|3| = Provide user input\n|4| = See estimated Grade Point\n\nEnter your choice: ");
        
            Menu obj1 = new Menu();
        
            Scanner input = new Scanner(System.in);
            int userInput = input.nextInt();
            if(userInput==1)
            {
                obj1.LRegression();
            }
            else if(userInput==2)
            {
                obj1.MRegression();
            }
            else if(userInput==3)
            {
                obj1.UserInput();
            }
        
        }
    
    }
}
