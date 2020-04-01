
package spl;

import java.io.FileNotFoundException;


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
    
    public void UserInput() throws FileNotFoundException
    {
        Input obj = new Input();
        obj.Input1();
    }
}
