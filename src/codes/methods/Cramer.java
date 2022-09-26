package codes.methods;

import codes.ADT.Matrix;
import codes.ADT.primitives.*;

public class Cramer {
    public static double[] cramer(Matrix m) {
        Matrix squared = MakeSquare.makeSquare(m);

        double[] det = new double[squared.rows+1];
        double[] xs = new double[squared.rows];

        det[0] = determinant.detCofactor(squared, squared.cols, true);

        for (int i=0; i < squared.rows; i++){
            Matrix squared2 = CopyMtrx.copyMtrx(squared);

            Matrix temp = SwitchCol.switchCol(squared2, m, i, m.cols-1);
          
            det[i+1] = determinant.detCofactor(temp, temp.rows, true);
            xs[i] = det[i+1]/det[0];
        }

        return xs;
    }
}
