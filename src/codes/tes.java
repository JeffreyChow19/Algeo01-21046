package codes;

import codes.ADT.constructors.createMtrx;
import codes.ADT.constructors.createMtrxFile;
import codes.ADT.constructors.printMtrx;
import codes.ADT.constructors.printMtrxConsole;
import codes.inputs.inputSPL;
import codes.methods.Gauss;
import codes.methods.GaussJordan;
import codes.methods.RegresiLinierBerganda;

import java.io.IOException;

import codes.ADT.Matrix;
import codes.ADT.Param;

public class tes {
    public static void main(String[] args) {
        Matrix m = createMtrx.main(false);
        // printMtrxConsole.printMatrix(m);
        System.out.println();
        
        inputSPL.infiniteCase(Gauss.gauss(m));
        // printMtrxConsole.printMatrix(ans);
    }
}
