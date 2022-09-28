package codes.inputs;

import java.util.*;
import codes.methods.*;
import codes.ADT.constructors.createMtrx;
import codes.methods.submethods.*;
import codes.ADT.*;
import codes.ADT.constructors.*;
import java.io.IOException;

public class inputPolynom extends createMtrx {
    public static void main(String[] args) {
        Matrix matrix;
        double result;
        matrix = main(false);
        result = InterpolasiPolinom.polynom(matrix);
        System.out.printf("Hasil Interpolasi di x = "+matrix.polynom_x+" adalah: %.5f", result);
    }

    public static Matrix main(boolean square){
        System.out.println("Input Types:");

        String[] methods = {
            "Console",
            "File txt"
        };
        Matrix m;
        double x;
        int inputType = menuCheck.main(1, 2, methods);
        Scanner in = new Scanner(System.in);
        if (inputType == 1){
            System.out.print("Masukkan n: ");
            int n = in.nextInt();
            in.nextLine();
            m = new Matrix(n, 2);
            // Fill Matrix
            for (int k = 0; k < n; k++){
                    System.out.print("Input(x"+k+"): ");
                    m.Mtrx[k][0] = in.nextDouble();
                    in.nextLine();
                    System.out.print("Input(y"+k+"): ");
                    m.Mtrx[k][1] = in.nextDouble();
                    in.nextLine();
            }
            System.out.printf("Input nilai x untuk taksiran: ");
            x = in.nextDouble();
            in.nextLine();
            m.polynom_x = x;
            return m;
        } else {
            try {
                // Get Matrix from txt
                System.out.printf("File name: ");
                String pathname = in.nextLine();
                String base = "../files/";
                m = createMtrxFile.createMatrix(base + pathname);
                System.out.printf("Input nilai x untuk taksiran: ");
                x = in.nextDouble();
                in.nextLine();
                m.polynom_x = x;
                return m;
            } catch (IOException ex) {
                System.out.println("File not found!");
                return null;
            }
        }
    }
    }
