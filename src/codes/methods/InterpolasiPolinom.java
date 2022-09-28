package codes.methods;

import codes.ADT.*;
import codes.inputs.*;
import codes.methods.submethods.SPLCheck;

public class InterpolasiPolinom extends Gauss{
    // public static Matrix m;

    public static double polynom(Matrix m) {
        double result = 0.0;
        // Make the given point (xn,yn) to Matrix
        int power = 0;
        int m_idx_rows = 0, m_idx_cols = 0;
        Matrix raw_mtrx = new Matrix(m.rows, m.rows + 1);
        for (int i = 0; i < raw_mtrx.rows; i++) {
            for (int j = 0; j < raw_mtrx.cols; j++) {
                if ( j < raw_mtrx.cols - 1 ){
                    raw_mtrx.Mtrx[i][j] = Math.pow(m.Mtrx[m_idx_rows][m_idx_cols], power);
                    power++;
                } else {
                    m_idx_cols++;
                    raw_mtrx.Mtrx[i][j] = m.Mtrx[m_idx_rows][m_idx_cols];
                }
            }
            m_idx_rows++;
            m_idx_cols = 0;
            power = 0;    
        }
        // raw_mtrx initialized
        Matrix spl = gauss(raw_mtrx); // Make echelon row
        // Check SPL
        if (SPLCheck.main(spl) == 1) {
            System.out.println("Solusi yang didapat dari SPL yang diinput adalah tak terhingga.");
        } else if (SPLCheck.main(spl) == 2) {
            System.out.println("SPL yang diinput tidak memiliki solusi unik.");
        } else {
            // Get x1,x2,x2,xn from inputSPL
            double[] ans = inputSPL.uniqueCase(spl);
            // Interpolate ans
            result = polynom(ans, m.polynom_x);
        }
        return result;
    }

    public static double polynom(double[] ans, double x) {
        // Matrix m (Mx2)
        double result = 0.0;
        for (int i = 0; i < ans.length; i++) {
            result += ans[i] * Math.pow(x, i);
        }
        return result;
    }
}
