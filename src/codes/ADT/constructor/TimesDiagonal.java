package codes.ADT.constructor;

import codes.ADT.Matrix;

public class TimesDiagonal{
    public static int timesDiagonal(Matrix matrix, boolean isSquare) {
        if (isSquare){
        int i, j, result = 1;
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
            return 0;
        }
    }
}
