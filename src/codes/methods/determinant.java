package codes.methods;

import codes.ADT.Matrix;
import codes.ADT.primitives.GetCofactor;
import codes.ADT.primitives.TimesDiagonal;


public class determinant {
    public static double detCofactor(Matrix m, int n, boolean isSquare) {
        // Get determinant using cofactor method
        if (isSquare) {
            double result = 0;
            // Base recursion
            if (n == 1)
                return m.Mtrx[0][0];

            Matrix temp = new Matrix(m.rows, m.cols); // store cofactors

            float sign = 1; // -1 multiplier
            // Get cofactor
            for (int permitted_col = 0; permitted_col < n; permitted_col++) {
                // Get cofactor for every cols
                GetCofactor.getCofactor(m, temp, 0, permitted_col, n);

                // Determinant recursion
                result += sign * m.Mtrx[0][permitted_col] * detCofactor(temp, n - 1, true);

                // alternating sign for determinant
                sign = -sign;
            }
            return result;
        } else {
            return -9999;
        }
    }

    public static double detGauss(Matrix m, boolean isSquare) {
        // Init new matrix
        Matrix detGaussMtrx = new Matrix(m.rows, m.cols);
        // Store m to new matrix
        detGaussMtrx = Gauss.gauss(m);
        int sign = (m.sign % 2) == 0 ? 1 : -1;
        // Get the times diagonal of echelon row matrix
        double result = sign * TimesDiagonal.timesDiagonal(detGaussMtrx, isSquare);
        if ((Math.round(result*100) / 100) == -0.0){
            return 0.0;
        }
        else {
            return result;
        }
    }

    // This still not fixed
    public static double detGaussJordan(Matrix m, boolean isSquare) {
        // Init new matrix
        Matrix detGaussMtrx = new Matrix(m.rows, m.cols);
        // Store m to new matrix
        detGaussMtrx = GaussJordan.jordan(m);
        // Get the times diagonal of reduced echelon row matrix
        double result = TimesDiagonal.timesDiagonal(detGaussMtrx, isSquare);
        if ((Math.round(result*100) / 100) == -0.0){
            return 0.0;
        }
        else {
            return result;
        }
    }
}
