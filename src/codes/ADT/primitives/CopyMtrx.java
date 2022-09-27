package codes.ADT.primitives;

import codes.ADT.*;

public class CopyMtrx {
    public static Matrix copyMtrx(Matrix m) {
        Matrix copied_Mtrx = new Matrix(m.rows, m.cols);
        for (int i = 0; i < m.rows; i++){
            for (int j = 0; j < m.cols; j++){
                copied_Mtrx.Mtrx[i][j] = m.Mtrx[i][j];
            }
        }
        return copied_Mtrx;
    }
}
