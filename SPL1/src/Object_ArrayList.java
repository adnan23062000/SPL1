
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
public class Object_ArrayList {
    
    private String name;
    private double analytical, qualitative;
    
    public Object_ArrayList(String name, double analytical, double qualitative)
    {
        this.name = name;
        this.analytical = analytical;
        this.qualitative = qualitative;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public double getAnalytical()
    {
        return this.analytical;
    }
    
    public void setAnalytical(double analytical)
    {
        this.analytical = analytical;
    }
    
    public double getQualitative()
    {
        return this.qualitative;
    }
    
    public void setQualitative(double qualitative)
    {
        this.qualitative = qualitative;
    }   
}
