package codes;

import codes.ADT.constructor.createMtrx;
import codes.ADT.Matrix;

public class mainProgram {
    public static void main(String[] args) {
        Matrix matrix = createMtrx.createMatrix();
        createMtrx.printMatrix(matrix);
    }
}
