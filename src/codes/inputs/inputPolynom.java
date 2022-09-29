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
            String args = "Hasil Interpolasi di x = "+matrix.polynom_x+" adalah";
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
                m = createMtrxFile.createMatrix(base + pathname);
                print("Input nilai x untuk taksiran: ");
                x = in.nextDouble();
                in.nextLine();
                m.polynom_x = x;
                return m;
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
    // public static String superscript(String str) {
    //     str = str.replaceAll("2", "\u00b2");
    //     str = str.replaceAll("3", "\u00b3");
    //     str = str.replaceAll("4", "\u2074");
    //     str = str.replaceAll("5", "\u2075");
    //     str = str.replaceAll("6", "\u2076");
    //     str = str.replaceAll("7", "\u2077");
    //     str = str.replaceAll("8", "\u2078");
    //     str = str.replaceAll("9", "\u2079");         
    //     return str;
    // }
    }
