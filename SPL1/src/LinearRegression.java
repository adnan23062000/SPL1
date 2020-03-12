/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
public class LinearRegression {
    
    double x[] = new double[]{6, 10, 7, 1.5, 5};
    double y[] = new double[]{3.75, 3.96, 3.8, 3.5, 3.84};
    
    public double alpha, beta;
    public double sumX=0,sumXS=0, sumY=0,sumXY=0, meanX, meanY;
    
    public double getMeanX()
    {
        System.out.println("mean of x: " + meanX);
        return this.meanX;
    }
    
    public double getMeanY()
    {
        System.out.println("mean of y: " + meanY + "    " + sumXS);
        return this.meanY;
    }
    
    public void setMeanXY()
    {
        for(double i : x){
            sumX+=i;
            sumXS+=i*i;
        }
        
        meanX = sumX/5;
        
        for(double i : y){
            sumY+=i;
        }
        
        meanY = sumY/5;
        
    }
    
    public void summationXY()
    {
        for(int i=0;i<5;i++)
        {
            sumXY = sumXY + (x[i]*y[i]);
        }
        System.out.println("SumXY: "+sumXY);
    }
    
    public void AlphaBetaCalc()
    {
        double b1, b2;
        b1 = sumXY - ((sumX*sumY)/5);
        b2 = sumXS - ((Math.pow(sumX, 2))/5);
        
        //2System.out.println("B1: "+b1+"     B2: "+b2 + "    aaaa: " + (sumX*sumY)/5);
        
        beta = b1/b2;  
        
        alpha = ((sumY)/5) - (beta*(sumX)*(1/5));
        
    }
    
    public double getAlpha()
    {
        System.out.println("alpha: " + alpha);
        return this.alpha;
    }
    
    public double getBeta()
    {
        System.out.println("beta: " + beta + "\n\n");
        return this.beta;
    }
    
    public void showEquation()
    {
        System.out.println("The equation is: Y = " + beta + "X " + "+ " + alpha);
    }
    
    public double CGCalc(double studyHour)
    {
        return ((this.beta)*studyHour) + alpha;
    }
       
}
