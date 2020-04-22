package sample;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class MultipleRegression {

    File_Operations obj2 = new File_Operations();
    public double sum = 0;
    public double[][] array = new double[4][1];

    public void multiRegression() throws FileNotFoundException {
        //File_Operations obj2 = new File_Operations();
        //obj2.File_Subjects();

        List<Double> math = new ArrayList<>();
        List<Double> physics = new ArrayList<>();
        List<Double> ict = new ArrayList<>();
        List<Double> CG = new ArrayList<>();

        double[][] x = new double[obj2.list.size()][4];
        double[][] y = new double[obj2.list.size()][1];

        for (int i = 0, j = 0; i < obj2.list.size(); i++) {
            x[i][0] = 1;
        }

        obj2.list.forEach(user -> {
            math.add(user.getMath());
            physics.add(user.getPhysics());
            ict.add(user.getIct());
            CG.add(user.getGPA());
        });

        for (int i = 0; i < obj2.list.size(); i++) {
            x[i][1] = math.get(i);
        }

        for (int i = 0; i < obj2.list.size(); i++) {
            x[i][2] = physics.get(i);
        }

        for (int i = 0; i < obj2.list.size(); i++) {
            x[i][3] = ict.get(i);
        }

        for (int i = 0; i < obj2.list.size(); i++) {
            y[i][0] = CG.get(i);
        }

        for (int i = 0; i < obj2.list.size(); i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(x[i][j] + " ");
            }
            System.out.print("\n");
        }

        Matrix(x, y, obj2.list.size());

    }

    public void Matrix(double[][] ara, double[][] y, int size) {
        double[][] transpose = new double[4][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 4; j++) {
                transpose[j][i] = ara[i][j];
            }
        }
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < size; i++) {
                System.out.print(transpose[j][i] + " ");
            }
            System.out.print("\n");
        }

        Multiply1(ara, transpose, y, 4, 4, 3);

    }

    public void Multiply1(double[][] first, double[][] second, double[][] y, int row, int column, int row_2) {

        double m1[][] = Multiply(second, first, row, column, row_2);
        double m2[][] = inverse(m1, row, column);
        double m3[][] = Multiply(m2, second, row, 3, column);
        double finalMatrix[][] = Multiply(m3, y, 4, 1, 3);

        array = finalMatrix;

    }

    public double[][] Multiply(double[][] first, double[][] second, int row, int column, int row_2) {
        double[][] multiply = new double[row][column];

        for (int c = 0; c < row; c++) {
            for (int d = 0; d < column; d++) {
                for (int k = 0; k < row_2; k++)
                    sum = sum + first[c][k] * second[k][d];

                multiply[c][d] = sum;
                sum = 0;

            }
        }

        System.out.print("\n\n");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++)
                System.out.print(multiply[i][j] + " ");

            System.out.print("\n");
        }

        return multiply;
    }

    public static double[][] inverse(double[][] a, int row, int column) {

        double d[][] = invert(a);

        //double mulY[][] = Multiply1(d, , row, 1, 4);

        System.out.println("The inverse is: ");
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                System.out.print(d[i][j] + "  ");
            }
            System.out.println();
        }

        return d;
    }

    public static double[][] invert(double a[][])
    {
        int n = a.length;
        double x[][] = new double[n][n];
        double b[][] = new double[n][n];
        int index[] = new int[n];
        for (int i=0; i<n; ++i)
            b[i][i] = 1;

        // Transform the matrix into an upper triangle
        gaussian(a, index);

        // Update the matrix b[i][j] with the ratios stored
        for (int i=0; i<n-1; ++i)
            for (int j=i+1; j<n; ++j)
                for (int k=0; k<n; ++k)
                    b[index[j]][k]
                            -= a[index[j]][i]*b[index[i]][k];

        // Perform backward substitutions
        for (int i=0; i<n; ++i)
        {
            x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
            for (int j=n-2; j>=0; --j)
            {
                x[j][i] = b[index[j]][i];
                for (int k=j+1; k<n; ++k)
                {
                    x[j][i] -= a[index[j]][k]*x[k][i];
                }
                x[j][i] /= a[index[j]][j];
            }
        }
        return x;
    }

    public static void gaussian(double a[][], int index[])
    {
        int n = index.length;
        double c[] = new double[n];

        // Initialize the index
        for (int i=0; i<n; ++i)
            index[i] = i;

        // Find the rescaling factors, one from each row
        for (int i=0; i<n; ++i)
        {
            double c1 = 0;
            for (int j=0; j<n; ++j)
            {
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }

        // Search the pivoting element from each column
        int k = 0;
        for (int j=0; j<n-1; ++j)
        {
            double pi1 = 0;
            for (int i=j; i<n; ++i)
            {
                double pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1)
                {
                    pi1 = pi0;
                    k = i;
                }
            }

            // Interchange rows according to the pivoting order
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i=j+1; i<n; ++i)
            {
                double pj = a[index[i]][j]/a[index[j]][j];

                // Record pivoting ratios below the diagonal
                a[index[i]][j] = pj;

                // Modify other elements accordingly
                for (int l=j+1; l<n; ++l)
                    a[index[i]][l] -= pj*a[index[j]][l];
            }
        }
    }

    public String showEqn()
    {
        return " Y = " + array[0][0] + " + " + array[1][0] + " X1  +  " + array[2][0] + " X2  +  " + array[3][0] + " X3\n\n";
    }

    public double CGCalc2(double math, double physics, double ict)
    {
        double x = ((this.array[0][0])+(this.array[1][0]*math)+(this.array[2][0]*physics)+(this.array[3][0]*ict));
        if(x>4)
            return 4;
        else
            return x;
    }

}
