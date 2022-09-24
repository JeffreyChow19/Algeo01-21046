package codes.ADT.primitives;

import codes.ADT.Matrix;
import codes.ADT.constructors.*;

public class MakeSquare {
    public static Matrix makeSquare(Matrix m) {
        int dimension = m.rows;

        Matrix square = createMtrxConsole.createMatrix();
        
        for (int i=0; i < dimension; i++){
            for (int j=0; j < dimension; j++){
                square.Mtrx[i][j] = m.Mtrx[i][j];
            }
        }
        
        return square;
    }
}