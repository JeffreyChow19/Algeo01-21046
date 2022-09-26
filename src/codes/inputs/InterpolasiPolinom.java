package codes.inputs;

import java.io.IOException;

import codes.ADT.*;
import codes.ADT.constructors.*;
import codes.ADT.primitives.*;
import codes.inputs.*;
import codes.methods.*;
import java.math.*;

import javax.management.MBeanTrustPermission;

public class InterpolasiPolinom {
    public static Matrix m;
    public static double polynom(int choice, String pathname) {
        double result = 0.0;
        if (choice == 1){
            Matrix m = createMtrxConsole.createMatrix();
        }
        if (choice == 2){
            try {
                Matrix m = createMtrxFile.createMatrix(pathname);
            } catch (IOException ex) {
                System.out.println("File not found!");
            }
        }
        m = Gauss.gauss(m);
            if (SPLCheck.main(m) == 1){
                System.out.println("Solusi yang didapat dari SPL yang diinput adalah tak terhingga.");
            }
            else if (SPLCheck.main(m) == 2){
                System.out.println("SPL yang diinput tidak memiliki solusi unik.");
            }
            else {
                // Get x1,x2,x2,xn from inputSPL
            }

        return result;
    }

    public static double polynom(Matrix m, double x) {
        // Matrix m (Mx2)
        double result = 0.0;
        for (int i = 0; i<m.Mtrx.length; i++){
            result += m.Mtrx[1][i] * Math.pow(x, i);
        }
        return result;
    }
}
