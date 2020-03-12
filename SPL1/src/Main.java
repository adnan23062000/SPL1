/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author Asus
 */
public class Main {
    
    public static void main(String[] args) {
        
        LinearRegression obj = new LinearRegression();
        obj.setMeanXY();
        double meanX = obj.getMeanX();
        double meanY = obj.getMeanY();
        
        obj.summationXY();
        obj.AlphaBetaCalc();
        
        double alpha = obj.getAlpha();
        double beta = obj.getBeta();
        
        obj.showEquation();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your study hour: ");
        double cg = obj.CGCalc(input.nextDouble());
        if(cg>4)
            cg = 4;
        
        System.out.println("Your Estimated CGPA is: " + cg);
    
}
}
