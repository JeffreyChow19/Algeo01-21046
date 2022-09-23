package codes.methods;

import codes.ADT.Matrix;
import codes.ADT.primitives.*;

public class Cramer {
    public static double[] cramer(Matrix m) {
        Matrix squared = MakeSquare.makeSquare(m);

        double det[] = {0};
        double xs[] = { 0 };

        det[0] = determinant.detCofactor(squared, squared.cols, true);
        
        
        for (int i=0; i < squared.rows; i++){
            Matrix temp = SwitchCol.switchCol(squared, m, i, m.cols-1);
            det[i+1] = determinant.detCofactor(temp, temp.rows, true);
            xs[i] = det[i+1]/det[0];
        }

        return xs;
    }
}
