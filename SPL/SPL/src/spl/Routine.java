/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spl;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class Routine {
    
    public static ArrayList<SubjectArrayList> alist = new ArrayList<>();
    String[] str = new String[6];
    public static double time;
    
    
    public void setRoutineProg(double[] CGs)
    {
        double cg = (.4*CGs[0]) + (.2*CGs[1]) + (.4*CGs[2]);
        SubjectArrayList ob = new SubjectArrayList("Structured Programming", (cg*20), 10);
        alist.add(ob);
        double t1 = (ob.getTime()/180)*60;
        double c1 = (ob.getChapter())/180;
        str[0] = "\nStudy " + ob.getSubName() + " for " + t1 + " minutes.\nComplete " + (c1*100) + " % of a chapter.\nTime: From: " + time + " To: " + (time = time + (t1/60)) + "\n"; 
        //JOptionPane.showMessageDialog(null, str[0]);
    }
    
    public void setRoutineStat(double[] CGs)
    {
        double cg = (.4*CGs[0]) + (.4*CGs[1]) + (.2*CGs[2]);
        SubjectArrayList ob = new SubjectArrayList("Probability And Statistics", (cg*18), 8);
        alist.add(ob);
        double t2 = (ob.getTime()/180)*60;
        double c2 = (ob.getChapter())/180;
        str[1] = "\nStudy " + ob.getSubName() + " for " + t2 + " minutes.\nComplete " + (c2*100) + " % of a chapter.\nTime: From: " + time + " To: " + (time=time+(t2/60)) + "\n"; 
        //JOptionPane.showMessageDialog(null, str[1]);
    }
    
    public void setRoutineMath(double[] CGs)
    {
        double cg = (.4*CGs[0]) + (.4*CGs[1]) + (.2*CGs[2]);
        SubjectArrayList ob = new SubjectArrayList("Calculus", (cg*17), 12);
        alist.add(ob);
        double t3 = (ob.getTime()/180)*60;
        double c3 = (ob.getChapter())/180;
        str[2] = "\nStudy " + ob.getSubName() + " for " + t3 + " minutes.\nComplete " + (c3*100) + " % of a chapter.\nTime: From: " + time + " To: " + (time=time+(t3/60)) + "\n"; 
        //JOptionPane.showMessageDialog(null, str[2]);
    }
    
    public void setRoutineSocio(double[] CGs)
    {
        double cg = (.5*CGs[0]) + (.4*CGs[1]) + (.1*CGs[2]);
        SubjectArrayList ob = new SubjectArrayList("Sociology", (cg*15), 10);
        alist.add(ob);
        double t4 = (ob.getTime()/180)*60;
        double c4 = (ob.getChapter())/180;
        str[3] = "\nStudy " + ob.getSubName() + " for " + t4 + " minutes.\nComplete " + (c4*100) + " % of a chapter.\nTime: From: " + time + " To: " + (time=time+(t4/60)) + "\n"; 
        //JOptionPane.showMessageDialog(null, str[3]);
    }
    
    public void setRoutineDiscrete(double[] CGs)
    {
        double cg = (.4*CGs[0]) + (.35*CGs[1]) + (.25*CGs[2]);
        SubjectArrayList ob = new SubjectArrayList("Discrete Mathematics", (cg*15), 10);
        alist.add(ob);
        double t5 = (ob.getTime()/180)*60;
        double c5 = (ob.getChapter())/180;
        str[4] = "\nStudy " + ob.getSubName() + " for " + t5 + " minutes.\nComplete " + (c5*100) + " % of a chapter.\nTime: From: " + time + " To: " + (time=time+(t5/60)) + "\n"; 
        //JOptionPane.showMessageDialog(null, str[3]);
    }
    
    public void setRoutineSoftware(double[] CGs)
    {
        double cg = (.4*CGs[0]) + (.45*CGs[1]) + (.15*CGs[2]);
        SubjectArrayList ob = new SubjectArrayList("Discrete Mathematics", (cg*15), 10);
        alist.add(ob);
        double t6 = (ob.getTime()/180)*60;
        double c6 = (ob.getChapter())/180;
        str[5] = "\nStudy " + ob.getSubName() + " for " + t6 + " minutes.\nComplete " + (c6*100) + " % of a chapter.\nTime: From: " + time + " To: " + (time = time+(t6/60)) + "\n"; 
        //JOptionPane.showMessageDialog(null, str[3]);
    }
    
    public void randomRoutine()
    {
        int val = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter how many subjects you want to study daily: "));
        
        Random rand = new Random();
        rand.nextInt(val);
        
        for(int i=0;i<val;i++)
        {
            if(i==val)
                continue;
            else
                System.out.print("\nObjective: 0" + (i+1) + str[i]+"\n\n");
        }
    }
    
    public void setStudyTime()
    {
        double ti = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter your preferable time to study: \n|1| = Morning\n|2| = Afternoon\n|3| = Evening\n|4| = Night\n"));
        if(ti==1)
            time = 10;
        if(ti==2)
            time = 15;
        if(ti==3)
            time = 18;
        if(ti==4)
            time = 20;
    }
    
    public boolean studyHoliday()
    {
        int ans = Integer.parseInt(JOptionPane.showInputDialog(null,"Do you want to study in holidays?\n\n|1| = YES\n|2| = NO "));
        if(ans==2)
        {
            boolean value = checkHoliday();
            return value;
        }
        else
        {
            return true;
        }
    }
    
    public boolean checkHoliday()
    {
        LocalDate date = LocalDate.now();
        DayOfWeek day = DayOfWeek.of(date.get(ChronoField.DAY_OF_WEEK));
        switch (day) 
        {
            case FRIDAY:
                System.out.println("\n\nToday is holiday.\n\n");
                return false;
            case SATURDAY:
                System.out.println("\nToday is holiday\n");
                return false;
            default:
                JOptionPane.showMessageDialog(null, "\nToday is " + day + "\nNOT A HOLIDAY\nSO YOU HAVE TO STUDY\n");
                return true;
        }
    
    }
}
