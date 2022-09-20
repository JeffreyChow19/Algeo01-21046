package codes;

// import codes.ADT.constructor.createMtrx;
import codes.ADT.Matrix;
// import codes.ADT.constructor.Transpose;
import codes.ADT.constructors.*;
import codes.ADT.primitives.determinant;
// import codes.ADT.primitives.*;
import codes.methods.*;
import java.util.Scanner;

public class mainProgram {
    public static void main(String[] args) {
        Matrix matrix = createMtrx.createMatrix();
        // matrix = Transpose.transpose(matrix);
        printMtrx.printMatrix(matrix);
        System.out.println("\n");
        // double timesDiag = TimesDiagonal.timesDiagonal(matrix, IsSquare.isSquare(matrix));
        // System.out.println("Product of diagonal: "+timesDiag);
        System.out.println("Proses OBE : ");
        GaussVoid.gauss(matrix);
        System.out.println();
        System.out.println("Pilih metode pencarian determinan : ");
        System.out.println("[1] Cofactor ");
        System.out.println("[2] Gauss ");
        System.out.println("Choice: ");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        if (choice == 1){
        double detCofac = determinant.detCofactor(matrix, matrix.rows , IsSquare.isSquare(matrix));
        System.out.println("Determinant-Cofactor: "+ detCofac);
        }
        if (choice == 2){
            double detGauss = determinant.detGauss(matrix, IsSquare.isSquare(matrix));
            System.out.println("Determinant-Gauss: "+ detGauss);
        }
        // printMtrx.printMatrix(Gauss.gauss(matrix));

    }
}
