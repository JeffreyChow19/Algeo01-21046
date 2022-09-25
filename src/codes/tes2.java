package codes;

import codes.inputs.inputSPL;
import codes.ADT.Matrix;
import codes.ADT.constructors.createMtrxConsole;
import codes.ADT.constructors.printMtrx;
import codes.ADT.primitives.MakeSquare;

public class tes2 {
    public static void main(String[] args) {
        Matrix a = createMtrxConsole.createMatrix();

        a = MakeSquare.makeSquare(a);
        
        printMtrx.printMatrix(a);
    }
}