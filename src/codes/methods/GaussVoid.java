package codes.methods;

import codes.ADT.constructors.*;
import codes.ADT.*;

public class GaussVoid extends Gauss {
    public static Matrix gauss(Matrix m) {
        String whitespace = "-";
        for (int h = 0; h <= 100; h++) {
            whitespace += "-";
        }
        int sign = 0;
        for (int k = 0; k < m.rows; k++){
            for (int h = k; h < m.rows; h++){
                if (count0(m, k, m.cols-1) > count0(m, h, m.cols-1)){
                    switchRows(m, k, h);
                    sign++;
                }
            }
        }
        for (int j = 0; j < m.rows; j++) {
            for (int i = j + 1; i < m.rows; i++) {
                // Switch row if current row contains more 0 then next row
                    if (count0(m, j, m.cols-1) > count0(m, j + 1, m.cols-1)) {
                        switchRows(m, j, j + 1);
                        // For -1 power in determinant
                        sign++;
                    }
                printMtrxConsole.printMatrix(m);
                System.out.println(whitespace);
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
                printMtrxConsole.printMatrix(m);
                System.out.println(whitespace);
            }
        }
        m.sign = sign;
        return null;
    }
}
