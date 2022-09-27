package codes.ADT.primitives;

import codes.ADT.Matrix;

public class TimesDiagonal{
    public static double timesDiagonal(Matrix matrix, boolean isSquare) {
        if (isSquare){
        int i, j;
        double result = 1;
        for (i = 0; i < matrix.rows ; i++){
            for (j = 0; j < matrix.cols ; j++){
                if (i == j){
                    result *= matrix.Mtrx[i][j];
                }
            }
        }
        return result;
        }
        else{
            return -9999;
        }
    }
}
