package sample;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class LinearRegression {

    List<Double> x = new ArrayList<>();
    List<Double> y = new ArrayList<>();

    File_Operations objj = new File_Operations();

    public double a, b;

    public void xyMethod(int val) throws FileNotFoundException
    {
        if(val==1)
        {
            objj.list.forEach(user -> {
                a = user.getStudyHour();
                b = user.getGPA();
                x.add(a);
                y.add(b);
            });
        }
        if(val==2)
        {
            objj.list.forEach(user -> {
                a = user.getCSE101();
                b = user.getGPA();
                x.add(b);
                y.add(a);
            });
        }
        if(val==3)
        {
            objj.list.forEach(user -> {
                a = user.getDiscrete();
                b = user.getGPA();
                x.add(b);
                y.add(a);
            });
        }
        if(val==4)
        {
            objj.list.forEach(user -> {
                a = user.getCalculus();
                b = user.getGPA();
                x.add(b);
                y.add(a);
            });
        }
        if(val==5)
        {
            objj.list.forEach(user -> {
                a = user.getStat();
                b = user.getGPA();
                x.add(b);
                y.add(a);
            });
        }
        if(val==6)
        {
            objj.list.forEach(user -> {
                a = user.getSociology();
                b = user.getGPA();
                x.add(b);
                y.add(a);
            });
        }
        if(val==7)
        {
            objj.list.forEach(user -> {
                a = user.getSe();
                b = user.getGPA();
                x.add(b);
                y.add(a);
            });
        }
    }

    public double alpha, beta;
    public double sumX=0,sumXS=0, sumY=0,sumXY=0, meanX, meanY;

    public double getMeanX()
    {
        //System.out.println("mean of x: " + meanX);
        return this.meanX;
    }

    public double getMeanY()
    {
        //System.out.println("mean of y: " + meanY + "    " + sumXS);
        return this.meanY;
    }

    public void setMeanXY()
    {

        for(int i = 0; i < x.size(); i++)
        {
            sumX+=x.get(i);
            sumXS+=((x.get(i))*(x.get(i)));
        }

        meanX = sumX/x.size();

        for(int i=0;i<y.size();i++){
            sumY+=y.get(i);
        }

        meanY = sumY/y.size();
        //System.out.println(meanX);
        //System.out.println(meanY);

    }

    public void summationXY()
    {
        for(int i=0; i < x.size(); i++)
        {
            sumXY = sumXY + ((x.get(i))*(y.get(i)));
        }
        //System.out.println("SumXY: "+sumXY);
    }

    public void AlphaBetaCalc()
    {
        /*System.out.println("sumXY: " + sumXY);
        System.out.println("sumXS: " + sumXS);
        System.out.println("sumX: " + sumX);
        System.out.println("sumY: " + sumY);
        System.out.println("x size: " + x.size());*/

        double b1, b2;
        b1 = sumXY - ((sumX*sumY)/(x.size()));
        b2 = sumXS - ((Math.pow(sumX, 2))/(x.size()));

        //2System.out.println("B1: "+b1+"     B2: "+b2 + "    aaaa: " + (sumX*sumY)/5);

        beta = b1/b2;

        alpha = ((sumY)/(x.size())) - (beta*(sumX)*(1/(x.size())));

    }

    public double getAlpha()
    {
        //System.out.println("alpha: " + alpha);
        return this.alpha;
    }

    public double getBeta()
    {
        //System.out.println("beta: " + beta + "\n");
        return this.beta;
    }

    public String showEquation()
    {
        DecimalFormat df = new DecimalFormat("#.##");
        return " Y = " + df.format(beta) + "X " + "+ " + df.format(alpha) + "\n";
    }

    public double CGCalc1(double studyHour)
    {
        double x = ((this.beta)*studyHour) + alpha;
        if(x>4)
            return 4;
        else
            return x;
    }

    public String CGCalc(double studyHour)
    {
        double x = ((this.beta)*studyHour) + alpha;
        if(x>4)
            return "     CG: " + 4;
        else
        {
            DecimalFormat df = new DecimalFormat("#.##");
            return "     CG: " + df.format(x);
        }
    }

    public double TimeCalc(double gpa)
    {
        double x = ((this.beta)*gpa) + alpha;
        return x;
    }


}