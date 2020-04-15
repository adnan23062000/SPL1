/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spl;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.DayOfWeek;
import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class ClassRoutine {
    
    public void RoutineAccordingToClass() throws FileNotFoundException
    {
        File file = new File("D:\\newfolder\\classRoutine.txt");
            Scanner scanner = new Scanner(file);
            
            while(scanner.hasNextLine()){
            
                String[] elements=scanner.nextLine().split("->",0);
                String dayToday = elements[0];
                String sub1 = elements[1];
                String sub2 = elements[2];
                String sub3 = elements[3];
                
            }
    }
}
