package codes.methods;

import codes.ADT.*;


public class Gauss{
    
    public static Matrix gauss(Matrix m) {

        for (int j = 0; j < m.cols; j++) {
            for (int i = j + 1; i < m.rows; i++) {
                if (count0(m, j, i) > count0(m, j + 1, i)) {
                    switchRows(m, j, j + 1);
                }
                double pem = m.Mtrx[i][j];
                double pen = m.Mtrx[j][j];
                double factor;
                if (Double.isNaN(pem / pen)) {
                    factor = 1;
                } else {
                    factor = pem / pen;
                }
                for (int k = 0; k < m.cols; k++) {
                    m.Mtrx[i][k] -= ((factor) * m.Mtrx[j][k]);
                }
            }
        }

        return m;
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