/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spl;

/**
 *
 * @author Asus
 */
public class SubjectArrayList {
    
    public String subName;
    public double time;
    public double chapter;
    
    public SubjectArrayList(String subName, double time, double chapter)
    {
        this.subName = subName;
        this.chapter = chapter;
        this.time = time;
    }
    
    public String getSubName() {
        return subName;
    }

    public void setSubName(String name) {
        this.subName = name;
    }
    
    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
    
    public double getChapter() {
        return chapter;
    }

    public void setChapter(double chapter) {
        this.chapter = chapter;
    }
    
}
