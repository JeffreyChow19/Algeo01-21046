package codes.methods;

import java.io.IOException;

import codes.ADT.*;
import codes.ADT.constructors.*;
import codes.inputs.*;
import codes.methods.submethods.SPLCheck;

public class InterpolasiPolinom {
    public static Matrix m;
    public static double polynom(int choice, String pathname, double x) {
        double result = 0.0;
        if (choice == 1){
            m = createMtrxConsole.createMatrix();
        }
        if (choice == 2){
            try {
                m = createMtrxFile.createMatrix(pathname);
            } catch (IOException ex) {
                System.out.println("File not found!");
            }
        }
        m = Gauss.gauss(m); // Error here
            if (SPLCheck.main(m) == 1){
                System.out.println("Solusi yang didapat dari SPL yang diinput adalah tak terhingga.");
            }
            else if (SPLCheck.main(m) == 2){
                System.out.println("SPL yang diinput tidak memiliki solusi unik.");
            }
            else {
                // Get x1,x2,x2,xn from inputSPL
                double[] ans = inputSPL.uniqueCase(m);
                result = polynom(ans, x);
            }
        return result;
    }

    public static double polynom(double[] ans, double x) {
        // Matrix m (Mx2)
        double result = 0.0;
        for (int i = 0; i<ans.length; i++){
            result += ans[i] * Math.pow(x, i);
        }
        return result;
    }
}
