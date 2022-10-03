package codes.methods;

import codes.ADT.constructors.*;
import codes.ADT.*;

public class GaussVoid extends Gauss {
    public static Matrix gauss(Matrix m) {
        String whitespace = "-";
        for (int h = 0; h <= 100; h++) {
            whitespace += "-";
        }
        switchRows(m, 0);
        printMtrxConsole.printMatrix(m);
        System.out.println("Switched Rows for 0 counter");
        // switchFor0TrailsFront(m);
        printMtrxConsole.printMatrix(m);
        int start_index = firstNotZero(m, 0);
        System.out.println("Switched Rows for nearest not zero position =" + start_index);
        // Process to echelon row here
        for (int j = 0; j < m.cols; j++) {
            for (int i = j + 1; i < m.rows; i++) {
                // Check for remaning rows to tackle NaN
                if (check0RemainingRows(m, j)){
                    // Matrix gaussed_mtrx = new Matrix(m.rows, m.cols);
                    // gaussed_mtrx = CheckNeg0.check(m);
                    return null;
                }
                
                double pem = m.Mtrx[i][start_index];
                double pen = m.Mtrx[j][start_index];
                double factor = 0;
                if (Double.isInfinite(1 / pen)) {
                    if (!Double.isInfinite(1 / pem)){
                        factor = 1;
                    }
                } else {
                    factor = pem / pen;
                }
                if (factor != 0){
                    for (int k = 0; k < m.cols; k++) {
                        m.Mtrx[i][k] -= ((factor) * m.Mtrx[j][k]);
                    }
                }
               
                
            }
            System.out.println("kontol :" + j);
            start_index++;
            // Switch row if current row contains more 0 then next row
            switchRows(m, j);
            
        }
        System.out.println("outside for");
        // printMtrxConsole.printMatrix(m);
        // System.out.println("------------------------");
        // Matrix gaussed_mtrx = new Matrix(m.rows, m.cols);
        // gaussed_mtrx = CheckNeg0.check(m);
        System.out.println("Final");
        printMtrxConsole.printMatrix(m);
        return null;
    }
}
