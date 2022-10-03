package codes.inputs;

import java.util.*;
import codes.methods.*;
import codes.methods.submethods.*;
import codes.ADT.*;
import codes.ADT.constructors.*;
import java.io.IOException;
import codes.mainProgram;

public class inputPolynom extends printMtrxConsole {
    private static double result;
    public static void main() {
        Matrix matrix;
        double[] ans;
        matrix = main(false);
        // Get ans from polynom
        ans = InterpolasiPolinom.polynom(matrix);
        if (ans[0] == 999.999){
            println("Tidak dapat membentuk persamaan interpolasi polinom karena titik yang diinput menghasilkan solusi SPL yang tak terhingga.");
        } 
        else if (ans[0] == -999.999) {
            println("Tidak dapat membentuk persamaan interpolasi polinom karena titik yang diinput menghasilkan tidak menghasilkan solusi pada SPL.");
        } 
        else {
            result = InterpolasiPolinom.polynom(ans, matrix.polynom_x);
            String args = "f("+matrix.polynom_x+")";
            printMtrx.main(ans, result, matrix.polynom_x, args);
        }
        
    }

    public static Matrix main(boolean square){
        println("Input Types:");

        String[] methods = {
            "Console",
            "File txt"
        };
        Matrix m;
        double x;
        int inputType = menuCheck.main(1, 2, methods);
        Scanner in = new Scanner(System.in);
        if (inputType == 1){
            print("Masukkan n: ");
            int n = in.nextInt();
            in.nextLine();
            m = new Matrix(n, 2);
            // Fill Matrix
            for (int k = 0; k < n; k++){
                    print("Input(x"+k+"): ");
                    m.Mtrx[k][0] = in.nextDouble();
                    in.nextLine();
                    print("Input(y"+k+"): ");
                    m.Mtrx[k][1] = in.nextDouble();
                    in.nextLine();
            }
            print("Input nilai x untuk taksiran: ");
            x = in.nextDouble();
            in.nextLine();
            m.polynom_x = x;
            return m;
        } else {
            try {
                // Get Matrix from txt
                print("File name: ");
                String pathname = in.nextLine();
                String base = "../test/";
                m = createMtrxFile.createMatrixv2(base + pathname);
                Matrix matrix = new Matrix(m.rows-1, m.cols);
                // print("Input nilai x untuk taksiran: ");
                // x = in.nextDouble();
                // in.nextLine();
                for (int i = 0; i < m.rows - 1; i++){
                    for (int j = 0; j < m.cols; j++){
                        matrix.Mtrx[i][j] = m.Mtrx[i][j];
                    }
                }
                matrix.polynom_x = m.Mtrx[m.rows-1][0];
                return matrix;
            } catch (IOException ex) {
                println("File not found!");
                println("\nPress enter key to continue");
                try {
                    System.in.read();
                } catch (Exception e) {}
                String[] args = {""};
                mainProgram.main(args);
                return null;
            }
        }
    }
}
