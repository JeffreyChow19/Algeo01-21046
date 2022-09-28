package codes.methods;

import codes.ADT.*;
import codes.ADT.primitives.CheckNeg0;


public class Gauss{
    public static Matrix gauss(Matrix m) {
        int sign = 0;
        // Switching rows for initial Matrix
        for (int k = 0; k < m.rows; k++){
            for (int h = k; h < m.rows; h++){
                if (count0(m, k, m.cols-1) > count0(m, h, m.cols-1)){
                    switchRows(m, k, h);
                    sign++;
                }
            }
        }
        // Process to echelon row here
        for (int j = 0; j < m.rows; j++) {
            for (int i = j + 1; i < m.rows; i++) {
                // Switch row if current row contains more 0 then next row
                    if (count0(m, j, m.cols-1) > count0(m, j + 1, m.cols-1)) {
                        switchRows(m, j, j + 1);
                        // For -1 power in determinant
                        sign++;
                    }
                double pem = m.Mtrx[i][j];
                double pen = m.Mtrx[j][j];
                double factor;
                if (Double.isInfinite(1/pen)) {
                    factor = 1;
                } else {
                    factor = pem / pen;
                }
                if (Double.isNaN(pem/pen)){
                    factor = m.Mtrx[i][j+1] / m.Mtrx[j][j+1];
                }
                for (int k = 0; k < m.cols; k++) {
                    m.Mtrx[i][k] -= ((factor) * m.Mtrx[j][k]);
                }
            }
        }
        m.sign = sign;
        Matrix gaussed_mtrx = new Matrix(m.rows, m.cols);
        gaussed_mtrx = CheckNeg0.check(m);
        return gaussed_mtrx;
    }
    public static int count0(Matrix m, int row, int limit) {
        int count = 0;
        for (int j = 0; j <= limit; j++) {
            if (Double.isNaN(1.0 / m.Mtrx[row][j]) || Double.isInfinite(1.0 / m.Mtrx[row][j])) {
                count++;
            }
        }
        return count;
    }

    public static void switchRows(Matrix m, int row1, int row2) {
        double[] swap = new double[m.cols];

        for (int i = 0; i < m.cols; i++) {
            swap[i] = m.Mtrx[row2][i];
        }
        for (int j = 0; j < m.cols; j++) {
            m.Mtrx[row2][j] = m.Mtrx[row1][j];
            m.Mtrx[row1][j] = swap[j];
        }
    }
}