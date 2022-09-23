package codes.methods;

import codes.ADT.*;

public class InverseGaussJordan extends Gauss{
    public static Matrix inverse (Matrix m) {
        Matrix inversed_mtrx = new Matrix(m.rows, m.cols);
        for (int k = 0; k < m.rows; k++){
            inversed_mtrx.Mtrx[k][k] = 1;
        }
        // Make to echelon row
        for (int j = 0; j < m.cols; j++) {
            for (int i = j + 1; i < m.rows; i++) {
                if (count0(m, j, i) > count0(m, j + 1, i)) {
                    switchRows(m, j, j + 1);
                }
                double pem1 = m.Mtrx[i][j];
                double pen1 = m.Mtrx[j][j];
                double factor;
                // double pem2 = inversed_mtrx.Mtrx[i][j];
                // double pen2 = inversed_mtrx.Mtrx[j][j];
                // double factor1;
                if (Double.isNaN(pem1 / pen1)) {
                    factor = 1;
                } else {
                    factor = pem1 / pen1;
                }
                // Make identity Matrix become echelon row
                for (int k = 0; k < m.cols; k++) {
                    m.Mtrx[i][k] -= ((factor) * m.Mtrx[j][k]);
                    inversed_mtrx.Mtrx[i][k] -= ((factor) * inversed_mtrx.Mtrx[j][k]);
                }
            }
        }

        return null;
    }

}
