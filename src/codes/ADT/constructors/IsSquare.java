package codes.ADT.constructors;

import codes.ADT.Matrix;

public class IsSquare {
    public static boolean isSquare (Matrix matrix){
        return (matrix.rows == matrix.cols);
    }
}
