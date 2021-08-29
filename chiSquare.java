package sample;

import java.util.Random;

public class chiSquare
{
    //stores acceptence of a random number generator using different seeds
    //according to Chi-Square distributions

    private double alpha = 0.01;

    public static boolean[] chi2s(int numClasses, int[] seeds) {
        boolean[] chi2eds = new boolean[seeds.length];
        int[] classes = new int[numClasses];

        //determine if the random number generator with seed k is random enough
        for(int k = 0; k < seeds.length; k++) {
            //random number generator object with seed k
            Random rint = new Random(seeds[k]);

            //initialize classes to 0
            for(int i = 0; i < classes.length; i++) {
                classes[i] = 0;
            }



            //if the classes are equally distributed, then the expected value is the same for each
            //numTrials = expectedValue*numClasses
            int expectedValue = 10;//must be at least 5 in order for the chi-squared test to work
            int numTrials = expectedValue*numClasses;
            for(int i = 0; i < numTrials; i++) {
                //rLong(low, high) --> random integer i, 0 <= low <= i < high
                //want 0 <= i <= high
                //classes[(int)rint.rInteger(1, numClasses+1) - 1]++;
            }

            //squareSum = sum over i of (observed(i)-expected(i))^2
            int squareSum = 0;
            for(int i = 0; i < classes.length; i++) {
                squareSum += chiSquare.power(classes[i]-expectedValue, 2);
            }

            //the Chi-Square value
            double chiSquare = ((double)squareSum)/((double)expectedValue);

            //determine if the random number generator was in an acceptable percentile
            chi2eds[k] = percentile(chiSquare, numClasses);
        }

        return chi2eds;
    }

    //determine if an RNG generating numClasses different numbers
    //is acceptable according to its chi-squared value
    public static boolean chi2(int numClasses) {
        int[] classes = new int[numClasses];
        //random number generator object
        Random rint = new Random();

        //initialize classes to 0
        for(int i = 0; i < classes.length; i++) {
            classes[i] = 0;
        }

        //if the classes are equally distributed, then the expected value is the same for each
        //numTrials = expectedValue*numClasses
        int expectedValue = 10;//must be at least 5 in order for the chi-squared test to work
        int numTrials = expectedValue*numClasses;
        for(int i = 0; i < numTrials; i++) {
            //rLong(low, high) --> random integer i, 0 <= low <= i < high
            //want 0 <= i <= high


            //System.out.println("value " + rint.getValue());
        }

        //squareSum = sum over i of (observed(i)-expected(i))^2
        int squareSum = 0;
        for(int i = 0; i < classes.length; i++) {
            squareSum += Math.pow(classes[i]-expectedValue, 2);

            System.out.println("classes " + i + " = " + classes[i]);
        }

        //the Chi-Square value
        double chiSquare = ((double)squareSum)/((double)expectedValue);

        //determine if the random number generator was in an acceptable percentile
        boolean accept = percentile(chiSquare, numClasses);
        System.out.println(accept);
        return (accept);
    }

    //takes a positive real, a, to a positive integer power, N, with complexity O(lg n)
    private static double power(double a, int N) {
        //invariant product(tempProd^quotient) = a^N
        double product = 1;
        double tempProd = a;
        int quotient = N;

        while (quotient != 0) {
            if (quotient%2 == 1) {
                // product*(tempProd)^Odd = product*tempProd*tempProd^(Odd-1), Odd - 1 is even
                product = product*tempProd;
            }
            //tempProd^Even = (tempProd^2)^Even/2
            tempProd = tempProd*tempProd;
            quotient = quotient/2;
        }

        return product;
    }

    //determines whether a Chi-Square value lies within the 5 and 95 percentile
    //for a given degree of freedom in the Chi-Square Distribution table
    private static boolean percentile(double chiSquare, int numClasses) {
        //cutoff values for the 5(low) and 95(high) percentiles
        double low;
        double high;

        //Chi-Square Distribution table for n classes with n-1 degrees of freedom
        switch(numClasses-1) {
            case 1:
                low = .004;
                high = 3.84;
                break;
            case 5:
                low = 1.15;
                high = 11.1;
                break;
            case 9:
                low = 3.33;
                high = 16.9;
                break;
            case 51:
                low = 34.8;
                high = 67.5;
                break;
            case 99:
                low = 0; //not correct value
                high = 123.23;
                break;
            default:
                low = 0;
                high = 0;
                break;
        }

        System.out.println("low " + low + ", high " + high + ", chi2 " + chiSquare);

        //is the Chi-Square value acceptable
        return(low < chiSquare && chiSquare < high);
    }
}