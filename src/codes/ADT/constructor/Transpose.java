package codes.ADT.constructor;

import codes.ADT.Matrix;

public class Transpose {
    public static Matrix transpose(Matrix matrix){
        Matrix transpose = new Matrix(matrix.cols, matrix.rows);
        int i, j;
        for (i = 0; i < transpose.rows; i++){
            for (j = 0; j < transpose.cols; j++){
                transpose.Mtrx[i][j] = matrix.Mtrx[j][i];
            }
        }
        return transpose;
    }
}
