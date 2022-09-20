package codes.methods;

import codes.ADT.*;

public class Gauss {
    public static Matrix gauss(Matrix m) {

        for (int j = 0; j < m.cols; j++) {
            for (int i = j + 1; i < m.rows; i++) {
                double pem = m.Mtrx[i][j];
                double pen = m.Mtrx[j][j];
                double factor;
                // precision to 4 decimals
                if (pen <= 0 && pen >= -0.00009) {
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
}