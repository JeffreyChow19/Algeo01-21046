package codes.methods;

import codes.ADT.constructors.*;
import codes.ADT.*;

public class GaussVoid extends Gauss {
    public static Matrix gauss(Matrix m) {
        String whitespace = "-";
        for (int h = 0; h <= 100; h++) {
            whitespace += "-";
        }
        for (int j = 0; j < m.cols; j++) {
            for (int i = j + 1; i < m.rows; i++) {
                if (count0(m, j, i) > count0(m, j + 1, i)) {
                    switchRows(m, j, j + 1);
                }
                double pem = m.Mtrx[i][j];
                double pen = m.Mtrx[j][j];
                double factor;

                if (Double.isFinite(pem / pen)) {
                    factor = pem / pen;
                } else {
                    factor = 1;
                }
                for (int k = 0; k < m.cols; k++) {
                    m.Mtrx[i][k] -= ((factor) * m.Mtrx[j][k]);
                }
                printMtrxConsole.printMatrix(m);
                System.out.println(whitespace);
            }
        }
        return null;
    }
}
