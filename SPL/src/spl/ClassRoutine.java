/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spl;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class ClassRoutine {
    
    public void RoutineAccordingToClass(double[] CGs) throws FileNotFoundException
    {
        File file = new File("D:\\newfolder\\classRoutine.txt");
            Scanner scanner = new Scanner(file);
            
            while(scanner.hasNextLine()){
            
                String[] elements=scanner.nextLine().split("->",0);
                int dayToday = Integer.parseInt(elements[0]);
                String sub1 = elements[1];
                String sub2 = elements[2];
                String sub3 = elements[3];
                
                LocalDate date = LocalDate.now();
                DayOfWeek day = DayOfWeek.from(date);
        
                int val = day.getValue(); 
                
                Routine obj = new Routine();
                
                if(val==dayToday)
                {
                    for(int i=1;i<4;i++)
                    {
                        if(elements[i].equals("null"))
                        {
                            continue;
                        }
                        if(elements[i].equals("Structured Programming"))
                        {
                            obj.setRoutineProg(CGs);
                        }
                        if(elements[i].equals("Discrete Mathematics"))
                        {
                            obj.setRoutineDiscrete(CGs);
                        }
                        if(elements[i].equals("Calculus And Analytical Geometry"))
                        {
                            obj.setRoutineMath(CGs);
                        }
                        if(elements[i].equals("Sociology"))
                        {
                            obj.setRoutineSocio(CGs);
                        }
                        if(elements[i].equals("Introduction To Software Engineering"))
                        {
                            obj.setRoutineSoftware(CGs);
                        }
                        if(elements[i].equals("Probability And Statistics"))
                        {
                            obj.setRoutineStat(CGs);
                        }
                        
                    }
                }
                
            }
    }
}
