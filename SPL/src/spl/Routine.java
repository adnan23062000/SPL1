/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spl;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class Routine {
    
    public static ArrayList<SubjectArrayList> alist = new ArrayList<>();
    String[] str = new String[4];
    
    
    public void setRoutineProg(double[] CGs)
    {
        double cg = (.4*CGs[0]) + (.2*CGs[1]) + (.4*CGs[2]);
        SubjectArrayList ob = new SubjectArrayList("Structured Programming", (cg*20), 10);
        alist.add(ob);
        double t1 = (ob.getTime()/180)*60;
        double c1 = (ob.getChapter())/180;
        str[0] = "\nObjective-01:\nStudy " + ob.getSubName() + " for " + t1 + " minutes.\nComplete " + (c1*100) + " % of a chapter."; 
        //JOptionPane.showMessageDialog(null, str[0]);
    }
    
    public void setRoutineStat(double[] CGs)
    {
        double cg = (.4*CGs[0]) + (.4*CGs[1]) + (.2*CGs[2]);
        SubjectArrayList ob = new SubjectArrayList("Probability And Statistics", (cg*18), 8);
        alist.add(ob);
        double t2 = (ob.getTime()/180)*60;
        double c2 = (ob.getChapter())/180;
        str[1] = "\nObjective-02:\nStudy " + ob.getSubName() + " for " + t2 + " minutes.\nComplete " + (c2*100) + " % of a chapter."; 
        //JOptionPane.showMessageDialog(null, str[1]);
    }
    
    public void setRoutineMath(double[] CGs)
    {
        double cg = (.4*CGs[0]) + (.4*CGs[1]) + (.2*CGs[2]);
        SubjectArrayList ob = new SubjectArrayList("Calculus", (cg*17), 12);
        alist.add(ob);
        double t3 = (ob.getTime()/180)*60;
        double c3 = (ob.getChapter())/180;
        str[2] = "\nObjective-03:\nStudy " + ob.getSubName() + " for " + t3 + " minutes.\nComplete " + (c3*100) + " % of a chapter."; 
        //JOptionPane.showMessageDialog(null, str[2]);
    }
    
    public void setRoutineSocio(double[] CGs)
    {
        double cg = (.5*CGs[0]) + (.4*CGs[1]) + (.1*CGs[2]);
        SubjectArrayList ob = new SubjectArrayList("Sociology", (cg*15), 10);
        alist.add(ob);
        double t4 = (ob.getTime()/180)*60;
        double c4 = (ob.getChapter())/180;
        str[3] = "\nObjective-04:\nStudy " + ob.getSubName() + " for " + t4 + " minutes.\nComplete " + (c4*100) + " % of a chapter."; 
        //JOptionPane.showMessageDialog(null, str[3]);
    }
    
    public void randomRoutine()
    {
        Random rand = new Random();
        int no;
        no = rand.nextInt(4);
        
        for(int i=0;i<4;i++)
        {
            if(i==no)
                continue;
            else
                System.out.print(str[i]+"\n\n");
        }
    }
    
}
