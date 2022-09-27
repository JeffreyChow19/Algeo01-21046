package codes.ADT.primitives;

import codes.ADT.Matrix;

public class CheckNeg0 {
    // Check -0.00 for double Matrix
    public static Matrix check(Matrix m) {
        Matrix clean_mtrx = CopyMtrx.copyMtrx(m);
        for (int i = 0; i < m.rows; i++){
            for (int j = 0; j < m.cols; j++){
                if (Double.isInfinite(1/m.Mtrx[i][j])){
                    clean_mtrx.Mtrx[i][j] = 0.00;
                } else {
                    clean_mtrx.Mtrx[i][j] = m.Mtrx[i][j];
                }
            }
        }
        return clean_mtrx;
    }
    // Check -0.00 for double arrays
    public static double[] check(double[] x){
        double[] clean_x = new double[x.length];
        for (int i = 0; i < x.length; i++){
            if (Double.isInfinite(1/x[i])){
                clean_x[i] = 0.00;
            } else {
                clean_x[i] = x[i];
            }
        }
        return clean_x;
    }    
}
