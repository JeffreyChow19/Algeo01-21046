package codes.ADT.primitives;

import codes.ADT.Matrix;

public class SwitchCol {
    public static Matrix switchCol(Matrix m1, Matrix m2, int cols1, int cols2) {
        /* Pasting m1 cols1 with m2 cols2 */
        for (int i=0; i < m1.rows; i++){
            m1.Mtrx[i][cols1] = m2.Mtrx[i][cols2];
        }
        return m1;
    }
}
