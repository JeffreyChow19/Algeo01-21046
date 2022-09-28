package codes.methods;

import codes.ADT.*;

public class InverseGaussJordan extends Gauss {
    public static Matrix inverse(Matrix m) {
        Matrix inversed_mtrx = new Matrix(m.rows, m.cols);
        for (int k = 0; k < m.rows; k++) {
            inversed_mtrx.Mtrx[k][k] = 1;
        }
        // Make to echelon row
        for (int k = 0; k < m.rows; k++) {
            for (int h = k; h < m.rows; h++) {
                if (count0(m, k, m.cols - 1) > count0(m, h, m.cols - 1)) {
                    switchRows(m, k, h);
                    switchRows(inversed_mtrx, k, h);
                }
            }
        }
        // Process to echelon row here
        for (int j = 0; j < m.rows; j++) {
            for (int i = j + 1; i < m.rows; i++) {
                // Switch row if current row contains more 0 then next row
                if (count0(m, j, m.cols - 1) > count0(m, j + 1, m.cols - 1)) {
                    switchRows(m, j, j + 1);
                    switchRows(inversed_mtrx, j, j + 1);
                }
                double pem = m.Mtrx[i][j];
                double pen = m.Mtrx[j][j];
                double factor;
                if (Double.isInfinite(1 / pen)) {
                    factor = 1;
                } else {
                    factor = pem / pen;
                }
                if (Double.isNaN(pem / pen)) {
                    factor = m.Mtrx[i][j + 1] / m.Mtrx[j][j + 1];
                }
                for (int k = 0; k < m.cols; k++) {
                    m.Mtrx[i][k] -= ((factor) * m.Mtrx[j][k]);
                    inversed_mtrx.Mtrx[i][k] -= ((factor) * inversed_mtrx.Mtrx[j][k]);
                }
            }
        }
        // Get reverse echelon row m => reduced echelon row
        for (int i = m.rows - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                double factor = 0;
                int c = i;
                if (Double.isInfinite(1/m.Mtrx[i][c])) {
                    boolean condition = false;
                    while (!condition) {
                        if (c < m.cols - 1 && Double.isInfinite(1/m.Mtrx[i][c])) {
                            c++;
                        } else if (c < m.cols - 1 && !Double.isInfinite(1/m.Mtrx[i][c])) {
                            factor = m.Mtrx[j][c] / m.Mtrx[i][c];
                            condition = true;
                        } else {
                            factor = 1;
                            condition = true;
                        }
                    }
                } else {
                    factor = m.Mtrx[j][c] / m.Mtrx[i][c];
                }
                for (int k = m.cols - 1; k >= 0; k--) {
                    m.Mtrx[j][k] -= (m.Mtrx[i][k] * factor);
                    inversed_mtrx.Mtrx[j][k] -= (inversed_mtrx.Mtrx[i][k] * factor);
                    // printMtrxConsole.printMatrix(temp);
                    // System.out.println();
                }
            }
        }
        for (int i = 0; i < m.rows; i++) {
            int c = i;
            double factor = 0;
            if (m.Mtrx[i][c] != 1 && Double.isInfinite(1/m.Mtrx[i][c])) {
                // double factor=0;
                if (Double.isInfinite(1/m.Mtrx[i][c])) {
                    boolean condition = false;
                    while (!condition) {
                        if (c < m.cols - 1 && Double.isInfinite(1/m.Mtrx[i][c])) {
                            c++;
                        } else if (c < m.cols - 1 && !Double.isInfinite(1/m.Mtrx[i][c])) {
                            factor = m.Mtrx[i][c];
                            condition = true;
                        } else {
                            factor = 1;
                            condition = true;
                        }
                    }
                }
            } else {
                factor = m.Mtrx[i][c];
            }
            for (int j = 0; j < m.cols; j++) {
                m.Mtrx[i][j] /= factor;
                inversed_mtrx.Mtrx[i][j] /= factor;
            }
        }
        for (int i = 0; i < m.rows; i++) {
            if (count0(m, i) == m.cols) {
                m.has_inversed = false;
                return m;
            }
        }

        return inversed_mtrx;
    }

    public static int count0(Matrix m, int row) {
        int sum = 0;
        for (int j = 0; j < m.cols; j++) {
            if (Double.isInfinite(1 / m.Mtrx[row][j])) {
                sum++;
            }
        }
        return sum;
    }

}
