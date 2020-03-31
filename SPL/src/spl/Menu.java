/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spl;

import java.io.FileNotFoundException;

/**
 *
 * @author Asus
 */
public class Menu {
    
    public void LRegression() throws FileNotFoundException
    {
        LinearRegression obj = new LinearRegression();
        
        obj.xyMethod();
        
        obj.setMeanXY();
        
        obj.summationXY();
        obj.AlphaBetaCalc();
        
        obj.getMeanX();
        obj.getMeanY();
        
        obj.getAlpha();
        obj.getBeta();
        
        obj.showEquation();
    }
    
    public void MRegression() throws FileNotFoundException
    {
        MultipleRegression obj = new MultipleRegression();
        obj.multiRegression();
        
        obj.showEqn();
        
    }
    
    public void UserInput()
    {
        Input obj = new Input();
        
    }
}
