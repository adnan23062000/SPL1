package sample;

import java.io.FileNotFoundException;

public class TimeSet {

    public double TimePeriod(int n, double cg) throws FileNotFoundException {

        File_Operations ob = new File_Operations();
        ob.File_Subjects();

        LinearRegression obj = new LinearRegression();

        if(n==2)
            obj.xyMethod(2);
        if(n==3)
            obj.xyMethod(3);
        if(n==4)
            obj.xyMethod(4);
        if(n==5)
            obj.xyMethod(5);
        if(n==6)
            obj.xyMethod(6);
        if(n==7)
            obj.xyMethod(7);

        obj.setMeanXY();
        obj.summationXY();
        obj.AlphaBetaCalc();

        //System.out.println(obj.showEquation());

        //System.out.println(cg);
        double x = obj.TimeCalc(cg);

        return (x);
    }
}

