package codes.methods;


import codes.ADT.*;
import codes.ADT.constructors.printMtrx;
import codes.ADT.constructors.printMtrxConsole;

public class InverseGaussJordan extends Gauss {
    public static Matrix inverse(Matrix m) {
        Matrix inversed_mtrx = new Matrix(m.rows, m.cols);
        for (int k = 0; k < m.rows; k++) {
            inversed_mtrx.Mtrx[k][k] = 1;
        }
        // Make to echelon row
        for (int j = 0; j < m.cols; j++) {
            for (int i = j + 1; i < m.rows; i++) {
                if (count0(m, j, i) > count0(m, j + 1, i)) {
                    switchRows(m, j, j + 1);
                    switchRows(inversed_mtrx, j, j + 1);
                }
                double pem1 = m.Mtrx[i][j];
                double pen1 = m.Mtrx[j][j];
                double factor;
                if (Double.isNaN(pem1 / pen1)) {
                    factor = 1;
                } else {
                    factor = pem1 / pen1;
                }
                // Make Matrix m become echelon row
                for (int k = 0; k < m.cols; k++) {
                    m.Mtrx[i][k] -= ((factor) * m.Mtrx[j][k]);
                    inversed_mtrx.Mtrx[i][k] -= ((factor) * inversed_mtrx.Mtrx[j][k]);
                }
            }
        }
        // Get reverse echelon row m => reduced echelon row
        for (int i = m.rows - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                double factor;
                factor = m.Mtrx[j][i] / m.Mtrx[i][i];
                if (Double.isNaN(factor) || Double.isInfinite(factor)) {
                    factor = 1;
                } else {
                    factor = m.Mtrx[j][i] / m.Mtrx[i][i];
                }
                for (int k = m.cols - 1; k >= 0; k--) {
                    m.Mtrx[j][k] -= (m.Mtrx[i][k] * factor);
                    inversed_mtrx.Mtrx[j][k] -= (inversed_mtrx.Mtrx[i][k] * factor);
                }
            }
        }
        // Make Matrix m -> identity
        for (int i = 0; i < m.rows; i++) {
            if (m.Mtrx[i][i] != 1) {
                double factor;
                if (m.Mtrx[i][i] == 0) {
                    factor = 1;
                } else {
                    factor = m.Mtrx[i][i];
                }
                for (int j = 0; j < m.cols; j++) {
                    inversed_mtrx.Mtrx[i][j] /= factor;
                    m.Mtrx[i][j] /= factor;
                }
            }
        }
        for (int i = 0; i < m.rows; i++){
            if (count0(m, i) == m.cols){
                m.has_inversed = false;
                return m;
            }
        }

        return inversed_mtrx;
    }
    public static int count0(Matrix m, int row){
        int sum = 0;
        for(int j = 0; j < m.cols; j++){
            if (Double.isInfinite(1/m.Mtrx[row][j])){
                sum++;
            }
        }
        return sum;
    }

}
