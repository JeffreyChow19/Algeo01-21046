package codes.inputs;

import codes.ADT.*;
import java.util.Scanner;
import codes.methods.*;
import codes.methods.submethods.*;
import codes.ADT.constructors.*;
import java.io.IOException;
import codes.mainProgram;

public class inputBikubik {
    public static void main() {
        String[] methods = {
            "Console",
            "File txt"
        };
        int inputType = menuCheck.main(1, 2, methods);
        if(inputType == 1){
            Scanner scanner = new Scanner(System.in);
            // System.out.print("Matrix size: ");
            // int size_matrix = scanner.nextInt();
            int size_matrix = 4;
            Matrix matrix = new Matrix(size_matrix+1, size_matrix);
            System.out.println("Input your matrix: ");
            int i, j;
            for(i=0; i<size_matrix+1; i++){
                if(i== size_matrix){
                    matrix.Mtrx[size_matrix][0] = scanner.nextDouble();
                    matrix.Mtrx[size_matrix][1] = scanner.nextDouble();
                }else{
                    for(j=0; j<size_matrix; j++){
                        matrix.Mtrx[i][j]= scanner.nextDouble();
                    }
                }
            }
            // System.out.println("Input function arguments");
            // System.out.print("x = ");
            // double indeks1 = scanner.nextDouble();
            // scanner.nextLine();
            // System.out.print("y = ");
            // double indeks2 = scanner.nextDouble();
            // scanner.nextLine();
            double ans = InterpolasiBicubic.bikubik(matrix, matrix.Mtrx[size_matrix][0], matrix.Mtrx[size_matrix][1]);
            String args = "f("+matrix.Mtrx[size_matrix][0]+","+matrix.Mtrx[size_matrix][1]+") = ";
            printMtrx.main(args, ans);
        }else{
            try {
                // Get Matrix from txt
                Matrix matrix;
                Scanner scanner = new Scanner(System.in);
                System.out.print("File name: ");
                String pathname = scanner.nextLine();
                String base = "../test/";
                matrix = createMtrxFile.createMatrixv2(base + pathname);
                // System.out.println("Input function arguments");
                // System.out.print("x = ");
                // double indeks1 = scanner.nextDouble();
                // scanner.nextLine();
                // // System.out.print("y = ");
                // double indeks2 = scanner.nextDouble();
                // scanner.nextLine();
                String args = "f("+matrix.Mtrx[matrix.rows-1][0]+","+matrix.Mtrx[matrix.rows-1][1]+") = ";
                double ans = InterpolasiBicubic.bikubik(matrix, matrix.Mtrx[matrix.rows-1][0], matrix.Mtrx[matrix.rows-1][1]);
                printMtrx.main(args, ans);
            } catch (IOException ex) {
                System.out.println("File not found!");
                System.out.println("\nPress enter key to continue");
                try {
                    System.in.read();
                } catch (Exception e) {}
                String[] args = {""};
                mainProgram.main(args);
            }
        }
    }
}
