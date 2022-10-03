package codes.methods;

import codes.ADT.*;
import codes.ADT.primitives.CheckNeg0;

public class Gauss {
    public static Matrix gauss(Matrix m) {
        // Switch initial Matrix if contains a row of 0
        switchRows(m, 0);
        int start_index = firstNotZero(m, 0);
        // Process to echelon row here
        boolean finish_process = false;
        int j = 0;
        int i;
        int min = m.cols <= m.rows ? m.cols : m.rows;
        make_echelon:
            while (j < min && !finish_process) {
                i = j + 1;
                while (i < min && !finish_process) {
                    // Check for remaning rows to tackle NaN
                    if (check0RemainingRows(m, j)){
                        Matrix gaussed_mtrx = new Matrix(m.rows, m.cols);
                        gaussed_mtrx = CheckNeg0.check(m);
                        finish_process = true;
                        return gaussed_mtrx;
                    } else {
                    double pem = m.Mtrx[i][start_index];
                    double pen = m.Mtrx[j][start_index];
                    double factor = 0;
                    if (Double.isInfinite(1 / pen)) {
                        if (!Double.isInfinite(1 / pem)){
                            factor = 1;
                        }
                    } else {
                        factor = pem / pen;
                    }
                    if (factor != 0){
                        for (int k = 0; k < m.cols; k++) {
                            m.Mtrx[i][k] -= ((factor) * m.Mtrx[j][k]);
                        }
                    }
                    }
                    i++;
                }
                start_index++;
                // Switch row if current row contains more 0 then next row
                switchRows(m, j);
                if (isNotFinalEchelon(m) && j == m.cols - 1){
                    j = 0;
                    start_index = firstNotZero(m, 0);
                    continue make_echelon;
                }
                j++;
            }
            
            Matrix gaussed_mtrx = new Matrix(m.rows, m.cols);
            gaussed_mtrx = CheckNeg0.check(m);
            return gaussed_mtrx;
    }

    public static boolean isNotFinalEchelon(Matrix m) {
        int j = 0;
        for (int i = 0; i < m.rows - 1 && j < m.cols ; i++){
            if (!Double.isInfinite(1/m.Mtrx[i][j]) && !Double.isInfinite(1/m.Mtrx[i+1][j])){
                return true;
            }
            j++;
        }
        return false;
    }

    public static int count0(Matrix m, int row, int limit) {
        int count = 0;
        for (int j = 0; j <= limit; j++) {
            if (Double.isInfinite(1.0 / m.Mtrx[row][j])) {
                count++;
            }
        }
        return count;
    }

    public static Boolean check0RemainingRows (Matrix m, int current_row) {
        int count = 0;
        for (int k = current_row; k < m.rows; k++) {
            if (count0(m, k, m.cols - 1) == m.cols) {
                count++;
            }
        }
        if (count == (m.rows - current_row)){
            return true;
        }
        else {
            return false;
        }
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

    public static void switchRows(Matrix m, int start_row) {
        // Switching rows for initial Matrix
        for (int k = 0; k < m.rows; k++) {
            for (int h = k; h < m.rows; h++) {
                if (count0(m, k, m.cols - 1) > count0(m, h, m.cols - 1)) {
                    switchRows(m, k, h);
                    m.sign++;
                }
            }
        }
    }

    public static void switchFor0TrailsFront(Matrix m) {
        for (int k = 0; k < m.rows; k++) {
            for (int h = k; h < m.rows; h++) {
                if (firstNotZero(m, k) > firstNotZero(m, h)) {
                    switchRows(m, k, h);
                    m.sign++;
                }
            }
        }
    }

    public static int firstNotZero(Matrix m, int choosen_row) {
        int i;
        for (i = 0; i < m.cols; i++){
            if (!Double.isInfinite(1/m.Mtrx[choosen_row][i])){
                break;
            }
        }
        return i;
    }
}