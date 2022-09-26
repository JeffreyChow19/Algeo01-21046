package codes;

// import codes.ADT.constructor.createMtrx;
import codes.ADT.Matrix;
// import codes.ADT.constructor.Transpose;
import codes.ADT.constructors.*;
// import codes.ADT.primitives.*;
import codes.methods.*;
import codes.inputs.*;

import java.util.Scanner;

public class testProgram {
    public static void main(String[] args) {
        Matrix m = createMtrxConsole.createMatrix();
        // matrix = Transpose.transpose(matrix);
        // Matrix matrix2 = new Matrix(matrix.rows, matrix.cols);
        // Matrix matrix3 = new Matrix(matrix.rows, matrix.cols);
        // // Templates
        // printMtrx.printMatrix(matrix);
        // matrix2 = CopyMtrx.copyMtrx(matrix);
        // System.out.println("\n");
        // // System.out.println("Proses OBE : ");
        // // GaussVoid.gauss(matrix);
        // matrix = CopyMtrx.copyMtrx(matrix2);
        // matrix3 = CopyMtrx.copyMtrx(matrix2);
        // matrix3 = GaussJordan.jordan(matrix3);
        // System.out.println("Hasil dengan Gauss-Jordan:");
        // printMtrx.printMatrix(matrix3);
        // System.out.println("Pilih metode pencarian determinan : ");
        // System.out.println("[1] Cofactor ");
        // System.out.println("[2] Gauss ");
        // System.out.println("[3] Gauss-Jordan ");
        // System.out.println("Choice: ");
        // Scanner scanner = new Scanner(System.in);
        // int choice = scanner.nextInt();
        // if (choice == 1) {
        //     double detCofac = determinant.detCofactor(matrix2, matrix2.rows, IsSquare.isSquare(matrix));
        //     System.out.println("Determinant-Cofactor: " + detCofac);
        // }
        // if (choice == 2) {
        //     double detGauss = determinant.detGauss(matrix2, IsSquare.isSquare(matrix));
        //     System.out.println("Determinant-Gauss: " + detGauss);
        // }
        // if (choice == 3) {
        //     double detGaussJordan = determinant.detGaussJordan(matrix2, IsSquare.isSquare(matrix));
        //     System.out.println("Determinant-Gauss-Jordan: " + detGaussJordan);
        // }
        // System.out.println("Inverse Matrix? (1/0): ");
        // int choice_2 = scanner.nextInt();
        // scanner.nextLine();
        // Matrix m = new Matrix(matrix.rows, matrix.cols);
        // if (choice_2 == 1) {
        //     System.out.println("Pilih metode pencarian inverse: ");
        //     System.out.println("[1] Gauss-Jordan");
        //     System.out.println("[2] Cofactor");
        //     choice_2 = scanner.nextInt();
        //     if (choice_2 == 1){
        //         m = InverseGaussJordan.inverse(matrix);
        //         printMtrx.printMatrix(m);
        //     } else {
        //         m = InverseCofactor.inverse(matrix);
        //         printMtrx.printMatrix(m);
        //     }
        // } else {
        //     System.exit(1);
        // }
        // scanner.close();
        // double result = InterpolasiPolinom.polynom(2, "files/test1.txt", 9.2);
        // System.out.println("Res: "+result);
            m = Gauss.gauss(m);
            printMtrxConsole.printMatrix(m);

        // Templates

        // printMtrx.printMatrix(Gauss.gauss(matrix));

    }
}
