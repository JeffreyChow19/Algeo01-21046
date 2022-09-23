package codes.ADT.primitives;

import codes.ADT.Matrix;
import codes.ADT.constructors.TimesDiagonal;
import codes.ADT.primitives.*;
import codes.methods.*;

public class determinant {
    public static double detCofactor(Matrix m, int n, boolean isSquare) {
        if (isSquare) {
            double result = 0;
            // Base recursion
            if (n == 1)
                return m.Mtrx[0][0];

            Matrix temp = new Matrix(m.rows, m.cols); // store cofactors

            float sign = 1; // -1 multiplier

            for (int permitted_col = 0; permitted_col < n; permitted_col++) {
                // Menghitung cofactor tiap col
                GetCofactor.getCofactor(m, temp, 0, permitted_col, n);

                // Determinant
                result += sign * m.Mtrx[0][permitted_col] * detCofactor(temp, n - 1, true);

                // alternate sign
                sign = -sign;
            }

            return result;
        } else {
            return -9999;
        }
    }
    
    public static double detGauss (Matrix m, boolean isSquare) 
    { 
        // init new matrix
        Matrix detGaussMtrx = new Matrix(m.rows, m.cols);
        // store m to new matrix
        detGaussMtrx = Gauss.gauss(m);
        // get the times diagonal of echelon row matrix
        double result = TimesDiagonal.timesDiagonal(detGaussMtrx, isSquare);
        return result;
    }

    // public static double detGaussJordan (Matrix m, boolean isSquare) 
    // { 
    //     // init new matrix
    //     Matrix detGaussMtrx = new Matrix(m.rows, m.cols);
    //     // store m to new matrix
    //     detGaussMtrx = Gauss.gauss(m);
    //     // get the times diagonal of echelon row matrix
    //     double result = TimesDiagonal.timesDiagonal(detGaussMtrx, isSquare);
    //     return result;
    // }
}
