package codes.ADT.constructor;

import codes.ADT.Matrix;

public class IsSquare {
    public static boolean isSquare (Matrix matrix){
        return (matrix.rows == matrix.cols);
    }
}
