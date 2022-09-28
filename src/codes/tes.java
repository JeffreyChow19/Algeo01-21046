package codes;

import codes.ADT.constructors.createMtrx;
import codes.ADT.constructors.printMtrx;
import codes.inputs.inputSPL;
import codes.methods.Gauss;
import codes.methods.GaussJordan;
import codes.ADT.Matrix;

public class tes {
    public static void main(String[] args) {
        Matrix m = createMtrx.main(false);
        m = Gauss.gauss(m);
        printMtrx.main(m);

    }
}
