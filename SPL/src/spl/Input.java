/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spl;

//import static java.lang.Double.parseDouble;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import javax.swing.JOptionPane;
import java.lang.*;

/**
 *
 * @author Asus
 */
public class Input {
    
    public double studyHr, math, physics, ict, iq, wMean, expectation;
    public static double[] CGs = new double[3];
    public double[] value = new double[3];
    
    public void Input1() throws FileNotFoundException
    {
        
        studyHr = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter Your Study Hour: "));
        
        LinearRegression obj1 = new LinearRegression();
        
        obj1.xyMethod();
        
        obj1.setMeanXY();
        
        obj1.summationXY();
        obj1.AlphaBetaCalc();
        CGs[0] = obj1.CGCalc(studyHr);
        
        JOptionPane.showMessageDialog(null, CGs[0]);
        
        math = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter Your HSC marks in Math: "));
        physics = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter Your HSC marks in Physics: "));
        ict = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter Your HSC marks in ICT: "));
        
        MultipleRegression obj2 = new MultipleRegression();
        obj2.multiRegression();
        
        CGs[1] = obj2.CGCalc2(math, physics, ict);
        JOptionPane.showMessageDialog(null, CGs[1]);
        
        double pp = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter Your IQ: \n|1| = 120\n|2| = 140\n|3| = 150"));
        if(pp==1)
        {
            iq = 120;
            CGs[2] = 3.5;
        }
        if(pp==2){
            iq = 140;
            CGs[2] = 3.75;
        }
        if(pp==3)
        {
            iq = 150;
            CGs[2] = 4;
        }
        
        JOptionPane.showMessageDialog(null, CGs[2]);
        
        wMean = (.5*CGs[0]) + (.4*CGs[1]) + (.1*CGs[2]);
        JOptionPane.showMessageDialog(null, "Your Predicted CGPA is: " + wMean); 
        
        expectation = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter Your Expected CGPA: "));
        
        double a = wMean - expectation;
        double x = Math.abs(a);
        
        if(x>.2)
            JOptionPane.showMessageDialog(null, "The difference is significant");
        else
            JOptionPane.showMessageDialog(null, "The difference is not significant");
        
        
        Routine object = new Routine();
        
        object.setStudyTime();
        
        /*object.setRoutineProg(CGs);
        object.setRoutineMath(CGs);
        object.setRoutineStat(CGs);
        object.setRoutineSocio(CGs);
        object.setRoutineDiscrete(CGs);
        object.setRoutineSoftware(CGs);*/
        
        boolean val = object.studyHoliday();
        if(val)
        {
            HolidayCheck objj = new HolidayCheck();
            boolean xx = objj.IsHoliday();
            if(xx==false)
            {
                ClassRoutine object2 = new ClassRoutine();
                object2.RoutineAccordingToClass(CGs);
            }
            
        }
        else
        {
            JOptionPane.showMessageDialog(null,"\nAS YOU DON'T STUDY IN WEEKENDS\nRELAX AND HAVE A NICE DAY\n");
        }
    }
    
}
